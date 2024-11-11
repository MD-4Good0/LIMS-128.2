package com.backend.lims.repository;

import com.backend.lims.model.ChemTestResults;
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
}