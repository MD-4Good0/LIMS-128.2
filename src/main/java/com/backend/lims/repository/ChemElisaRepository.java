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

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.chloramphenicolAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.chloramphenicolAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.chloramphenicolRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.chloramphenicolRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.chloramphenicolAnalysisDate), EXTRACT(MONTH FROM c.chloramphenicolAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countChloramphenicolPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.nitrofuranAozAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.nitrofuranAozAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.nitrofuranAozRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.nitrofuranAozRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.nitrofuranAozAnalysisDate), EXTRACT(MONTH FROM c.nitrofuranAozAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countNitrofuranAozPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.beta_agonistsAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.beta_agonistsAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.beta_agonistsRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.beta_agonistsRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.beta_agonistsAnalysisDate), EXTRACT(MONTH FROM c.beta_agonistsAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countBetaAgonistsPosNegCount();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.corticosteroidsAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.corticosteroidsAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.corticosteroidsRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.corticosteroidsRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.corticosteroidsAnalysisDate), EXTRACT(MONTH FROM c.corticosteroidsAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countCorticosteroidsPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.olaquindoxAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.olaquindoxAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.olaquindoxRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.olaquindoxRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.olaquindoxAnalysisDate), EXTRACT(MONTH FROM c.olaquindoxAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countOlaquindoxPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.nitrufuranAmozAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.nitrufuranAmozAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.nitrufuranAmozRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.nitrufuranAmozRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.nitrufuranAmozAnalysisDate), EXTRACT(MONTH FROM c.nitrufuranAmozAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countNitrofuranAmozPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.stilbenesAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.stilbenesAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.stilbenesRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.stilbenesRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.stilbenesAnalysisDate), EXTRACT(MONTH FROM c.stilbenesAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countStilbenesPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM c.ractopamineAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM c.ractopamineAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN c.ractopamineRemarks = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN c.ractopamineRemarks = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM ChemElisaTestResults c " +
            "GROUP BY EXTRACT(YEAR FROM c.ractopamineAnalysisDate), EXTRACT(MONTH FROM c.ractopamineAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countRactopaminePosNegByMonthAndYear();


}
