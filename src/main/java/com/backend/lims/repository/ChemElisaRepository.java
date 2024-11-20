package com.backend.lims.repository;

import com.backend.lims.model.ChemElisaTestResults;
import com.backend.lims.model.ChemMicrobialTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChemElisaRepository extends JpaRepository<ChemElisaTestResults, Long> {
    Optional<ChemElisaTestResults> findBySampleId(Long sampleId);

    @Query("SELECT COALESCE(c.chloramphenicol, 'UNKNOWN'), COUNT(c.chloramphenicol) FROM ChemElisaTestResults c GROUP BY c.chloramphenicol")
    List<Object[]> countUniqueChloramphenicol();

    @Query("SELECT COALESCE(c.nitrofuranAoz, 'UNKNOWN'), COUNT(c.nitrofuranAoz) FROM ChemElisaTestResults c GROUP BY c.nitrofuranAoz")
    List<Object[]> countUniqueNitrofuranAoz();

    @Query("SELECT COALESCE(c.beta_agonists, 'UNKNOWN'), COUNT(c.beta_agonists) FROM ChemElisaTestResults c GROUP BY c.beta_agonists")
    List<Object[]> countUniqueBetaAgonists();

    @Query("SELECT COALESCE(c.corticosteroids, 'UNKNOWN'), COUNT(c.corticosteroids) FROM ChemElisaTestResults c GROUP BY c.corticosteroids")
    List<Object[]> countUniqueCorticosteroids();

    @Query("SELECT COALESCE(c.olaquindox, 'UNKNOWN'), COUNT(c.olaquindox) FROM ChemElisaTestResults c GROUP BY c.olaquindox")
    List<Object[]> countUniqueOlaquindox();

    @Query("SELECT COALESCE(c.nitrufuranAmoz, 'UNKNOWN'), COUNT(c.nitrufuranAmoz) FROM ChemElisaTestResults c GROUP BY c.nitrufuranAmoz")
    List<Object[]> countUniqueNitrufuranAmoz();

    @Query("SELECT COALESCE(c.stilbenes, 'UNKNOWN'), COUNT(c.stilbenes) FROM ChemElisaTestResults c GROUP BY c.stilbenes")
    List<Object[]> countUniqueStilbenes();

    @Query("SELECT COALESCE(c.ractopamine, 'UNKNOWN'), COUNT(c.ractopamine) FROM ChemElisaTestResults c GROUP BY c.ractopamine")
    List<Object[]> countUniqueRactopamine();

}
