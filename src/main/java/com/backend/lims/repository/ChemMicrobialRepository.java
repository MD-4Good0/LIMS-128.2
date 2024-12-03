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

    @Query("SELECT COALESCE(c.betaLactams, 'UNKNOWN'), COUNT(c.betaLactams) FROM ChemMicrobialTestResults c GROUP BY c.betaLactams")
    List<Object[]> countUniqueBetaLactams();

    @Query("SELECT COALESCE(c.tetracyclines, 'UNKNOWN'), COUNT(c.tetracyclines) FROM ChemMicrobialTestResults c GROUP BY c.tetracyclines")
    List<Object[]> countUniqueTetracyclines();

    @Query("SELECT COALESCE(c.sulfonamides, 'UNKNOWN'), COUNT(c.sulfonamides) FROM ChemMicrobialTestResults c GROUP BY c.sulfonamides")
    List<Object[]> countUniqueSulfonamides();

    @Query("SELECT COALESCE(c.aminoglycosides, 'UNKNOWN'), COUNT(c.aminoglycosides) FROM ChemMicrobialTestResults c GROUP BY c.aminoglycosides")
    List<Object[]> countUniqueAminoglycosides();

    @Query("SELECT COALESCE(c.macrolides, 'UNKNOWN'), COUNT(c.macrolides) FROM ChemMicrobialTestResults c GROUP BY c.macrolides")
    List<Object[]> countUniqueMacrolides();

    @Query("SELECT COALESCE(c.quinolones, 'UNKNOWN'), COUNT(c.quinolones) FROM ChemMicrobialTestResults c GROUP BY c.quinolones")
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