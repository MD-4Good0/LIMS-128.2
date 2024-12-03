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

    @Query("SELECT COALESCE(c.chloramphenicolRemarks, 'UNKNOWN'), COUNT(c.chloramphenicolRemarks) FROM ChemElisaTestResults c GROUP BY c.chloramphenicolRemarks")
    List<Object[]> countUniqueChloramphenicol();

    @Query("SELECT COALESCE(c.nitrofuranAozRemarks, 'UNKNOWN'), COUNT(c.nitrofuranAozRemarks) FROM ChemElisaTestResults c GROUP BY c.nitrofuranAozRemarks")
    List<Object[]> countUniqueNitrofuranAoz();

    @Query("SELECT COALESCE(c.beta_agonistsRemarks, 'UNKNOWN'), COUNT(c.beta_agonistsRemarks) FROM ChemElisaTestResults c GROUP BY c.beta_agonistsRemarks")
    List<Object[]> countUniqueBetaAgonists();

    @Query("SELECT COALESCE(c.corticosteroidsRemarks, 'UNKNOWN'), COUNT(c.corticosteroidsRemarks) FROM ChemElisaTestResults c GROUP BY c.corticosteroidsRemarks")
    List<Object[]> countUniqueCorticosteroids();

    @Query("SELECT COALESCE(c.olaquindoxRemarks, 'UNKNOWN'), COUNT(c.olaquindoxRemarks) FROM ChemElisaTestResults c GROUP BY c.olaquindoxRemarks")
    List<Object[]> countUniqueOlaquindox();

    @Query("SELECT COALESCE(c.nitrufuranAmozRemarks, 'UNKNOWN'), COUNT(c.nitrufuranAmozRemarks) FROM ChemElisaTestResults c GROUP BY c.nitrufuranAmozRemarks")
    List<Object[]> countUniqueNitrufuranAmoz();

    @Query("SELECT COALESCE(c.stilbenesRemarks, 'UNKNOWN'), COUNT(c.stilbenesRemarks) FROM ChemElisaTestResults c GROUP BY c.stilbenesRemarks")
    List<Object[]> countUniqueStilbenes();

    @Query("SELECT COALESCE(c.ractopamineRemarks, 'UNKNOWN'), COUNT(c.ractopamineRemarks) FROM ChemElisaTestResults c GROUP BY c.ractopamineRemarks")
    List<Object[]> countUniqueRactopamine();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.chloramphenicolAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.chloramphenicolAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.chloramphenicolAnalysisDate), EXTRACT(MONTH FROM m.chloramphenicolAnalysisDate)")
    List<Object[]> countChloramphenicolByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.nitrofuranAozAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.nitrofuranAozAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.nitrofuranAozAnalysisDate), EXTRACT(MONTH FROM m.nitrofuranAozAnalysisDate)")
    List<Object[]> countNitrofuranAozByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.beta_agonistsAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.beta_agonistsAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.beta_agonistsAnalysisDate), EXTRACT(MONTH FROM m.beta_agonistsAnalysisDate)")
    List<Object[]> countBetaAgonistsByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.corticosteroidsAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.corticosteroidsAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.corticosteroidsAnalysisDate), EXTRACT(MONTH FROM m.corticosteroidsAnalysisDate)")
    List<Object[]> countCorticosteroidsByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.olaquindoxAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.olaquindoxAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.olaquindoxAnalysisDate), EXTRACT(MONTH FROM m.olaquindoxAnalysisDate)")
    List<Object[]> countOlaquindoxByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.nitrufuranAmozAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.nitrufuranAmozAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.nitrufuranAmozAnalysisDate), EXTRACT(MONTH FROM m.nitrufuranAmozAnalysisDate)")
    List<Object[]> countNitrufuranAmozByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.stilbenesAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.stilbenesAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.stilbenesAnalysisDate), EXTRACT(MONTH FROM m.stilbenesAnalysisDate)")
    List<Object[]> countStilbenesByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.ractopamineAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.ractopamineAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM ChemElisaTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.ractopamineAnalysisDate), EXTRACT(MONTH FROM m.ractopamineAnalysisDate)")
    List<Object[]> countRactopamineByMonthAndYear();

}
