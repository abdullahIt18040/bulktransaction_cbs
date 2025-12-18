package com.sil.bulktranactionloginapp.services;

import com.sil.bulktranactionloginapp.entities.BulkErrorLog;
import com.sil.bulktranactionloginapp.repositors.BulkErrorLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

@Service
public class BulkErrorLogService {

    private final BulkErrorLogRepository repository;

    public BulkErrorLogService(BulkErrorLogRepository repository) {
        this.repository = repository;
    }


    public void logErrorAsync(Throwable ex,
                              HttpStatus status,String path, String error) {

        try {
            BulkErrorLog log = new BulkErrorLog();

            log.setErrorMessage(
                    ex.getMessage() != null
                            ? ex.getMessage()
                            : "Unexpected error"
            );

            // ERROR_CODE → HTTP status or app code
            log.setErrorCode(String.valueOf(status.value()));

            log.setSeverity(resolveSeverity(status));

            log.setStackTrace(getStackTrace(ex));
            log.setPath(path);      // request URI
            log.setError(error);    // error class name
            log.setTimestamp(LocalDateTime.now());

            repository.save(log);

        } catch (Exception e) {
            // NEVER break request flow
            System.err.println("Failed to persist error log");
        }
    }

    private String resolveSeverity(HttpStatus status) {
        if (status.is5xxServerError()) return "CRITICAL";
        if (status.is4xxClientError()) return "WARNING";
        return "INFO";
    }

    private String getStackTrace(Throwable ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}

