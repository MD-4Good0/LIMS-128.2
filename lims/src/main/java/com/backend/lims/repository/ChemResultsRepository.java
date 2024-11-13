package com.backend.lims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.lims.model.ChemMicrobialTestResults;

public interface ChemResultsRepository extends JpaRepository<ChemMicrobialTestResults, Long> {
	/*
	@Query("SELECT new com.backend.lims.model.Report(s.province, " +
		       "TO_CHAR(r.submissionDate, 'YYYY-MM') AS monthYear, " +
		       "'Chem' AS testType, COUNT(ctr), " +
		       "SUM(CASE WHEN ctr.betaLactams = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.tetracyclines = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.sulfonamides = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.aminoglycosides = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.macrolides = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.quinolones = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.chloramphenicol = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.nitrofuranAoz = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.beta_agonists = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.corticosteroids = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.olaquindox = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.nitrufuranAmoz = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.stilbenes = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.ractopamine = 'Positive' THEN 1 ELSE 0 END), " +
		       "SUM(CASE WHEN ctr.betaLactams = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.tetracyclines = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.sulfonamides = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.aminoglycosides = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.macrolides = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.quinolones = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.chloramphenicol = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.nitrofuranAoz = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.beta_agonists = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.corticosteroids = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.olaquindox = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.nitrufuranAmoz = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.stilbenes = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN ctr.ractopamine = 'Negative' THEN 1 ELSE 0 END), " +
		       "s.sampleType, r.testingPurpose) " +
		       "FROM ChemTestResults ctr " +
		       "JOIN ctr.result res " +
		       "JOIN res.sample s " +
		       "JOIN s.request r " +
		       "GROUP BY s.province, monthYear, s.sampleType, r.testingPurpose " +
		       "ORDER BY s.province, monthYear")
		List<Report> generateChemReport();


	 */
}
