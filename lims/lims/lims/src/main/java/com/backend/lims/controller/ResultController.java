package com.backend.lims.controller;

import com.backend.lims.dto.ChemElisaTestDTO;
import com.backend.lims.dto.ChemMicrobialTestDTO;
import com.backend.lims.dto.MicrobioTestDTO;
import com.backend.lims.dto.MolBioTestDTO;
import com.backend.lims.model.*;
import com.backend.lims.service.ResultService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {
    public final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/createresult/{requestId}")
    public ResponseEntity<Result> createResult(@RequestBody Result result, @PathVariable Long requestId) {
        return new ResponseEntity<>(resultService.createResult(result, requestId), HttpStatus.CREATED);
    }

    @PutMapping("/microbioTestResults/{sampleId}")
    public ResponseEntity<MicrobioTestResults> updateMicrobioTestResultData(
            @PathVariable Long sampleId,
            @RequestBody MicrobioTestDTO microbioTestDTO) {

        MicrobioTestResults updatedResult = resultService.updateMicrobioTestResultData(sampleId, microbioTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

    @PutMapping("/chemMicrobialTestResults/{sampleId}")
    public ResponseEntity<ChemMicrobialTestResults> updateChemMicrobialTestResultData(
            @PathVariable Long sampleId,
            @RequestBody ChemMicrobialTestDTO chemMicrobialTestDTO) {

        ChemMicrobialTestResults updatedResult = resultService.updateChemMicrobialTestResultData(sampleId, chemMicrobialTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

    @PutMapping("/chemTestElisaResults/{sampleId}")
    public ResponseEntity<ChemElisaTestResults> updateChemElisaTestResultData(
            @PathVariable Long sampleId,
            @RequestBody ChemElisaTestDTO chemElisaTestDTO) {

        ChemElisaTestResults updatedResult = resultService.updateChemElisaTestResultData(sampleId, chemElisaTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

    @PutMapping("/molBioTestResults/{sampleId}")
    public ResponseEntity<MolBioTestResults> updateMolBioTestResultData(
            @PathVariable Long sampleId,
            @RequestBody MolBioTestDTO molBioTestDTO) {

        MolBioTestResults updatedResult = resultService.updateMolBioTestResultData(sampleId, molBioTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

    @GetMapping("/molBioTestResults")
    public ResponseEntity<List<MolBioTestResults>> getAllMolBioTestResults() {
        List<MolBioTestResults> results = resultService.getAllMolBioTestResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/chemElisaTestResults")
    public ResponseEntity<List<ChemElisaTestResults>> getAllChemElisaTestResults() {
        List<ChemElisaTestResults> results = resultService.getAllChemElisaTestResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/chemMicrobialTestResults")
    public ResponseEntity<List<ChemMicrobialTestResults>> getAllChemMicrobialTestResults() {
        List<ChemMicrobialTestResults> results = resultService.getAllChemMicrobialTestResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/microbioTestResults")
    public ResponseEntity<List<MicrobioTestResults>> getAllMicrobioTestResults() {
        List<MicrobioTestResults> results = resultService.getAllMicrobioTestResults();
        return ResponseEntity.ok(results);
    }

}