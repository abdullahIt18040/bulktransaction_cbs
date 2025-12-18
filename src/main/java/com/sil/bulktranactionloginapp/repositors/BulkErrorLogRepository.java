package com.sil.bulktranactionloginapp.repositors;

import com.sil.bulktranactionloginapp.entities.BulkErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulkErrorLogRepository
        extends JpaRepository<BulkErrorLog, Long> {
}