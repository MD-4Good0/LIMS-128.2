package com.backend.lims.repository;

import com.backend.lims.model.ChemTestResults;
import com.backend.lims.model.MicrobialTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MicrobialRepository extends JpaRepository<MicrobialTestResults, Long> {
    Optional<MicrobialTestResults> findBySampleId(Long sampleId);
}