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

    @Query("SELECT COALESCE(m.standardPlateCountRemarks, 'UNKNOWN'), COUNT(m.standardPlateCountRemarks) FROM MicrobioTestResults m GROUP BY m.standardPlateCountRemarks")
    List<Object[]> countUniqueStandardPlateCount();

    @Query("SELECT COALESCE(m.staphylococcusAureusRemarks, 'UNKNOWN'), COUNT(m.staphylococcusAureusRemarks) FROM MicrobioTestResults m GROUP BY m.staphylococcusAureusRemarks")
    List<Object[]> countUniqueStaphylococcusAureus();

    @Query("SELECT COALESCE(m.salmonellaSpRemarks, 'UNKNOWN'), COUNT(m.salmonellaSpRemarks) FROM MicrobioTestResults m GROUP BY m.salmonellaSpRemarks")
    List<Object[]> countUniqueSalmonellaSp();

    @Query("SELECT COALESCE(m.campylobacterRemarks, 'UNKNOWN'), COUNT(m.campylobacterRemarks) FROM MicrobioTestResults m GROUP BY m.campylobacterRemarks")
    List<Object[]> countUniqueCampylobacter();

    @Query("SELECT COALESCE(m.cultureAndSensitivityTestRemarks, 'UNKNOWN'), COUNT(m.cultureAndSensitivityTestRemarks) FROM MicrobioTestResults m GROUP BY m.cultureAndSensitivityTestRemarks")
    List<Object[]> countUniqueCultureAndSensitivityTest();

    @Query("SELECT COALESCE(m.coliformCountRemarks, 'UNKNOWN'), COUNT(m.coliformCountRemarks) FROM MicrobioTestResults m GROUP BY m.coliformCountRemarks")
    List<Object[]> countUniqueColiformCount();

    @Query("SELECT COALESCE(m.eColiRemarks, 'UNKNOWN'), COUNT(m.eColiRemarks) FROM MicrobioTestResults m GROUP BY m.eColiRemarks")
    List<Object[]> countUniqueEColi();

    @Query("SELECT COALESCE(m.eColiAndeColi0O157Remarks, 'UNKNOWN'), COUNT(m.eColiAndeColi0O157Remarks) FROM MicrobioTestResults m GROUP BY m.eColiAndeColi0O157Remarks")
    List<Object[]> countUniqueEColiAndeColi0O157();

    @Query("SELECT COALESCE(m.yeastAndMoldsRemarks, 'UNKNOWN'), COUNT(m.yeastAndMoldsRemarks) FROM MicrobioTestResults m GROUP BY m.yeastAndMoldsRemarks")
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

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.standardPlateCountAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.standardPlateCountAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.standardPlateCountRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.standardPlateCountRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.standardPlateCountAnalysisDate), EXTRACT(MONTH FROM m.standardPlateCountAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countStandardPlatePosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.salmonellaSpAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.salmonellaSpAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.salmonellaSpRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.salmonellaSpRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.salmonellaSpAnalysisDate), EXTRACT(MONTH FROM m.salmonellaSpAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countSalmonellaSpPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.campylobacterAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.campylobacterAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.campylobacterRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.campylobacterRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.campylobacterAnalysisDate), EXTRACT(MONTH FROM m.campylobacterAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countCampylobacterPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.cultureAndSensitivityTestAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.cultureAndSensitivityTestAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.cultureAndSensitivityTestRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.cultureAndSensitivityTestRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.cultureAndSensitivityTestAnalysisDate), EXTRACT(MONTH FROM m.cultureAndSensitivityTestAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countCultureAndSensitivityPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.coliformCountAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.coliformCountAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.coliformCountRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.coliformCountRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.coliformCountAnalysisDate), EXTRACT(MONTH FROM m.coliformCountAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countColiformPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.eColiAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.eColiAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.eColiRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.eColiRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.eColiAnalysisDate), EXTRACT(MONTH FROM m.eColiAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> counteColiPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.eColiAndeColi0O157AnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.eColiAndeColi0O157AnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.eColiAndeColi0O157Remarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.eColiAndeColi0O157Remarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.eColiAndeColi0O157AnalysisDate), EXTRACT(MONTH FROM m.eColiAndeColi0O157AnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> counteColiandeColiPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.yeastAndMoldsAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.yeastAndMoldsAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.yeastAndMoldsRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.yeastAndMoldsRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MicrobioTestResults m  " +
            "GROUP BY EXTRACT(YEAR FROM m.yeastAndMoldsAnalysisDate), EXTRACT(MONTH FROM m.yeastAndMoldsAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countYeastAndMoldsPosNegByMonthAndYear();


}