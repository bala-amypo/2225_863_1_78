package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.TaskRecord;

public interface TaskRecordRepository
        extends JpaRepository<TaskRecord, Long> {

    List<TaskRecord> findByStatus(String status);
}