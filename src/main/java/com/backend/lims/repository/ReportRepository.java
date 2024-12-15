package com.backend.lims.repository;

import com.backend.lims.model.Report;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReportRepository  {
	@Query("SELECT new com.backend.lims.model.Report(s.province, " +
		       "TO_CHAR(r.submissionDate, 'YYYY-MM') AS monthYear, " +
		       "'Microbial' AS testType, COUNT(mtr), " +
		       "SUM(CASE WHEN mtr.standardPlateCount = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.staphylococcusAureus = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.salmonellaSp = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.campylobacter = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.cultureAndSensitivityTest = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.coliformCount = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.eColi = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.eColiAndeColi0O157 = 'Positive' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.yeastAndMolds = 'Positive' THEN 1 ELSE 0 END), " +
		       "SUM(CASE WHEN mtr.standardPlateCount = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.staphylococcusAureus = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.salmonellaSp = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.campylobacter = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.cultureAndSensitivityTest = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.coliformCount = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.eColi = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.eColiAndeColi0O157 = 'Negative' THEN 1 ELSE 0 END + " +
		       "CASE WHEN mtr.yeastAndMolds = 'Negative' THEN 1 ELSE 0 END)) " +
		       "FROM MicrobialTestResults mtr " +
		       "JOIN mtr.result res " +
		       "JOIN res.sample s " +
		       "JOIN s.request r " +
		       "GROUP BY s.province, monthYear " +
		       "ORDER BY s.province, monthYear")
		List<Report> generateMicrobialReport();
	
	

}
