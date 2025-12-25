package com.example.demo.repository;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.*;

public interface AssignmentEvaluationRecordRepository {
    List<AssignmentEvaluationRecord> findByAssignmentId(Long id);
    AssignmentEvaluationRecord save(AssignmentEvaluationRecord e);
}
