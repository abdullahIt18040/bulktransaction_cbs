package com.sil.bulktranactionloginapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BULK_ERROR_LOG", schema = "SBBD_IUT")
public class BulkErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bulk_err_seq")
    @SequenceGenerator(
            name = "bulk_err_seq",
            sequenceName = "SBBD_IUT.BULK_ERROR_LOG_SEQ",
            allocationSize = 1
    )

    private Long id;

    @Column(name = "ERROR_MESSAGE", nullable = false, length = 255)
    private String errorMessage;

    @Column(name = "ERROR_CODE", length = 50)
    private String errorCode;

    @Lob
    @Column(name = "STACK_TRACE")
    private String stackTrace;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    @Column(name = "SEVERITY", length = 20)
    private String severity;

    @Column(name = "PATH", length = 255)
    private String path;  // add this field

    // getter & setter
    public String getPath() {
        return path;
    }
    @Column(name = "ERROR", length = 100)
    private String error;  // add this field

    // getter & setter
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}