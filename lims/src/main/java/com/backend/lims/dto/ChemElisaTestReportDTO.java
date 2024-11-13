package com.backend.lims.dto;

import java.util.Map;

public class ChemElisaTestReportDTO {
    private Map<Object, Long> chloramphenicolCounts;
    private Map<Object, Long> nitrofuranAozCounts;
    private Map<Object, Long> betaAgonistsCounts;
    private Map<Object, Long> corticosteroidsCounts;
    private Map<Object, Long> olaquindoxCounts;
    private Map<Object, Long> nitrufuranAmozCounts;
    private Map<Object, Long> stilbenesCounts;
    private Map<Object, Long> ractopamineCounts;

    public Map<Object, Long> getChloramphenicolCounts() {
        return chloramphenicolCounts;
    }

    public void setChloramphenicolCounts(Map<Object, Long> chloramphenicolCounts) {
        this.chloramphenicolCounts = chloramphenicolCounts;
    }

    public Map<Object, Long> getNitrofuranAozCounts() {
        return nitrofuranAozCounts;
    }

    public void setNitrofuranAozCounts(Map<Object, Long> nitrofuranAozCounts) {
        this.nitrofuranAozCounts = nitrofuranAozCounts;
    }

    public Map<Object, Long> getBetaAgonistsCounts() {
        return betaAgonistsCounts;
    }

    public void setBetaAgonistsCounts(Map<Object, Long> betaAgonistsCounts) {
        this.betaAgonistsCounts = betaAgonistsCounts;
    }

    public Map<Object, Long> getCorticosteroidsCounts() {
        return corticosteroidsCounts;
    }

    public void setCorticosteroidsCounts(Map<Object, Long> corticosteroidsCounts) {
        this.corticosteroidsCounts = corticosteroidsCounts;
    }

    public Map<Object, Long> getOlaquindoxCounts() {
        return olaquindoxCounts;
    }

    public void setOlaquindoxCounts(Map<Object, Long> olaquindoxCounts) {
        this.olaquindoxCounts = olaquindoxCounts;
    }

    public Map<Object, Long> getNitrufuranAmozCounts() {
        return nitrufuranAmozCounts;
    }

    public void setNitrufuranAmozCounts(Map<Object, Long> nitrufuranAmozCounts) {
        this.nitrufuranAmozCounts = nitrufuranAmozCounts;
    }

    public Map<Object, Long> getStilbenesCounts() {
        return stilbenesCounts;
    }

    public void setStilbenesCounts(Map<Object, Long> stilbenesCounts) {
        this.stilbenesCounts = stilbenesCounts;
    }

    public Map<Object, Long> getRactopamineCounts() {
        return ractopamineCounts;
    }

    public void setRactopamineCounts(Map<Object, Long> ractopamineCounts) {
        this.ractopamineCounts = ractopamineCounts;
    }
}
