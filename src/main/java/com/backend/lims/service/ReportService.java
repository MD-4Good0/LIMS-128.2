package com.backend.lims.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.lims.dto.*;
import com.backend.lims.repository.ChemElisaRepository;
import com.backend.lims.repository.ChemMicrobialRepository;
import com.backend.lims.repository.MicrobioRepository;
import com.backend.lims.repository.MolBioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ChemMicrobialRepository chemMicrobialRepository;
    private final ChemElisaRepository chemElisaRepository;
    private final MicrobioRepository microbioRepository;
    private final MolBioRepository molBioRepository;

    public ReportService(ChemMicrobialRepository chemMicrobialRepository, ChemElisaRepository chemElisaRepository, MicrobioRepository microbioRepository, MolBioRepository molBioRepository) {
        this.chemMicrobialRepository = chemMicrobialRepository;
        this.chemElisaRepository = chemElisaRepository;
        this.microbioRepository = microbioRepository;
        this.molBioRepository = molBioRepository;
    }

    @Autowired

    public ChemMicrobialTestReportDTO generateChemMicrobialReport() {
        ChemMicrobialTestReportDTO report = new ChemMicrobialTestReportDTO();

        report.setBetaLactamsCounts(convertToMap(chemMicrobialRepository.countUniqueBetaLactams()));
        report.setTetracyclinesCounts(convertToMap(chemMicrobialRepository.countUniqueTetracyclines()));
        report.setSulfonamidesCounts(convertToMap(chemMicrobialRepository.countUniqueSulfonamides()));
        report.setAminoglycosidesCounts(convertToMap(chemMicrobialRepository.countUniqueAminoglycosides()));
        report.setMacrolidesCounts(convertToMap(chemMicrobialRepository.countUniqueMacrolides()));
        report.setQuinolonesCounts(convertToMap(chemMicrobialRepository.countUniqueQuinolones()));

        return report;
    }

    public ChemElisaTestReportDTO generateChemElisaReport() {
        ChemElisaTestReportDTO report = new ChemElisaTestReportDTO();

        report.setChloramphenicolCounts(convertToMap(chemElisaRepository.countUniqueChloramphenicol()));
        report.setNitrofuranAozCounts(convertToMap(chemElisaRepository.countUniqueNitrofuranAoz()));
        report.setBetaAgonistsCounts(convertToMap(chemElisaRepository.countUniqueBetaAgonists()));
        report.setCorticosteroidsCounts(convertToMap(chemElisaRepository.countUniqueCorticosteroids()));
        report.setOlaquindoxCounts(convertToMap(chemElisaRepository.countUniqueOlaquindox()));
        report.setNitrufuranAmozCounts(convertToMap(chemElisaRepository.countUniqueNitrufuranAmoz()));
        report.setStilbenesCounts(convertToMap(chemElisaRepository.countUniqueStilbenes()));
        report.setRactopamineCounts(convertToMap(chemElisaRepository.countUniqueRactopamine()));

        return report;
    }

    public MolBioTestReportDTO generateMolBioReport() {
        MolBioTestReportDTO report = new MolBioTestReportDTO();

        report.setDogCounts(convertToMap(molBioRepository.countUniqueDog()));
        report.setCatCounts(convertToMap(molBioRepository.countUniqueCat()));
        report.setChickenCounts(convertToMap(molBioRepository.countUniqueChicken()));
        report.setBuffaloCounts(convertToMap(molBioRepository.countUniqueBuffalo()));
        report.setCattleCounts(convertToMap(molBioRepository.countUniqueCattle()));
        report.setHorseCounts(convertToMap(molBioRepository.countUniqueHorse()));
        report.setGoatCounts(convertToMap(molBioRepository.countUniqueGoat()));
        report.setSheepCounts(convertToMap(molBioRepository.countUniqueSheep()));
        report.setSwineCounts(convertToMap(molBioRepository.countUniqueSwine()));

        return report;
    }

    public MicrobioTestReportDTO generateMicrobioReport() {
        MicrobioTestReportDTO report = new MicrobioTestReportDTO();

        report.setStandardPlateCount(convertToMap(microbioRepository.countUniqueStandardPlateCount()));
        report.setStaphylococcusAureus(convertToMap(microbioRepository.countUniqueStaphylococcusAureus()));
        report.setSalmonellaSp(convertToMap(microbioRepository.countUniqueSalmonellaSp()));
        report.setCampylobacter(convertToMap(microbioRepository.countUniqueCampylobacter()));
        report.setCultureAndSensitivityTest(convertToMap(microbioRepository.countUniqueCultureAndSensitivityTest()));
        report.setColiformCount(convertToMap(microbioRepository.countUniqueColiformCount()));
        report.setEColi(convertToMap(microbioRepository.countUniqueEColi()));
        report.setEColiAndeColi0O157(convertToMap(microbioRepository.countUniqueEColiAndeColi0O157()));
        report.setYeastAndMolds(convertToMap(microbioRepository.countUniqueYeastAndMolds()));

        return report;
    }

    private Map<Object, Long> convertToMap(List<Object[]> list) {
        Map<Object, Long> resultMap = new HashMap<>();
        for (Object[] entry : list) {
            if (entry != null && entry[0] != null && entry[1] != null) {
                // Ensure entry[1] is Long, and handle null values safely
                resultMap.put(entry[0], (Long) entry[1]);
            } else {
                // Handle null cases - you can assign a default value like 0 for counts
                resultMap.put(entry[0], 0L);  // Default value for null counts
            }
        }
        return resultMap;
    }


    /*
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

     */

}
