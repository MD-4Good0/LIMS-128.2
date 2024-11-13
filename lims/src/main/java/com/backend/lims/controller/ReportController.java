package com.backend.lims.controller;

import com.backend.lims.dto.ChemTestReportDTO;
import com.backend.lims.dto.MicrobioTestReportDTO;
import com.backend.lims.dto.MolBioTestReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.lims.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /*
    @GetMapping("/complete")
    public List<Report> getCompleteReport() {
        return reportService.generateCompleteReport();
    }
     */

    @GetMapping("/chemreport")
    public ChemTestReportDTO getChemTestResultsReport() {
        return reportService.generateChemReport();
    }

    @GetMapping("/molbioreport")
    public MolBioTestReportDTO getMolBioTestResultsReport() {
        return reportService.generateMolBioReport();
    }

    @GetMapping("/microbioreport")
    public MicrobioTestReportDTO getMicrobioTestResultsReport() {
        return reportService.generateMicrobioReport();
    }

}