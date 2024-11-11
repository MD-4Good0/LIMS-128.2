package com.backend.lims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.lims.model.Report;
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

    @GetMapping("/unique-counts/aminoglycosides")
    public List<Object[]> getAminoglycosides() {
        return reportService.getChemReport();
    }
}