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

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.standardPlateCountAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.standardPlateCountAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.standardPlateCountAnalysisDate), EXTRACT(MONTH FROM m.standardPlateCountAnalysisDate)")
    List<Object[]> countStandardPlateCountByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.staphylococcusAureusAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.staphylococcusAureusAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.staphylococcusAureusAnalysisDate), EXTRACT(MONTH FROM m.staphylococcusAureusAnalysisDate)")
    List<Object[]> countStaphylococcusAureusByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.salmonellaSpAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.salmonellaSpAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.salmonellaSpAnalysisDate), EXTRACT(MONTH FROM m.salmonellaSpAnalysisDate)")
    List<Object[]> countSalmonellaSpByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.campylobacterAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.campylobacterAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.campylobacterAnalysisDate), EXTRACT(MONTH FROM m.campylobacterAnalysisDate)")
    List<Object[]> countCampylobacterByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.cultureAndSensitivityTestAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.cultureAndSensitivityTestAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.cultureAndSensitivityTestAnalysisDate), EXTRACT(MONTH FROM m.cultureAndSensitivityTestAnalysisDate)")
    List<Object[]> countCultureAndSensitivityTestByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.coliformCountAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.coliformCountAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.coliformCountAnalysisDate), EXTRACT(MONTH FROM m.coliformCountAnalysisDate)")
    List<Object[]> countColiformCountByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.eColiAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.eColiAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.eColiAnalysisDate), EXTRACT(MONTH FROM m.eColiAnalysisDate)")
    List<Object[]> countEColiByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.eColiAndeColi0O157AnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.eColiAndeColi0O157AnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.eColiAndeColi0O157AnalysisDate), EXTRACT(MONTH FROM m.eColiAndeColi0O157AnalysisDate)")
    List<Object[]> countEColiAndEColi0O157ByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.yeastAndMoldsAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.yeastAndMoldsAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MicrobioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.yeastAndMoldsAnalysisDate), EXTRACT(MONTH FROM m.yeastAndMoldsAnalysisDate)")
    List<Object[]> countYeastAndMoldsByMonthAndYear();
}