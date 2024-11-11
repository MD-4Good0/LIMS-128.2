package com.backend.lims.repository;

import com.backend.lims.model.MicrobioTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MicrobioRepository extends JpaRepository<MicrobioTestResults, Long> {
    Optional<MicrobioTestResults> findBySampleId(Long sampleId);
}
