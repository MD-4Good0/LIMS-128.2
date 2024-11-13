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
}