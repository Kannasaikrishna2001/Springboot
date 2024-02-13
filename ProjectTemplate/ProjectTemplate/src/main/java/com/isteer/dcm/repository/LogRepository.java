package com.isteer.dcm.repository;

import com.isteer.dcm.entity.LogTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface LogRepository extends JpaRepository<LogTable, Long> {
//    @Transactional
//    @Query(value = "INSERT INTO logdata (process_name, start_date_time, process_id, error_message, stack_trace, status, request, response) VALUES (:processName, :startDateTime, :processId, :errorMessage, :stackTrace, :status, :request, :response)", nativeQuery = true)
//    void insertLog(String processName, LocalDateTime startDateTime, String processId, String errorMessage, String stackTrace, String status, String request, String response);
//
//    void insertLog(LogTable logEntry);
}
