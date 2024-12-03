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

        // Set counts for unique substances
        report.setBetaLactamsCounts(convertToMap(chemMicrobialRepository.countUniqueBetaLactams()));
        report.setTetracyclinesCounts(convertToMap(chemMicrobialRepository.countUniqueTetracyclines()));
        report.setSulfonamidesCounts(convertToMap(chemMicrobialRepository.countUniqueSulfonamides()));
        report.setAminoglycosidesCounts(convertToMap(chemMicrobialRepository.countUniqueAminoglycosides()));
        report.setMacrolidesCounts(convertToMap(chemMicrobialRepository.countUniqueMacrolides()));
        report.setQuinolonesCounts(convertToMap(chemMicrobialRepository.countUniqueQuinolones()));

// Set counts by month and year for each substance
        report.setBetaLactamsCountsByMonthAndYear(convertToMonthYearMap(chemMicrobialRepository.countBetaLactamsByMonthAndYear()));
        report.setTetracyclinesCountsByMonthAndYear(convertToMonthYearMap(chemMicrobialRepository.countTetracyclinesByMonthAndYear()));
        report.setSulfonamidesCountsByMonthAndYear(convertToMonthYearMap(chemMicrobialRepository.countSulfonamidesByMonthAndYear()));
        report.setAminoglycosidesCountsByMonthAndYear(convertToMonthYearMap(chemMicrobialRepository.countAminoglycosidesByMonthAndYear()));
        report.setMacrolidesCountsByMonthAndYear(convertToMonthYearMap(chemMicrobialRepository.countMacrolidesByMonthAndYear()));
        report.setQuinolonesCountsByMonthAndYear(convertToMonthYearMap(chemMicrobialRepository.countQuinolonesByMonthAndYear()));


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

        report.setChloramphenicolCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countChloramphenicolByMonthAndYear()));
        report.setNitrofuranAozCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countNitrofuranAozByMonthAndYear()));
        report.setBetaAgonistsCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countBetaAgonistsByMonthAndYear()));
        report.setCorticosteroidsCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countCorticosteroidsByMonthAndYear()));
        report.setOlaquindoxCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countOlaquindoxByMonthAndYear()));
        report.setNitrufuranAmozCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countNitrufuranAmozByMonthAndYear()));
        report.setStilbenesCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countStilbenesByMonthAndYear()));
        report.setRactopamineCountsByMonthAndYear(convertToMonthYearMap(chemElisaRepository.countRactopamineByMonthAndYear()));

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

        report.setDogCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countDogByMonthAndYear()));
        report.setCatCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countCatByMonthAndYear()));
        report.setChickenCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countChickenByMonthAndYear()));
        report.setBuffaloCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countBuffaloByMonthAndYear()));
        report.setCattleCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countCattleByMonthAndYear()));
        report.setHorseCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countHorseByMonthAndYear()));
        report.setGoatCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countGoatByMonthAndYear()));
        report.setSheepCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countSheepByMonthAndYear()));
        report.setSwineCountsByMonthAndYear(convertToMonthYearMap(molBioRepository.countSwineByMonthAndYear()));

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

        report.setStandardPlateCountCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countStandardPlateCountByMonthAndYear()));
        report.setStaphylococcusAureusCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countStaphylococcusAureusByMonthAndYear()));
        report.setSalmonellaSpCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countSalmonellaSpByMonthAndYear()));
        report.setCampylobacterCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countCampylobacterByMonthAndYear()));
        report.setCultureAndSensitivityTestCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countCultureAndSensitivityTestByMonthAndYear()));
        report.setColiformCountCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countColiformCountByMonthAndYear()));
        report.seteColiCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countEColiByMonthAndYear()));
        report.seteColiAndEColi0O157CountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countEColiAndEColi0O157ByMonthAndYear()));
        report.setYeastAndMoldsCountsByMonthAndYear(
                convertToMonthYearMap(microbioRepository.countYeastAndMoldsByMonthAndYear()));

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

    private Map<String, Long> convertToMonthYearMap(List<Object[]> results) {
        Map<String, Long> map = new HashMap<>();
        for (Object[] result : results) {
            Integer year = (Integer) result[0];
            Integer month = (Integer) result[1];
            Long count = (Long) result[2];

            String key;
            if (year == 0 && month == 0) {
                key = "UNKNOWN"; // Grouping for unknown dates
            } else {
                key = String.format("%04d-%02d", year, month); // Format as YYYY-MM
            }

            map.put(key, count);
        }
        return map;
    }

    /*
    private Map<String, Long> convertToMonthYearMap(List<Object[]> results) {
        Map<String, Long> map = new HashMap<>();
        for (Object[] result : results) {
            Integer year = (Integer) result[0];
            Integer month = (Integer) result[1];
            Long count = (Long) result[2];
            String key = String.format("%04d-%02d", year, month);
            map.put(key, count);
        }
        return map;
    }

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
