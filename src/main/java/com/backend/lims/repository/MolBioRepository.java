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

    /*
    @Query("SELECT FUNCTION('YEAR', m.dogAnalysisDate), FUNCTION('MONTH', m.dogAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.dogAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.dogAnalysisDate), FUNCTION('MONTH', m.dogAnalysisDate)")
    List<Object[]> countDogByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.catAnalysisDate), FUNCTION('MONTH', m.catAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.catAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.catAnalysisDate), FUNCTION('MONTH', m.catAnalysisDate)")
    List<Object[]> countCatByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.chickenAnalysisDate), FUNCTION('MONTH', m.chickenAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.chickenAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.chickenAnalysisDate), FUNCTION('MONTH', m.chickenAnalysisDate)")
    List<Object[]> countChickenByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.buffaloAnalysisDate), FUNCTION('MONTH', m.buffaloAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.buffaloAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.buffaloAnalysisDate), FUNCTION('MONTH', m.buffaloAnalysisDate)")
    List<Object[]> countBuffaloByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.cattleAnalysisDate), FUNCTION('MONTH', m.cattleAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.cattleAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.cattleAnalysisDate), FUNCTION('MONTH', m.cattleAnalysisDate)")
    List<Object[]> countCattleByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.horseAnalysisDate), FUNCTION('MONTH', m.horseAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.horseAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.horseAnalysisDate), FUNCTION('MONTH', m.horseAnalysisDate)")
    List<Object[]> countHorseByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.goatAnalysisDate), FUNCTION('MONTH', m.goatAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.goatAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.goatAnalysisDate), FUNCTION('MONTH', m.goatAnalysisDate)")
    List<Object[]> countGoatByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.sheepAnalysisDate), FUNCTION('MONTH', m.sheepAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.sheepAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.sheepAnalysisDate), FUNCTION('MONTH', m.sheepAnalysisDate)")
    List<Object[]> countSheepByMonthAndYear();

    @Query("SELECT FUNCTION('YEAR', m.swineAnalysisDate), FUNCTION('MONTH', m.swineAnalysisDate), COUNT(m) " +
            "FROM MolBioTestResults m WHERE m.swineAnalysisDate IS NOT NULL " +
            "GROUP BY FUNCTION('YEAR', m.swineAnalysisDate), FUNCTION('MONTH', m.swineAnalysisDate)")
    List<Object[]> countSwineByMonthAndYear();
     */
}