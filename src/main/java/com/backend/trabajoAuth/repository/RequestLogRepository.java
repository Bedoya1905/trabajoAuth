package com.backend.trabajoAuth.repository;

import com.backend.trabajoAuth.models.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
