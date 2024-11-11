package com.backend.lims.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.lims.dto.ChemTestReportDTO;
import com.backend.lims.dto.MicrobialTestReportDTO;
import com.backend.lims.dto.MolBioTestReportDTO;
import com.backend.lims.repository.ChemRepository;
import com.backend.lims.repository.MicrobialRepository;
import com.backend.lims.repository.MolBioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private ChemRepository chemRepository;
    private MicrobialRepository microbialRepository;
    private MolBioRepository molBioRepository;

    @Autowired
    public ReportService(ChemRepository chemRepository, MicrobialRepository microbialRepository, MolBioRepository molBioRepository) {
        this.chemRepository = chemRepository;
        this.microbialRepository = microbialRepository;
        this.molBioRepository = molBioRepository;
    }

    public ChemTestReportDTO generateChemReport() {
        ChemTestReportDTO report = new ChemTestReportDTO();

        report.setBetaLactamsCounts(convertToMap(chemRepository.countUniqueBetaLactams()));
        report.setTetracyclinesCounts(convertToMap(chemRepository.countUniqueTetracyclines()));
        report.setSulfonamidesCounts(convertToMap(chemRepository.countUniqueSulfonamides()));
        report.setAminoglycosidesCounts(convertToMap(chemRepository.countUniqueAminoglycosides()));
        report.setMacrolidesCounts(convertToMap(chemRepository.countUniqueMacrolides()));
        report.setQuinolonesCounts(convertToMap(chemRepository.countUniqueQuinolones()));
        report.setChloramphenicolCounts(convertToMap(chemRepository.countUniqueChloramphenicol()));
        report.setNitrofuranAozCounts(convertToMap(chemRepository.countUniqueNitrofuranAoz()));
        report.setBetaAgonistsCounts(convertToMap(chemRepository.countUniqueBetaAgonists()));
        report.setCorticosteroidsCounts(convertToMap(chemRepository.countUniqueCorticosteroids()));
        report.setOlaquindoxCounts(convertToMap(chemRepository.countUniqueOlaquindox()));
        report.setNitrufuranAmozCounts(convertToMap(chemRepository.countUniqueNitrufuranAmoz()));
        report.setStilbenesCounts(convertToMap(chemRepository.countUniqueStilbenes()));
        report.setRactopamineCounts(convertToMap(chemRepository.countUniqueRactopamine()));

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

    public MicrobialTestReportDTO generateMicrobialReport() {
        MicrobialTestReportDTO report = new MicrobialTestReportDTO();

        report.setStandardPlateCount(convertToMap(microbialRepository.countUniqueStandardPlateCount()));
        report.setStaphylococcusAureus(convertToMap(microbialRepository.countUniqueStaphylococcusAureus()));
        report.setSalmonellaSp(convertToMap(microbialRepository.countUniqueSalmonellaSp()));
        report.setCampylobacter(convertToMap(microbialRepository.countUniqueCampylobacter()));
        report.setCultureAndSensitivityTest(convertToMap(microbialRepository.countUniqueCultureAndSensitivityTest()));
        report.setColiformCount(convertToMap(microbialRepository.countUniqueColiformCount()));
        report.setEColi(convertToMap(microbialRepository.countUniqueEColi()));
        report.setEColiAndeColi0O157(convertToMap(microbialRepository.countUniqueEColiAndeColi0O157()));
        report.setYeastAndMolds(convertToMap(microbialRepository.countUniqueYeastAndMolds()));

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
