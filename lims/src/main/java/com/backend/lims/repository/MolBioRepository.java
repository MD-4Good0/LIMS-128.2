package com.backend.lims.repository;

import com.backend.lims.model.ChemTestResults;
import com.backend.lims.model.MolBioTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MolBioRepository extends JpaRepository<MolBioTestResults, Long> {
    Optional<MolBioTestResults> findBySampleId(Long sampleId);
}