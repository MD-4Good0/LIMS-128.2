package com.backend.lims.service;

import com.backend.lims.dto.ChemElisaTestDTO;
import com.backend.lims.dto.ChemMicrobialTestDTO;
import com.backend.lims.dto.MicrobioTestDTO;
import com.backend.lims.dto.MolBioTestDTO;
import com.backend.lims.model.*;
import com.backend.lims.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;
    private final ChemMicrobialRepository chemMicrobialRepository;
    private final ChemElisaRepository chemElisaRepository;
    private final MicrobioRepository microbioRepository;
    private final MolBioRepository molBioRepository;
    private final RequestRepository requestRepository;
    private final SampleRepository sampleRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository, ChemMicrobialRepository chemMicrobialRepository, MicrobioRepository microbioRepository, MolBioRepository molBioRepository, RequestRepository requestRepository, SampleRepository sampleRepository, ChemElisaRepository chemElisaRepository) {
        this.resultRepository = resultRepository;
        this.chemMicrobialRepository = chemMicrobialRepository;
        this.microbioRepository = microbioRepository;
        this.molBioRepository = molBioRepository;
        this.requestRepository = requestRepository;
        this.sampleRepository = sampleRepository;
        this.chemElisaRepository = chemElisaRepository;
    }

    @Transactional
    public Result createResult(Result result, Long requestId) {
        // Save the new Result entity

        List<Long> sampleIds = sampleRepository.findSampleIdsByRequestId(requestId);
        result.setRequestId(requestId);
        Result savedResult = resultRepository.save(result);
        Request request = requestRepository.findByRequestId(requestId);
        savedResult.setCompleteRequest(Boolean.FALSE);

        if (request.getMicrobial()) {
            List<ChemMicrobialTestResults> chemMicrobialTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                ChemMicrobialTestResults chemTestResult = new ChemMicrobialTestResults();
                chemTestResult.setSampleId(sampleId);

                chemMicrobialRepository.save(chemTestResult);
                chemMicrobialTestResultsList.add(chemTestResult);
            }

            // Attach chemTestResultsList to savedResult and return
            savedResult.setChemMicrobialTestResults(chemMicrobialTestResultsList);
            savedResult.setCompleteChemMicrobial(Boolean.FALSE);
        } else {
            savedResult.setCompleteChemMicrobial(Boolean.TRUE);
        }

        if (request.getElisa()) {
            List<ChemElisaTestResults> chemElisaTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                ChemElisaTestResults chemTestResult = new ChemElisaTestResults();
                chemTestResult.setSampleId(sampleId);

                chemElisaRepository.save(chemTestResult);
                chemElisaTestResultsList.add(chemTestResult);
            }

            // Attach chemTestResultsList to savedResult and return
            savedResult.setChemElisaTestResults(chemElisaTestResultsList);
            savedResult.setCompleteChemElisa(Boolean.FALSE);
        } else {
            savedResult.setCompleteChemElisa(Boolean.TRUE);
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
            savedResult.setCompleteMolBio(Boolean.FALSE);
        } else {
            savedResult.setCompleteMolBio(Boolean.TRUE);
        }

        if (request.getMicrobio()) {
            List<MicrobioTestResults> microbioTestResultsList = new ArrayList<>();
            for (Long sampleId : sampleIds) {
                MicrobioTestResults microbioTestResult = new MicrobioTestResults();
                microbioTestResult.setSampleId(sampleId);

                microbioRepository.save(microbioTestResult);
                microbioTestResultsList.add(microbioTestResult);
            }

            // Attach MicroBioTestResultsList to savedResult and return
            savedResult.setMicrobioTestResults(microbioTestResultsList);
            savedResult.setCompleteMicrobio(Boolean.FALSE);
        } else {
            savedResult.setCompleteMicrobio(Boolean.TRUE);
        }

        // Populate ChemTestResults with sampleIds and associate with the saved Result

        return resultRepository.save(savedResult);
    }

    // Function 2: Update ChemTestResults by sampleId
    public ChemMicrobialTestResults updateChemMicrobialTestResultData(Long sampleId, ChemMicrobialTestDTO chemMicrobialTestDTO) {
        // Find the ChemTestResults by sampleId
        ChemMicrobialTestResults chemTestResult = chemMicrobialRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("ChemTestResult not found for sampleId: " + sampleId));

        //System.out.println("Line 127:" + sampleId);

        // Update fields
        chemTestResult.setBetaLactams(chemMicrobialTestDTO.getBetaLactams());
        chemTestResult.setTetracyclines(chemMicrobialTestDTO.getTetracyclines());
        chemTestResult.setSulfonamides(chemMicrobialTestDTO.getSulfonamides());
        chemTestResult.setAminoglycosides(chemMicrobialTestDTO.getAminoglycosides());
        chemTestResult.setMacrolides(chemMicrobialTestDTO.getMacrolides());
        chemTestResult.setQuinolones(chemMicrobialTestDTO.getQuinolones());

        // Update analysis dates
        chemTestResult.setBetaLactamsAnalysisDate(chemMicrobialTestDTO.getBetaLactamsAnalysisDate());
        chemTestResult.setTetracyclinesAnalysisDate(chemMicrobialTestDTO.getTetracyclinesAnalysisDate());
        chemTestResult.setSulfonamidesAnalysisDate(chemMicrobialTestDTO.getSulfonamidesAnalysisDate());
        chemTestResult.setAminoglycosidesAnalysisDate(chemMicrobialTestDTO.getAminoglycosidesAnalysisDate());
        chemTestResult.setMacrolidesAnalysisDate(chemMicrobialTestDTO.getMacrolidesAnalysisDate());
        chemTestResult.setQuinolonesAnalysisDate(chemMicrobialTestDTO.getQuinolonesAnalysisDate());

        /*
        // Update fields and set analysis dates conditionally
        if (chemTestResult.getBetaLactams() != null) {
            chemTestResult.setBetaLactamsAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getTetracyclines() != null) {
            chemTestResult.setTetracyclinesAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getSulfonamides() != null) {
            chemTestResult.setSulfonamidesAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getAminoglycosides() != null) {
            chemTestResult.setAminoglycosidesAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getMacrolides() != null) {
            chemTestResult.setMacrolidesAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getQuinolones() != null) {
            chemTestResult.setQuinolonesAnalysisDate(LocalDateTime.now());
        }


         */
        Long resultId = chemTestResult.getResult().getResultId();

        Result result = resultRepository.findByResultId(resultId);

        result.setCompleteChemMicrobial(Boolean.TRUE);

        checkCompleteRequest(resultId);

        // Save updated ChemTestResult
        return chemMicrobialRepository.save(chemTestResult);
    }

    public ChemElisaTestResults updateChemElisaTestResultData(Long sampleId, ChemElisaTestDTO chemElisaTestDTO) {
        // Find the ChemTestResults by sampleId
        ChemElisaTestResults chemTestResult = chemElisaRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("ChemTestResult not found for sampleId: " + sampleId));

        // Update fields
        chemTestResult.setChloramphenicol(chemElisaTestDTO.getChloramphenicol());
        chemTestResult.setNitrofuranAoz(chemElisaTestDTO.getNitrofuranAoz());
        chemTestResult.setBeta_agonists(chemElisaTestDTO.getBeta_agonists());
        chemTestResult.setCorticosteroids(chemElisaTestDTO.getCorticosteroids());
        chemTestResult.setOlaquindox(chemElisaTestDTO.getOlaquindox());
        chemTestResult.setNitrufuranAmoz(chemElisaTestDTO.getNitrufuranAmoz());
        chemTestResult.setStilbenes(chemElisaTestDTO.getStilbenes());
        chemTestResult.setRactopamine(chemElisaTestDTO.getRactopamine());

        // Update analysis dates
        chemTestResult.setChloramphenicolAnalysisDate(chemElisaTestDTO.getChloramphenicolAnalysisDate());
        chemTestResult.setNitrofuranAozAnalysisDate(chemElisaTestDTO.getNitrofuranAozAnalysisDate());
        chemTestResult.setBeta_agonistsAnalysisDate(chemElisaTestDTO.getBeta_agonistsAnalysisDate());
        chemTestResult.setCorticosteroidsAnalysisDate(chemElisaTestDTO.getCorticosteroidsAnalysisDate());
        chemTestResult.setOlaquindoxAnalysisDate(chemElisaTestDTO.getOlaquindoxAnalysisDate());
        chemTestResult.setNitrufuranAmozAnalysisDate(chemElisaTestDTO.getNitrufuranAmozAnalysisDate());
        chemTestResult.setStilbenesAnalysisDate(chemElisaTestDTO.getStilbenesAnalysisDate());
        chemTestResult.setRactopamineAnalysisDate(chemElisaTestDTO.getRactopamineAnalysisDate());


        /*
        if (chemTestResult.getChloramphenicol() != null) {
            chemTestResult.setChloramphenicolAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getNitrofuranAoz() != null) {
            chemTestResult.setNitrofuranAozAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getBeta_agonists() != null) {
            chemTestResult.setBeta_agonistsAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getCorticosteroids() != null) {
            chemTestResult.setCorticosteroidsAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getOlaquindox() != null) {
            chemTestResult.setOlaquindoxAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getNitrufuranAmoz() != null) {
            chemTestResult.setNitrufuranAmozAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getStilbenes() != null) {
            chemTestResult.setStilbenesAnalysisDate(LocalDateTime.now());
        }

        if (chemTestResult.getRactopamine() != null) {
            chemTestResult.setRactopamineAnalysisDate(LocalDateTime.now());
        }
         */

        Long resultId = chemTestResult.getResult().getResultId();

        Result result = resultRepository.findByResultId(resultId);

        result.setCompleteChemElisa(Boolean.TRUE);

        checkCompleteRequest(resultId);

        // Save updated ChemTestResult
        return chemElisaRepository.save(chemTestResult);
    }

    @Transactional
    public MicrobioTestResults updateMicrobioTestResultData(Long sampleId, MicrobioTestDTO microbioTestDTO) {
        // Find the MicrobioTestResults by sampleId
        MicrobioTestResults microbioTestResults = microbioRepository.findBySampleId(sampleId)
                .orElseThrow(() -> new RuntimeException("MicrobioTestResult not found for sampleId: " + sampleId));

        // Update fields
        microbioTestResults.setStandardPlateCount(microbioTestDTO.getStandardPlateCount());
        microbioTestResults.setStaphylococcusAureus(microbioTestDTO.getStaphylococcusAureus());
        microbioTestResults.setSalmonellaSp(microbioTestDTO.getSalmonellaSp());
        microbioTestResults.setCampylobacter(microbioTestDTO.getCampylobacter());
        microbioTestResults.setCultureAndSensitivityTest(microbioTestDTO.getCultureAndSensitivityTest());
        microbioTestResults.setColiformCount(microbioTestDTO.getColiformCount());
        microbioTestResults.seteColi(microbioTestDTO.geteColi());
        microbioTestResults.seteColiAndeColi0O157(microbioTestDTO.geteColiAndeColi0O157());
        microbioTestResults.setYeastAndMolds(microbioTestDTO.getYeastAndMolds());

        // Update analysis dates
        microbioTestResults.setStandardPlateCountAnalysisDate(microbioTestDTO.getStandardPlateCountAnalysisDate());
        microbioTestResults.setStaphylococcusAureusAnalysisDate(microbioTestDTO.getStaphylococcusAureusAnalysisDate());
        microbioTestResults.setSalmonellaSpAnalysisDate(microbioTestDTO.getSalmonellaSpAnalysisDate());
        microbioTestResults.setCampylobacterAnalysisDate(microbioTestDTO.getCampylobacterAnalysisDate());
        microbioTestResults.setCultureAndSensitivityTestAnalysisDate(microbioTestDTO.getCultureAndSensitivityTestAnalysisDate());
        microbioTestResults.setColiformCountAnalysisDate(microbioTestDTO.getColiformCountAnalysisDate());
        microbioTestResults.seteColiAnalysisDate(microbioTestDTO.geteColiAnalysisDate());
        microbioTestResults.seteColiAndeColi0O157AnalysisDate(microbioTestDTO.geteColiAndeColi0O157AnalysisDate());
        microbioTestResults.setYeastAndMoldsAnalysisDate(microbioTestDTO.getYeastAndMoldsAnalysisDate());

        /*
        if (microbioTestResults.getStandardPlateCount() != null) {
            microbioTestResults.setStandardPlateCountAnalysisDate(LocalDateTime.now());
        }


        if (microbioTestResults.getStaphylococcusAureus() != null) {
            microbioTestResults.setStaphylococcusAureusAnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.getSalmonellaSp() != null) {
            microbioTestResults.setSalmonellaSpAnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.getCampylobacter() != null) {
            microbioTestResults.setCampylobacterAnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.getCultureAndSensitivityTest() != null) {
            microbioTestResults.setCultureAndSensitivityTestAnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.getColiformCount() != null) {
            microbioTestResults.setColiformCountAnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.geteColi() != null) {
            microbioTestResults.seteColiAnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.geteColiAndeColi0O157() != null) {
            microbioTestResults.seteColiAndeColi0O157AnalysisDate(LocalDateTime.now());
        }

        if (microbioTestResults.getYeastAndMolds() != null) {
            microbioTestResults.setYeastAndMoldsAnalysisDate(LocalDateTime.now());
        }


         */

        Long resultId = microbioTestResults.getResult().getResultId();

        Result result = resultRepository.findByResultId(resultId);

        result.setCompleteMicrobio(Boolean.TRUE);

        checkCompleteRequest(resultId);

        // Save updated MicrobioTestResult
        return microbioRepository.save(microbioTestResults);
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

        // Update analysis dates
        molBioTestResult.setDogAnalysisDate(molBioTestDTO.getDogAnalysisDate());
        molBioTestResult.setCatAnalysisDate(molBioTestDTO.getCatAnalysisDate());
        molBioTestResult.setChickenAnalysisDate(molBioTestDTO.getChickenAnalysisDate());
        molBioTestResult.setBuffaloAnalysisDate(molBioTestDTO.getBuffaloAnalysisDate());
        molBioTestResult.setCattleAnalysisDate(molBioTestDTO.getCattleAnalysisDate());
        molBioTestResult.setHorseAnalysisDate(molBioTestDTO.getHorseAnalysisDate());
        molBioTestResult.setGoatAnalysisDate(molBioTestDTO.getGoatAnalysisDate());
        molBioTestResult.setSheepAnalysisDate(molBioTestDTO.getSheepAnalysisDate());
        molBioTestResult.setSwineAnalysisDate(molBioTestDTO.getSwineAnalysisDate());


        /*
        if (molBioTestResult.getDog() != null) {
            molBioTestResult.setDogAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getCat() != null) {
            molBioTestResult.setCatAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getChicken() != null) {
            molBioTestResult.setChickenAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getBuffalo() != null) {
            molBioTestResult.setBuffaloAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getCattle() != null) {
            molBioTestResult.setCattleAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getHorse() != null) {
            molBioTestResult.setHorseAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getGoat() != null) {
            molBioTestResult.setGoatAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getSheep() != null) {
            molBioTestResult.setSheepAnalysisDate(LocalDateTime.now());
        }

        if (molBioTestResult.getSwine() != null) {
            molBioTestResult.setSwineAnalysisDate(LocalDateTime.now());
        }

         */

        Long resultId = molBioTestResult.getResult().getResultId();

        Result result = resultRepository.findByResultId(resultId);

        result.setCompleteMolBio(Boolean.TRUE);

        checkCompleteRequest(resultId);

        // Save updated MolBioTestResult
        return molBioRepository.save(molBioTestResult);
    }

    private void checkCompleteRequest(Long resultId) {
        Result result = resultRepository.findByResultId(resultId);

        if (result.getCompleteChemElisa() == Boolean.TRUE &&
        result.getCompleteChemMicrobial() == Boolean.TRUE &&
        result.getCompleteMolBio() == Boolean.TRUE &&
        result.getCompleteMicrobio() == Boolean.TRUE) {
            result.setCompleteRequest(Boolean.TRUE);
            setForRelease(result.getRequestId());
        }

    }

    private void setForRelease(Long requestId) {
        Request request = requestRepository.findByRequestId(requestId);

        request.setRequestStatus(Request.RequestStatus.FOR_RELEASE);
    }

    public Result getFinalResult(Long requestId) {
        return resultRepository.findByRequestId(requestId);
    }
}