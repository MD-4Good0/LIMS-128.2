package com.backend.lims.repository;

import com.backend.lims.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    List<Sample> findByRequestRequestId(Long requestId);

    @Query("SELECT s.sampleId FROM Sample s WHERE s.request.requestId = :requestId")
    List<Long> findSampleIdsByRequestId(@Param("requestId") Long requestId);
}