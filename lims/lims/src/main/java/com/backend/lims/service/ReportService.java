package com.backend.lims.service;

import java.text.DateFormatSymbols;
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
    
 // Helper method to convert the result to a count map
    private Map<Object, Long> countToMap(List<Object[]> list) {
        Map<Object, Long> resultMap = new HashMap<>();
        for (Object[] entry : list) {
            resultMap.put(entry[0], (Long) entry[1]);
        }
        return resultMap;
    }

    // Helper method to get the month name (optional, but improves readability)
    private String getMonthName(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }
    

    public ReportService(ChemMicrobialRepository chemMicrobialRepository, ChemElisaRepository chemElisaRepository, MicrobioRepository microbioRepository, MolBioRepository molBioRepository) {
        this.chemMicrobialRepository = chemMicrobialRepository;
        this.chemElisaRepository = chemElisaRepository;
        this.microbioRepository = microbioRepository;
        this.molBioRepository = molBioRepository;
    }

    @Autowired

    public ChemMicrobialTestReportDTO generateChemMicrobialReport(int year) {
        
    	ChemMicrobialTestReportDTO report = new ChemMicrobialTestReportDTO();
    	Map<String, Long> betaLactamsCounts = new HashMap<>();
    	Map<String, Long> tetracyclinesCounts = new HashMap<>();
    	Map<String, Long> sulfonamidesCounts = new HashMap<>();
    	Map<String, Long> aminoglycosidesCounts = new HashMap<>();
    	Map<String, Long> macrolidesCounts = new HashMap<>();
    	Map<String, Long> quinolonesCounts = new HashMap<>();
    	
    	 // Loop through all months from 1 (January) to 12 (December)
        for (int month = 1; month <= 12; month++) {
            // Fetch counts for each month and convert to a valid map
            Map<Object, Long> betaLactamsForMonth = countToMap(chemMicrobialRepository.countUniqueBetaLactams(month, year));
            Map<Object, Long> tetracyclinesForMonth = countToMap(chemMicrobialRepository.countUniqueTetracyclines(month, year));
            Map<Object, Long> sulfonamidesForMonth = countToMap(chemMicrobialRepository.countUniqueSulfonamides(month, year));
            Map<Object, Long> aminoglycosidesForMonth = countToMap(chemMicrobialRepository.countUniqueAminoglycosides(month, year));
            Map<Object, Long> macrolidesForMonth = countToMap(chemMicrobialRepository.countUniqueMacrolides(month, year));
            Map<Object, Long> quinolonesForMonth = countToMap(chemMicrobialRepository.countUniqueQuinolones(month, year));

            // You can sum counts for each month or handle as needed
            betaLactamsCounts.put(getMonthName(month), betaLactamsForMonth.values().stream().mapToLong(Long::longValue).sum());
            tetracyclinesCounts.put(getMonthName(month), tetracyclinesForMonth.values().stream().mapToLong(Long::longValue).sum());
            sulfonamidesCounts.put(getMonthName(month), sulfonamidesForMonth.values().stream().mapToLong(Long::longValue).sum());
            aminoglycosidesCounts.put(getMonthName(month), aminoglycosidesForMonth.values().stream().mapToLong(Long::longValue).sum());
            macrolidesCounts.put(getMonthName(month), macrolidesForMonth.values().stream().mapToLong(Long::longValue).sum());
            quinolonesCounts.put(getMonthName(month), quinolonesForMonth.values().stream().mapToLong(Long::longValue).sum());
        }
    	
    	
        report.setBetaLactamsCounts(betaLactamsCounts);
        report.setTetracyclinesCounts(tetracyclinesCounts);
        report.setSulfonamidesCounts(sulfonamidesCounts);
        report.setAminoglycosidesCounts(aminoglycosidesCounts);
        report.setMacrolidesCounts(macrolidesCounts);
        report.setQuinolonesCounts(quinolonesCounts);

        return report;
    }

    public ChemElisaTestReportDTO generateChemElisaReport(int year) {
        ChemElisaTestReportDTO report = new ChemElisaTestReportDTO();
        Map<String, Long> chloramphenicolCounts = new HashMap<>();
    	Map<String, Long> nitrofuranAozCounts = new HashMap<>();
    	Map<String, Long> betaAgonistsCounts = new HashMap<>();
    	Map<String, Long> corticosteroidsCounts = new HashMap<>();
    	Map<String, Long> olaquindoxCounts = new HashMap<>();
    	Map<String, Long> nitrufuranAmozCounts = new HashMap<>();
    	Map<String, Long> stilbenesCounts = new HashMap<>();
    	Map<String, Long> ractopamineCounts = new HashMap<>();
    	
    	 for (int month = 1; month <= 12; month++) {
             // Fetch counts for each month and convert to a valid map
             Map<Object, Long> chloramphenicolForMonth = countToMap(chemElisaRepository.countUniqueChloramphenicol(month, year));
             Map<Object, Long> nitrofuranAozForMonth = countToMap(chemElisaRepository.countUniqueNitrofuranAoz(month, year));
             Map<Object, Long> betaAgonistsForMonth = countToMap(chemElisaRepository.countUniqueBetaAgonists(month, year));
             Map<Object, Long> corticosteroidsForMonth = countToMap(chemElisaRepository.countUniqueCorticosteroids(month, year));
             Map<Object, Long> olaquindoxForMonth = countToMap(chemElisaRepository.countUniqueOlaquindox(month, year));
             Map<Object, Long> nitrufuranAmozForMonth = countToMap(chemElisaRepository.countUniqueNitrufuranAmoz(month, year));
             Map<Object, Long> stilbenesForMonth = countToMap(chemElisaRepository.countUniqueStilbenes(month, year));
             Map<Object, Long> ractopamineForMonth = countToMap(chemElisaRepository.countUniqueRactopamine(month, year));
             
             // You can sum counts for each month or handle as needed
             chloramphenicolCounts.put(getMonthName(month), chloramphenicolForMonth.values().stream().mapToLong(Long::longValue).sum());
             nitrofuranAozCounts.put(getMonthName(month), nitrofuranAozForMonth.values().stream().mapToLong(Long::longValue).sum());
             betaAgonistsCounts.put(getMonthName(month), betaAgonistsForMonth.values().stream().mapToLong(Long::longValue).sum());
             corticosteroidsCounts.put(getMonthName(month), corticosteroidsForMonth.values().stream().mapToLong(Long::longValue).sum());
             olaquindoxCounts.put(getMonthName(month), olaquindoxForMonth.values().stream().mapToLong(Long::longValue).sum());
             nitrufuranAmozCounts.put(getMonthName(month), nitrufuranAmozForMonth.values().stream().mapToLong(Long::longValue).sum());
             stilbenesCounts.put(getMonthName(month), stilbenesForMonth.values().stream().mapToLong(Long::longValue).sum());
             ractopamineCounts.put(getMonthName(month), ractopamineForMonth.values().stream().mapToLong(Long::longValue).sum());
         }

        report.setChloramphenicolCounts(chloramphenicolCounts);
        report.setNitrofuranAozCounts(nitrofuranAozCounts);
        report.setBetaAgonistsCounts(betaAgonistsCounts);
        report.setCorticosteroidsCounts(corticosteroidsCounts);
        report.setOlaquindoxCounts(olaquindoxCounts);
        report.setNitrufuranAmozCounts(nitrufuranAmozCounts);
        report.setStilbenesCounts(stilbenesCounts);
        report.setRactopamineCounts(ractopamineCounts); 

        return report;
    }

    public MolBioTestReportDTO generateMolBioReport(int year) {
        MolBioTestReportDTO report = new MolBioTestReportDTO();
        Map<String, Long> dogCounts = new HashMap<>();
        Map<String, Long> catCounts = new HashMap<>();
    	Map<String, Long> chickenCounts = new HashMap<>();
    	Map<String, Long> buffaloCounts = new HashMap<>();
    	Map<String, Long> cattleCounts = new HashMap<>();
    	Map<String, Long> horseCounts = new HashMap<>();
    	Map<String, Long> goatCounts = new HashMap<>();
    	Map<String, Long> sheepCounts = new HashMap<>();
    	Map<String, Long> swineCounts = new HashMap<>();
    	
    	for (int month = 1; month <= 12; month++) {
            // Fetch counts for each month and convert to a valid map
    		Map<Object, Long> dogForMonth = countToMap(molBioRepository.countUniqueDog(month, year));
            Map<Object, Long> catForMonth = countToMap(molBioRepository.countUniqueCat(month, year));
            Map<Object, Long> chickenForMonth = countToMap(molBioRepository.countUniqueChicken(month, year));
            Map<Object, Long> buffaloForMonth = countToMap(molBioRepository.countUniqueBuffalo(month, year));
            Map<Object, Long> cattleForMonth = countToMap(molBioRepository.countUniqueCattle(month, year));
            Map<Object, Long> horseForMonth = countToMap(molBioRepository.countUniqueHorse(month, year));
            Map<Object, Long> goatForMonth = countToMap(molBioRepository.countUniqueGoat(month, year));
            Map<Object, Long> sheepForMonth = countToMap(molBioRepository.countUniqueSheep(month, year));
            Map<Object, Long> swineForMonth = countToMap(molBioRepository.countUniqueSwine(month, year));
            
            // You can sum counts for each month or handle as needed
            dogCounts.put(getMonthName(month), dogForMonth.values().stream().mapToLong(Long::longValue).sum());
            catCounts.put(getMonthName(month), catForMonth.values().stream().mapToLong(Long::longValue).sum());
            chickenCounts.put(getMonthName(month), chickenForMonth.values().stream().mapToLong(Long::longValue).sum());
            buffaloCounts.put(getMonthName(month), buffaloForMonth.values().stream().mapToLong(Long::longValue).sum());
            cattleCounts.put(getMonthName(month), cattleForMonth.values().stream().mapToLong(Long::longValue).sum());
            horseCounts.put(getMonthName(month), horseForMonth.values().stream().mapToLong(Long::longValue).sum());
            goatCounts.put(getMonthName(month), goatForMonth.values().stream().mapToLong(Long::longValue).sum());
            sheepCounts.put(getMonthName(month), sheepForMonth.values().stream().mapToLong(Long::longValue).sum());
            swineCounts.put(getMonthName(month), swineForMonth.values().stream().mapToLong(Long::longValue).sum());
        }

        report.setDogCounts(dogCounts);
        report.setCatCounts(catCounts);
        report.setChickenCounts(chickenCounts);
        report.setBuffaloCounts(buffaloCounts);
        report.setCattleCounts(cattleCounts);
        report.setHorseCounts(horseCounts);
        report.setGoatCounts(goatCounts);
        report.setSheepCounts(sheepCounts);
        report.setSwineCounts(swineCounts); 

        return report;
    }

    public MicrobioTestReportDTO generateMicrobioReport(int year) {
        MicrobioTestReportDTO report = new MicrobioTestReportDTO();
        Map<String, Long> standardPlateCounts = new HashMap<>();
        Map<String, Long> staphylococcusAureusCounts = new HashMap<>();
    	Map<String, Long> salmonellaSpCounts = new HashMap<>();
    	Map<String, Long> campylobacterCounts = new HashMap<>();
    	Map<String, Long> cultureAndSensitivityTestCounts = new HashMap<>();
    	Map<String, Long> coliformCounts = new HashMap<>();
    	Map<String, Long> eColiCounts = new HashMap<>();
    	Map<String, Long> eColiAndeColi0O157Counts = new HashMap<>();
    	Map<String, Long> yeastAndMoldsCounts = new HashMap<>();
    	
    	for (int month = 1; month <= 12; month++) {
            // Fetch counts for each month and convert to a valid map
    		Map<Object, Long> standardPlateForMonth = countToMap(microbioRepository.countUniqueStandardPlateCount(month, year));
            Map<Object, Long> staphylococcusAureusForMonth = countToMap(microbioRepository.countUniqueStaphylococcusAureus(month, year));
            Map<Object, Long> salmonellaSpForMonth = countToMap(microbioRepository.countUniqueSalmonellaSp(month, year));
            Map<Object, Long> campylobacterForMonth = countToMap(microbioRepository.countUniqueCampylobacter(month, year));
            Map<Object, Long> cultureAndSensitivityTestForMonth = countToMap(microbioRepository.countUniqueCultureAndSensitivityTest(month, year));
            Map<Object, Long> coliformForMonth = countToMap(microbioRepository.countUniqueColiformCount(month, year));
            Map<Object, Long> eColiForMonth = countToMap(microbioRepository.countUniqueEColi(month, year));
            Map<Object, Long> eColiAndeColi0O157ForMonth = countToMap(microbioRepository.countUniqueEColiAndeColi0O157(month, year));
            Map<Object, Long> yeastAndMoldsForMonth = countToMap(microbioRepository.countUniqueYeastAndMolds(month, year));
            
            // You can sum counts for each month or handle as needed
            standardPlateCounts.put(getMonthName(month), standardPlateForMonth.values().stream().mapToLong(Long::longValue).sum());
            staphylococcusAureusCounts.put(getMonthName(month), staphylococcusAureusForMonth.values().stream().mapToLong(Long::longValue).sum());
            salmonellaSpCounts.put(getMonthName(month), salmonellaSpForMonth.values().stream().mapToLong(Long::longValue).sum());
            campylobacterCounts.put(getMonthName(month), campylobacterForMonth.values().stream().mapToLong(Long::longValue).sum());
            cultureAndSensitivityTestCounts.put(getMonthName(month), cultureAndSensitivityTestForMonth.values().stream().mapToLong(Long::longValue).sum());
            coliformCounts.put(getMonthName(month), coliformForMonth.values().stream().mapToLong(Long::longValue).sum());
            eColiCounts.put(getMonthName(month), eColiForMonth.values().stream().mapToLong(Long::longValue).sum());
            eColiAndeColi0O157Counts.put(getMonthName(month), eColiAndeColi0O157ForMonth.values().stream().mapToLong(Long::longValue).sum());
            yeastAndMoldsCounts.put(getMonthName(month), yeastAndMoldsForMonth.values().stream().mapToLong(Long::longValue).sum());
        }


        report.setStandardPlateCount(standardPlateCounts);
        report.setStaphylococcusAureus(staphylococcusAureusCounts);
        report.setSalmonellaSp(salmonellaSpCounts);
        report.setCampylobacter(campylobacterCounts);
        report.setCultureAndSensitivityTest(cultureAndSensitivityTestCounts);
        report.setColiformCount(coliformCounts);
        report.setEColi(eColiCounts);
        report.setEColiAndeColi0O157(eColiAndeColi0O157Counts);
        report.setYeastAndMolds(yeastAndMoldsCounts); 

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

}
