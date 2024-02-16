package com.isteer.dcm.repository;

import com.isteer.dcm.entity.LogTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface LogRepository extends JpaRepository<LogTable, Long> {

}
