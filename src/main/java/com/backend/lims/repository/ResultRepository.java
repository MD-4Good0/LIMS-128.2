package com.backend.lims.repository;

import com.backend.lims.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findByResultId(Long resultId);
    Result findByRequestId(Long requestId);
}