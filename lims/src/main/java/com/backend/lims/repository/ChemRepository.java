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

    @Query("SELECT c.betaLactams, COUNT(c.betaLactams) FROM ChemTestResults c GROUP BY c.betaLactams")
    List<Object[]> countUniqueBetaLactams();

    @Query("SELECT c.tetracyclines, COUNT(c.tetracyclines) FROM ChemTestResults c GROUP BY c.tetracyclines")
    List<Object[]> countUniqueTetracyclines();

    @Query("SELECT c.sulfonamides, COUNT(c.sulfonamides) FROM ChemTestResults c GROUP BY c.sulfonamides")
    List<Object[]> countUniqueSulfonamides();

    @Query("SELECT c.aminoglycosides, COUNT(c.aminoglycosides) FROM ChemTestResults c GROUP BY c.aminoglycosides")
    List<Object[]> countUniqueAminoglycosides();

    @Query("SELECT c.macrolides, COUNT(c.macrolides) FROM ChemTestResults c GROUP BY c.macrolides")
    List<Object[]> countUniqueMacrolides();

    @Query("SELECT c.quinolones, COUNT(c.quinolones) FROM ChemTestResults c GROUP BY c.quinolones")
    List<Object[]> countUniqueQuinolones();

    @Query("SELECT c.chloramphenicol, COUNT(c.chloramphenicol) FROM ChemTestResults c GROUP BY c.chloramphenicol")
    List<Object[]> countUniqueChloramphenicol();

    @Query("SELECT c.nitrofuranAoz, COUNT(c.nitrofuranAoz) FROM ChemTestResults c GROUP BY c.nitrofuranAoz")
    List<Object[]> countUniqueNitrofuranAoz();

    @Query("SELECT c.beta_agonists, COUNT(c.beta_agonists) FROM ChemTestResults c GROUP BY c.beta_agonists")
    List<Object[]> countUniqueBetaAgonists();

    @Query("SELECT c.corticosteroids, COUNT(c.corticosteroids) FROM ChemTestResults c GROUP BY c.corticosteroids")
    List<Object[]> countUniqueCorticosteroids();

    @Query("SELECT c.olaquindox, COUNT(c.olaquindox) FROM ChemTestResults c GROUP BY c.olaquindox")
    List<Object[]> countUniqueOlaquindox();

    @Query("SELECT c.nitrufuranAmoz, COUNT(c.nitrufuranAmoz) FROM ChemTestResults c GROUP BY c.nitrufuranAmoz")
    List<Object[]> countUniqueNitrufuranAmoz();

    @Query("SELECT c.stilbenes, COUNT(c.stilbenes) FROM ChemTestResults c GROUP BY c.stilbenes")
    List<Object[]> countUniqueStilbenes();

    @Query("SELECT c.ractopamine, COUNT(c.ractopamine) FROM ChemTestResults c GROUP BY c.ractopamine")
    List<Object[]> countUniqueRactopamine();
}