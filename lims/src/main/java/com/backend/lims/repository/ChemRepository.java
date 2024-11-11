package com.backend.lims.repository;

import com.backend.lims.model.ChemTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChemRepository extends JpaRepository<ChemTestResults, Long> {
    Optional<ChemTestResults> findBySampleId(Long sampleId);

    @Query("SELECT COALESCE(c.betaLactams, 'UNKNOWN'), COUNT(c.betaLactams) FROM ChemTestResults c GROUP BY c.betaLactams")
    List<Object[]> countUniqueBetaLactams();

    @Query("SELECT COALESCE(c.tetracyclines, 'UNKNOWN'), COUNT(c.tetracyclines) FROM ChemTestResults c GROUP BY c.tetracyclines")
    List<Object[]> countUniqueTetracyclines();

    @Query("SELECT COALESCE(c.sulfonamides, 'UNKNOWN'), COUNT(c.sulfonamides) FROM ChemTestResults c GROUP BY c.sulfonamides")
    List<Object[]> countUniqueSulfonamides();

    @Query("SELECT COALESCE(c.aminoglycosides, 'UNKNOWN'), COUNT(c.aminoglycosides) FROM ChemTestResults c GROUP BY c.aminoglycosides")
    List<Object[]> countUniqueAminoglycosides();

    @Query("SELECT COALESCE(c.macrolides, 'UNKNOWN'), COUNT(c.macrolides) FROM ChemTestResults c GROUP BY c.macrolides")
    List<Object[]> countUniqueMacrolides();

    @Query("SELECT COALESCE(c.quinolones, 'UNKNOWN'), COUNT(c.quinolones) FROM ChemTestResults c GROUP BY c.quinolones")
    List<Object[]> countUniqueQuinolones();

    @Query("SELECT COALESCE(c.chloramphenicol, 'UNKNOWN'), COUNT(c.chloramphenicol) FROM ChemTestResults c GROUP BY c.chloramphenicol")
    List<Object[]> countUniqueChloramphenicol();

    @Query("SELECT COALESCE(c.nitrofuranAoz, 'UNKNOWN'), COUNT(c.nitrofuranAoz) FROM ChemTestResults c GROUP BY c.nitrofuranAoz")
    List<Object[]> countUniqueNitrofuranAoz();

    @Query("SELECT COALESCE(c.beta_agonists, 'UNKNOWN'), COUNT(c.beta_agonists) FROM ChemTestResults c GROUP BY c.beta_agonists")
    List<Object[]> countUniqueBetaAgonists();

    @Query("SELECT COALESCE(c.corticosteroids, 'UNKNOWN'), COUNT(c.corticosteroids) FROM ChemTestResults c GROUP BY c.corticosteroids")
    List<Object[]> countUniqueCorticosteroids();

    @Query("SELECT COALESCE(c.olaquindox, 'UNKNOWN'), COUNT(c.olaquindox) FROM ChemTestResults c GROUP BY c.olaquindox")
    List<Object[]> countUniqueOlaquindox();

    @Query("SELECT COALESCE(c.nitrufuranAmoz, 'UNKNOWN'), COUNT(c.nitrufuranAmoz) FROM ChemTestResults c GROUP BY c.nitrufuranAmoz")
    List<Object[]> countUniqueNitrufuranAmoz();

    @Query("SELECT COALESCE(c.stilbenes, 'UNKNOWN'), COUNT(c.stilbenes) FROM ChemTestResults c GROUP BY c.stilbenes")
    List<Object[]> countUniqueStilbenes();

    @Query("SELECT COALESCE(c.ractopamine, 'UNKNOWN'), COUNT(c.ractopamine) FROM ChemTestResults c GROUP BY c.ractopamine")
    List<Object[]> countUniqueRactopamine();
}