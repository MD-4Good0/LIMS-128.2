package com.backend.lims.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.lims.model.Report;
import com.backend.lims.repository.ChemResultsRepository;
import com.backend.lims.repository.MicrobialResultsRepository;
import com.backend.lims.repository.MolBioResultsRepository;

@Service
public class ReportService {
	
	@Autowired
    private MolBioResultsRepository molBioRepo;

    @Autowired
    private MicrobialResultsRepository microbialRepo;

    @Autowired
    private ChemResultsRepository chemRepo;

    public List<Report> generateCompleteReport() {
        List<Report> molBioReports = molBioRepo.generateMolBioReport();
        List<Report> microbialReports = microbialRepo.generateMicrobialReport();
        List<Report> chemReports = chemRepo.generateChemReport();

        // Combine all reports into one list
        List<Report> fullReport = new ArrayList<>();
        fullReport.addAll(molBioReports);
        fullReport.addAll(microbialReports);
        fullReport.addAll(chemReports);

        return fullReport;
    }

}
