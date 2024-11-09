package com.backend.lims.controller;

import com.backend.lims.dto.ChemTestDTO;
import com.backend.lims.dto.MicrobialTestDTO;
import com.backend.lims.dto.MolBioTestDTO;
import com.backend.lims.model.*;
import com.backend.lims.repository.ResultRepository;
import com.backend.lims.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/chemTestResults/{sampleId}")
    public ResponseEntity<ChemTestResults> updateChemTestResultData(
            @PathVariable Long sampleId,
            @RequestBody ChemTestDTO chemTestDTO) {

        ChemTestResults updatedResult = resultService.updateChemTestResultData(sampleId, chemTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

    @PutMapping("/microbialTestResults/{sampleId}")
    public ResponseEntity<MicrobialTestResults> updateMicrobialTestResultData(
            @PathVariable Long sampleId,
            @RequestBody MicrobialTestDTO microbialTestDTO) {

        MicrobialTestResults updatedResult = resultService.updateMicrobialTestResultData(sampleId, microbialTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

    @PutMapping("/molBioTestResults/{sampleId}")
    public ResponseEntity<MolBioTestResults> updateMolBioTestResultData(
            @PathVariable Long sampleId,
            @RequestBody MolBioTestDTO molBioTestDTO) {

        MolBioTestResults updatedResult = resultService.updateMolBioTestResultData(sampleId, molBioTestDTO);
        return ResponseEntity.ok(updatedResult);
    }

}