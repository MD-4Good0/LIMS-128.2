package com.backend.lims.service;

import com.backend.lims.dto.ChemTestDTO;
import com.backend.lims.dto.MicrobialTestDTO;
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
    private final MicrobialRepository microbialRepository;
    private final MolBioRepository molBioRepository;
    private final RequestRepository requestRepository;
    private final SampleRepository sampleRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository, ChemRepository chemRepository, MicrobialRepository microbialRepository, MolBioRepository molBioRepository, RequestRepository requestRepository, SampleRepository sampleRepository) {
        this.resultRepository = resultRepository;
        this.chemRepository = chemRepository;
        this.microbialRepository = microbialRepository;
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

        if (request.getMicrobial()) {
            List<MicrobialTestResults> microbialTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                MicrobialTestResults microbialTestResult = new MicrobialTestResults();
                microbialTestResult.setSampleId(sampleId);

                microbialRepository.save(microbialTestResult);
                microbialTestResultsList.add(microbialTestResult);
            }

            // Attach chemTestResultsList to savedResult and return
            savedResult.setMicrobialTestResults(microbialTestResultsList);
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
    public MicrobialTestResults updateMicrobialTestResultData(Long sampleId, MicrobialTestDTO microbialTestDTO) {
        // Find the MicrobialTestResults by sampleId
        MicrobialTestResults microbialTestResult = microbialRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("MicrobialTestResult not found for sampleId: " + sampleId));

        // Update fields
        microbialTestResult.setStandardPlateCount(microbialTestDTO.getStandardPlateCount());
        microbialTestResult.setStaphylococcusAureus(microbialTestDTO.getStaphylococcusAureus());
        microbialTestResult.setSalmonellaSp(microbialTestDTO.getSalmonellaSp());
        microbialTestResult.setCampylobacter(microbialTestDTO.getCampylobacter());
        microbialTestResult.setCultureAndSensitivityTest(microbialTestDTO.getCultureAndSensitivityTest());
        microbialTestResult.setColiformCount(microbialTestDTO.getColiformCount());
        microbialTestResult.seteColi(microbialTestDTO.geteColi());
        microbialTestResult.seteColiAndeColi0O157(microbialTestDTO.geteColiAndeColi0O157());
        microbialTestResult.setYeastAndMolds(microbialTestDTO.getYeastAndMolds());

        // Save updated MicrobialTestResult
        return microbialRepository.save(microbialTestResult);
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