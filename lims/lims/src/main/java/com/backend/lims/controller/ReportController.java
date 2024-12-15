package com.backend.lims.controller;

import com.backend.lims.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.lims.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/chemmicrobialreport")
    public ChemMicrobialTestReportDTO getChemMicrobialTestResultsReport(
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String year) {
    	
        int yearInt = (year != null) ? Integer.parseInt(year) : 2024; // Default year if not provided

        return reportService.generateChemMicrobialReport(yearInt); // Pass month and year to service
    }

    @GetMapping("/chemelisareport")
    public ChemElisaTestReportDTO getChemElisaTestResultsReport(
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String year) {

        int yearInt = (year != null) ? Integer.parseInt(year) : 2024;

        return reportService.generateChemElisaReport(yearInt);
    }

    @GetMapping("/molbioreport")
    public MolBioTestReportDTO getMolBioTestResultsReport(
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String year) {

        int yearInt = (year != null) ? Integer.parseInt(year) : 2024;

        return reportService.generateMolBioReport(yearInt);
    }

    @GetMapping("/microbioreport")
    public MicrobioTestReportDTO getMicrobioTestResultsReport(
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String year) {

        int yearInt = (year != null) ? Integer.parseInt(year) : 2024;

        return reportService.generateMicrobioReport(yearInt);
    }
}