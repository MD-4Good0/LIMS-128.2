package com.backend.lims.repository;

import com.backend.lims.model.MolBioTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

@Repository
public interface MolBioRepository extends JpaRepository<MolBioTestResults, Long> {
    Optional<MolBioTestResults> findBySampleId(Long sampleId);

    @Query("SELECT COALESCE(m.dog, 'UNKNOWN'), COUNT(m.dog) FROM MolBioTestResults m GROUP BY m.dog")
    List<Object[]> countUniqueDog();

    @Query("SELECT COALESCE(m.cat, 'UNKNOWN'), COUNT(m.cat) FROM MolBioTestResults m GROUP BY m.cat")
    List<Object[]> countUniqueCat();

    @Query("SELECT COALESCE(m.chicken, 'UNKNOWN'), COUNT(m.chicken) FROM MolBioTestResults m GROUP BY m.chicken")
    List<Object[]> countUniqueChicken();

    @Query("SELECT COALESCE(m.buffalo, 'UNKNOWN'), COUNT(m.buffalo) FROM MolBioTestResults m GROUP BY m.buffalo")
    List<Object[]> countUniqueBuffalo();

    @Query("SELECT COALESCE(m.cattle, 'UNKNOWN'), COUNT(m.cattle) FROM MolBioTestResults m GROUP BY m.cattle")
    List<Object[]> countUniqueCattle();

    @Query("SELECT COALESCE(m.horse, 'UNKNOWN'), COUNT(m.horse) FROM MolBioTestResults m GROUP BY m.horse")
    List<Object[]> countUniqueHorse();

    @Query("SELECT COALESCE(m.goat, 'UNKNOWN'), COUNT(m.goat) FROM MolBioTestResults m GROUP BY m.goat")
    List<Object[]> countUniqueGoat();

    @Query("SELECT COALESCE(m.sheep, 'UNKNOWN'), COUNT(m.sheep) FROM MolBioTestResults m GROUP BY m.sheep")
    List<Object[]> countUniqueSheep();

    @Query("SELECT COALESCE(m.swine, 'UNKNOWN'), COUNT(m.swine) FROM MolBioTestResults m GROUP BY m.swine")
    List<Object[]> countUniqueSwine();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.dogAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.dogAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.dogAnalysisDate), EXTRACT(MONTH FROM m.dogAnalysisDate)")
    List<Object[]> countDogByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.catAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.catAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.catAnalysisDate), EXTRACT(MONTH FROM m.catAnalysisDate)")
    List<Object[]> countCatByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.chickenAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.chickenAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.chickenAnalysisDate), EXTRACT(MONTH FROM m.chickenAnalysisDate)")
    List<Object[]> countChickenByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.buffaloAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.buffaloAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.buffaloAnalysisDate), EXTRACT(MONTH FROM m.buffaloAnalysisDate)")
    List<Object[]> countBuffaloByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.cattleAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.cattleAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.cattleAnalysisDate), EXTRACT(MONTH FROM m.cattleAnalysisDate)")
    List<Object[]> countCattleByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.horseAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.horseAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.horseAnalysisDate), EXTRACT(MONTH FROM m.horseAnalysisDate)")
    List<Object[]> countHorseByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.goatAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.goatAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.goatAnalysisDate), EXTRACT(MONTH FROM m.goatAnalysisDate)")
    List<Object[]> countGoatByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.sheepAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.sheepAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.sheepAnalysisDate), EXTRACT(MONTH FROM m.sheepAnalysisDate)")
    List<Object[]> countSheepByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.swineAnalysisDate), 0), " +
            "   COALESCE(EXTRACT(MONTH FROM m.swineAnalysisDate), 0), " +
            "   COUNT(m) " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.swineAnalysisDate), EXTRACT(MONTH FROM m.swineAnalysisDate)")
    List<Object[]> countSwineByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.dogAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.dogAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.dog = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.dog = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.dogAnalysisDate), EXTRACT(MONTH FROM m.dogAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countDogPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.catAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.catAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.cat = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.cat = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.catAnalysisDate), EXTRACT(MONTH FROM m.catAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countCatPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.chickenAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.chickenAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.chicken = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.chicken = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.chickenAnalysisDate), EXTRACT(MONTH FROM m.chickenAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countChickenPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.buffaloAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.buffaloAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.buffalo = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.buffalo = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.buffaloAnalysisDate), EXTRACT(MONTH FROM m.buffaloAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countBuffaloPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.cattleAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.cattleAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.cattle = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.cattle = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.cattleAnalysisDate), EXTRACT(MONTH FROM m.cattleAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countCattlePosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.horseAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.horseAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.horse = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.horse = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.horseAnalysisDate), EXTRACT(MONTH FROM m.horseAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countHorsePosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.goatAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.goatAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.goat = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.goat = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.goatAnalysisDate), EXTRACT(MONTH FROM m.goatAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countGoatPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.sheepAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.sheepAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.sheep = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.sheep = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.sheepAnalysisDate), EXTRACT(MONTH FROM m.sheepAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countSheepPosNegByMonthAndYear();

    @Query("SELECT " +
            "   COALESCE(EXTRACT(YEAR FROM m.swineAnalysisDate), 0) AS year, " +
            "   COALESCE(EXTRACT(MONTH FROM m.swineAnalysisDate), 0) AS month, " +
            "   SUM(CASE WHEN m.swine = 'positive' THEN 1 ELSE 0 END) AS positiveCount, " +
            "   SUM(CASE WHEN m.swine = 'negative' THEN 1 ELSE 0 END) AS negativeCount " +
            "FROM MolBioTestResults m " +
            "GROUP BY EXTRACT(YEAR FROM m.swineAnalysisDate), EXTRACT(MONTH FROM m.swineAnalysisDate) " +
            "ORDER BY year, month")
    List<Object[]> countSwinePosNegByMonthAndYear();


}