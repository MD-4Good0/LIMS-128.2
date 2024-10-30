package com.backend.lims.repository;

import com.backend.lims.model.ChemTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChemRepository extends JpaRepository<ChemTestResults, Long> {
    Optional<ChemTestResults> findBySampleId(Long sampleId);
}
