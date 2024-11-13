package com.backend.lims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.lims.model.MicrobioTestResults;

public interface MolBioResultsRepository extends JpaRepository<MicrobioTestResults, Long> {
	/*
	@Query("SELECT new com.backend.lims.model.Report(s.province, " +
		       "TO_CHAR(r.submissionDate, 'YYYY-MM') AS monthYear, " +
		       "'MolBio' AS testType, COUNT(mbt), " +
		       "SUM(CASE WHEN mbt.dog = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.cat = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.chicken = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.buffalo = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.cattle = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.horse = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.goat = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.sheep = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.swine = 'Positive' THEN 1 ELSE 0 END), " +
		       "SUM(CASE WHEN mbt.dog = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.cat = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.chicken = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.buffalo = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.cattle = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.horse = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.goat = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.sheep = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mbt.swine = 'Negative' THEN 1 ELSE 0 END), " +
		       "s.sampleType, r.testingPurpose) " +
		       "FROM MolBioTestResults mbt " +
		       "JOIN mbt.result res " +
		       "JOIN res.sample s " +
		       "JOIN s.request r " +
		       "GROUP BY s.province, monthYear, s.sampleType, r.testingPurpose " +
		       "ORDER BY s.province, monthYear")
		List<Report> generateMolBioReport();


	 */

}
