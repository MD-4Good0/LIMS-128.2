package com.backend.lims.repository;

import com.backend.lims.model.MolBioTestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

@Repository
public interface MolBioRepository extends JpaRepository<MolBioTestResults, Long> {
    Optional<MolBioTestResults> findBySampleId(Long sampleId);

    @Query("SELECT COALESCE(m.dog, 'UNKNOWN'), COUNT(m.dog)" +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.dog")
    List<Object[]> countUniqueDog(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.cat, 'UNKNOWN'), COUNT(m.cat) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.cat")
    List<Object[]> countUniqueCat(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.chicken, 'UNKNOWN'), COUNT(m.chicken) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.chicken")
    List<Object[]> countUniqueChicken(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.buffalo, 'UNKNOWN'), COUNT(m.buffalo) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.buffalo")
    List<Object[]> countUniqueBuffalo(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.cattle, 'UNKNOWN'), COUNT(m.cattle) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.cattle")
    List<Object[]> countUniqueCattle(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.horse, 'UNKNOWN'), COUNT(m.horse) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.horse")
    List<Object[]> countUniqueHorse(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.goat, 'UNKNOWN'), COUNT(m.goat) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.goat")
    List<Object[]> countUniqueGoat(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.sheep, 'UNKNOWN'), COUNT(m.sheep) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.sheep")
    List<Object[]> countUniqueSheep(@Param("month") int month, @Param("year") int year);

    @Query("SELECT COALESCE(m.swine, 'UNKNOWN'), COUNT(m.swine) " +
    "FROM MolBioTestResults m " +
    "WHERE FUNCTION('MONTH', c.submissionDate) = :month " +
    "AND FUNCTION('YEAR', c.submissionDate) = :year " +
    "GROUP BY m.swine")
    List<Object[]> countUniqueSwine(@Param("month") int month, @Param("year") int year);
}