package com.backend.lims.service;

import com.backend.lims.dto.ChemTestDTO;
import com.backend.lims.dto.MicrobioTestDTO;
import com.backend.lims.dto.MolBioTestDTO;
import com.backend.lims.model.*;
import com.backend.lims.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;
    private final ChemRepository chemRepository;
    private final MicrobioRepository microbioRepository;
    private final MolBioRepository molBioRepository;
    private final RequestRepository requestRepository;
    private final SampleRepository sampleRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository, ChemRepository chemRepository, MicrobioRepository microbioRepository, MolBioRepository molBioRepository, RequestRepository requestRepository, SampleRepository sampleRepository) {
        this.resultRepository = resultRepository;
        this.chemRepository = chemRepository;
        this.microbioRepository = microbioRepository;
        this.molBioRepository = molBioRepository;
        this.requestRepository = requestRepository;
        this.sampleRepository = sampleRepository;
    }

    @Transactional
    public Result createResult(Result result, Long requestId) {
        // Save the new Result entity

        List<Long> sampleIds = sampleRepository.findSampleIdsByRequestId(requestId);
        result.setRequestId(requestId);
        Result savedResult = resultRepository.save(result);
        Request request = requestRepository.findByRequestId(requestId);

        if (request.getChem()) {
            List<ChemTestResults> chemTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                ChemTestResults chemTestResult = new ChemTestResults();
                chemTestResult.setSampleId(sampleId);

                chemRepository.save(chemTestResult);
                chemTestResultsList.add(chemTestResult);
            }

            // Attach chemTestResultsList to savedResult and return
            savedResult.setChemTestResults(chemTestResultsList);
        }

        if (request.getMolBio()) {
            List<MolBioTestResults> molBioTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                MolBioTestResults molBioTestResult = new MolBioTestResults();
                molBioTestResult.setSampleId(sampleId);

                molBioRepository.save(molBioTestResult);
                molBioTestResultsList.add(molBioTestResult);
            }

            // Attach chemTestResultsList to savedResult and return
            savedResult.setMolBioTestResults(molBioTestResultsList);
        }

        if (request.getMicrobio()) {
            List<MicrobioTestResults> microbioTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                MicrobioTestResults microbioTestResult = new MicrobioTestResults();
                microbioTestResult.setSampleId(sampleId);

                microbioRepository.save(microbioTestResult);
                microbioTestResultsList.add(microbioTestResult);
            }

            // Attach chemTestResultsList to savedResult and return
            savedResult.setMicrobioTestResults(microbioTestResultsList);
        }

        // Populate ChemTestResults with sampleIds and associate with the saved Result

        return resultRepository.save(savedResult);
    }

    // Function 2: Update ChemTestResults by sampleId
    public ChemTestResults updateChemTestResultData(Long sampleId, ChemTestDTO chemTestDTO) {
        // Find the ChemTestResults by sampleId
        ChemTestResults chemTestResult = chemRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("ChemTestResult not found for sampleId: " + sampleId));

        // Update fields
        chemTestResult.setBetaLactams(chemTestDTO.getBetaLactams());
        chemTestResult.setTetracyclines(chemTestDTO.getTetracyclines());
        chemTestResult.setSulfonamides(chemTestDTO.getSulfonamides());
        chemTestResult.setAminoglycosides(chemTestDTO.getAminoglycosides());
        chemTestResult.setMacrolides(chemTestDTO.getMacrolides());
        chemTestResult.setQuinolones(chemTestDTO.getQuinolones());
        chemTestResult.setChloramphenicol(chemTestDTO.getChloramphenicol());
        chemTestResult.setNitrofuranAoz(chemTestDTO.getNitrofuranAoz());
        chemTestResult.setBeta_agonists(chemTestDTO.getBeta_agonists());
        chemTestResult.setCorticosteroids(chemTestDTO.getCorticosteroids());
        chemTestResult.setOlaquindox(chemTestDTO.getOlaquindox());
        chemTestResult.setNitrufuranAmoz(chemTestDTO.getNitrufuranAmoz());
        chemTestResult.setStilbenes(chemTestDTO.getStilbenes());
        chemTestResult.setRactopamine(chemTestDTO.getRactopamine());

        // Save updated ChemTestResult
        return chemRepository.save(chemTestResult);
    }

    @Transactional
    public MicrobioTestResults updateMicrobioTestResultData(Long sampleId, MicrobioTestDTO microbioTestDTO) {
        // Find the MicrobioTestResults by sampleId
        MicrobioTestResults microbioTestResult = microbioRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("MicrobioTestResult not found for sampleId: " + sampleId));

        // Update fields
        microbioTestResult.setStandardPlateCount(microbioTestDTO.getStandardPlateCount());
        microbioTestResult.setStaphylococcusAureus(microbioTestDTO.getStaphylococcusAureus());
        microbioTestResult.setSalmonellaSp(microbioTestDTO.getSalmonellaSp());
        microbioTestResult.setCampylobacter(microbioTestDTO.getCampylobacter());
        microbioTestResult.setCultureAndSensitivityTest(microbioTestDTO.getCultureAndSensitivityTest());
        microbioTestResult.setColiformCount(microbioTestDTO.getColiformCount());
        microbioTestResult.seteColi(microbioTestDTO.geteColi());
        microbioTestResult.seteColiAndeColi0O157(microbioTestDTO.geteColiAndeColi0O157());
        microbioTestResult.setYeastAndMolds(microbioTestDTO.getYeastAndMolds());

        // Save updated MicrobioTestResult
        return microbioRepository.save(microbioTestResult);
    }

    @Transactional
    public MolBioTestResults updateMolBioTestResultData(Long sampleId, MolBioTestDTO molBioTestDTO) {
        // Find the MolBioTestResults by sampleId
        MolBioTestResults molBioTestResult = molBioRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("MolBioTestResult not found for sampleId: " + sampleId));

        // Update fields
        molBioTestResult.setDog(molBioTestDTO.getDog());
        molBioTestResult.setCat(molBioTestDTO.getCat());
        molBioTestResult.setChicken(molBioTestDTO.getChicken());
        molBioTestResult.setBuffalo(molBioTestDTO.getBuffalo());
        molBioTestResult.setCattle(molBioTestDTO.getCattle());
        molBioTestResult.setHorse(molBioTestDTO.getHorse());
        molBioTestResult.setGoat(molBioTestDTO.getGoat());
        molBioTestResult.setSheep(molBioTestDTO.getSheep());
        molBioTestResult.setSwine(molBioTestDTO.getSwine());

        // Save updated MolBioTestResult
        return molBioRepository.save(molBioTestResult);
    }
}
