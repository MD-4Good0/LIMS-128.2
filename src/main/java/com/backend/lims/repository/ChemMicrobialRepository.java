package com.backend.lims.repository;

import com.backend.lims.model.ChemMicrobialTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChemMicrobialRepository extends JpaRepository<ChemMicrobialTestResults, Long> {
    Optional<ChemMicrobialTestResults> findBySampleId(Long sampleId);

    @Query("SELECT COALESCE(c.betaLactamsRemarks, 'UNKNOWN'), COUNT(c.betaLactamsRemarks) FROM ChemMicrobialTestResults c GROUP BY c.betaLactamsRemarks")
    List<Object[]> countUniqueBetaLactams();

    @Query("SELECT COALESCE(c.tetracyclinesRemarks, 'UNKNOWN'), COUNT(c.tetracyclinesRemarks) FROM ChemMicrobialTestResults c GROUP BY c.tetracyclinesRemarks")
    List<Object[]> countUniqueTetracyclines();

    @Query("SELECT COALESCE(c.sulfonamidesRemarks, 'UNKNOWN'), COUNT(c.sulfonamidesRemarks) FROM ChemMicrobialTestResults c GROUP BY c.sulfonamidesRemarks")
    List<Object[]> countUniqueSulfonamides();

    @Query("SELECT COALESCE(c.aminoglycosidesRemarks, 'UNKNOWN'), COUNT(c.aminoglycosidesRemarks) FROM ChemMicrobialTestResults c GROUP BY c.aminoglycosidesRemarks")
    List<Object[]> countUniqueAminoglycosides();

    @Query("SELECT COALESCE(c.macrolidesRemarks, 'UNKNOWN'), COUNT(c.macrolidesRemarks) FROM ChemMicrobialTestResults c GROUP BY c.macrolidesRemarks")
    List<Object[]> countUniqueMacrolides();

    @Query("SELECT COALESCE(c.quinolonesRemarks, 'UNKNOWN'), COUNT(c.quinolonesRemarks) FROM ChemMicrobialTestResults c GROUP BY c.quinolonesRemarks")
    List<Object[]> countUniqueQuinolones();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.betaLactamsAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM c.betaLactamsAnalysisDate), 0), " +
            "   COUNT(c) " +
            "FROM ChemMicrobialTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.betaLactamsAnalysisDate), EXTRACT(MONTH FROM c.betaLactamsAnalysisDate)")
    List<Object[]> countBetaLactamsByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.tetracyclinesAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM c.tetracyclinesAnalysisDate), 0), " +
            "   COUNT(c) " +
            "FROM ChemMicrobialTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.tetracyclinesAnalysisDate), EXTRACT(MONTH FROM c.tetracyclinesAnalysisDate)")
    List<Object[]> countTetracyclinesByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.sulfonamidesAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM c.sulfonamidesAnalysisDate), 0), " +
            "   COUNT(c) " +
            "FROM ChemMicrobialTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.sulfonamidesAnalysisDate), EXTRACT(MONTH FROM c.sulfonamidesAnalysisDate)")
    List<Object[]> countSulfonamidesByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.aminoglycosidesAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM c.aminoglycosidesAnalysisDate), 0), " +
            "   COUNT(c) " +
            "FROM ChemMicrobialTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.aminoglycosidesAnalysisDate), EXTRACT(MONTH FROM c.aminoglycosidesAnalysisDate)")
    List<Object[]> countAminoglycosidesByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.macrolidesAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM c.macrolidesAnalysisDate), 0), " +
            "   COUNT(c) " +
            "FROM ChemMicrobialTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.macrolidesAnalysisDate), EXTRACT(MONTH FROM c.macrolidesAnalysisDate)")
    List<Object[]> countMacrolidesByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.quinolonesAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM c.quinolonesAnalysisDate), 0), " +
            "   COUNT(c) " +
            "FROM ChemMicrobialTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.quinolonesAnalysisDate), EXTRACT(MONTH FROM c.quinolonesAnalysisDate)")
    List<Object[]> countQuinolonesByMonthAndYear();

}