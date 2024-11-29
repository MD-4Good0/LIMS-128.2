package com.backend.lims.dto;

import java.util.Map;

public class ChemElisaTestReportDTO {
    private Map<String, Long> chloramphenicolCounts;
    private Map<String, Long> nitrofuranAozCounts;
    private Map<String, Long> betaAgonistsCounts;
    private Map<String, Long> corticosteroidsCounts;
    private Map<String, Long> olaquindoxCounts;
    private Map<String, Long> nitrufuranAmozCounts;
    private Map<String, Long> stilbenesCounts;
    private Map<String, Long> ractopamineCounts;

    public Map<String, Long> getChloramphenicolCounts() {
        return chloramphenicolCounts;
    }

    public void setChloramphenicolCounts(Map<String, Long> chloramphenicolCounts2) {
        this.chloramphenicolCounts = chloramphenicolCounts2;
    }

    public Map<String, Long> getNitrofuranAozCounts() {
        return nitrofuranAozCounts;
    }

    public void setNitrofuranAozCounts(Map<String, Long> nitrofuranAozCounts) {
        this.nitrofuranAozCounts = nitrofuranAozCounts;
    }

    public Map<String, Long> getBetaAgonistsCounts() {
        return betaAgonistsCounts;
    }

    public void setBetaAgonistsCounts(Map<String, Long> betaAgonistsCounts) {
        this.betaAgonistsCounts = betaAgonistsCounts;
    }

    public Map<String, Long> getCorticosteroidsCounts() {
        return corticosteroidsCounts;
    }

    public void setCorticosteroidsCounts(Map<String, Long> corticosteroidsCounts) {
        this.corticosteroidsCounts = corticosteroidsCounts;
    }

    public Map<String, Long> getOlaquindoxCounts() {
        return olaquindoxCounts;
    }

    public void setOlaquindoxCounts(Map<String, Long> olaquindoxCounts) {
        this.olaquindoxCounts = olaquindoxCounts;
    }

    public Map<String, Long> getNitrufuranAmozCounts() {
        return nitrufuranAmozCounts;
    }

    public void setNitrufuranAmozCounts(Map<String, Long> nitrufuranAmozCounts) {
        this.nitrufuranAmozCounts = nitrufuranAmozCounts;
    }

    public Map<String, Long> getStilbenesCounts() {
        return stilbenesCounts;
    }

    public void setStilbenesCounts(Map<String, Long> stilbenesCounts) {
        this.stilbenesCounts = stilbenesCounts;
    }

    public Map<String, Long> getRactopamineCounts() {
        return ractopamineCounts;
    }

    public void setRactopamineCounts(Map<String, Long> ractopamineCounts) {
        this.ractopamineCounts = ractopamineCounts;
    }
}
