package com.backend.lims.repository;

import com.backend.lims.model.MicrobioTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MicrobioRepository extends JpaRepository<MicrobioTestResults, Long> {
    Optional<MicrobioTestResults> findBySampleId(Long sampleId);

    @Query("SELECT COALESCE(m.standardPlateCount, 'UNKNOWN'), COUNT(m.standardPlateCount) FROM MicrobioTestResults m GROUP BY m.standardPlateCount")
    List<Object[]> countUniqueStandardPlateCount();

    @Query("SELECT COALESCE(m.staphylococcusAureus, 'UNKNOWN'), COUNT(m.staphylococcusAureus) FROM MicrobioTestResults m GROUP BY m.staphylococcusAureus")
    List<Object[]> countUniqueStaphylococcusAureus();

    @Query("SELECT COALESCE(m.salmonellaSp, 'UNKNOWN'), COUNT(m.salmonellaSp) FROM MicrobioTestResults m GROUP BY m.salmonellaSp")
    List<Object[]> countUniqueSalmonellaSp();

    @Query("SELECT COALESCE(m.campylobacter, 'UNKNOWN'), COUNT(m.campylobacter) FROM MicrobioTestResults m GROUP BY m.campylobacter")
    List<Object[]> countUniqueCampylobacter();

    @Query("SELECT COALESCE(m.cultureAndSensitivityTest, 'UNKNOWN'), COUNT(m.cultureAndSensitivityTest) FROM MicrobioTestResults m GROUP BY m.cultureAndSensitivityTest")
    List<Object[]> countUniqueCultureAndSensitivityTest();

    @Query("SELECT COALESCE(m.coliformCount, 'UNKNOWN'), COUNT(m.coliformCount) FROM MicrobioTestResults m GROUP BY m.coliformCount")
    List<Object[]> countUniqueColiformCount();

    @Query("SELECT COALESCE(m.eColi, 'UNKNOWN'), COUNT(m.eColi) FROM MicrobioTestResults m GROUP BY m.eColi")
    List<Object[]> countUniqueEColi();

    @Query("SELECT COALESCE(m.eColiAndeColi0O157, 'UNKNOWN'), COUNT(m.eColiAndeColi0O157) FROM MicrobioTestResults m GROUP BY m.eColiAndeColi0O157")
    List<Object[]> countUniqueEColiAndeColi0O157();

    @Query("SELECT COALESCE(m.yeastAndMolds, 'UNKNOWN'), COUNT(m.yeastAndMolds) FROM MicrobioTestResults m GROUP BY m.yeastAndMolds")
    List<Object[]> countUniqueYeastAndMolds();
}