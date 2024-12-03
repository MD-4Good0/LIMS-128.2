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

    private Map<String, Long> chloramphenicolCountsByMonthAndYear;
    private Map<String, Long> nitrofuranAozCountsByMonthAndYear;
    private Map<String, Long> betaAgonistsCountsByMonthAndYear;
    private Map<String, Long> corticosteroidsCountsByMonthAndYear;
    private Map<String, Long> olaquindoxCountsByMonthAndYear;
    private Map<String, Long> nitrufuranAmozCountsByMonthAndYear;
    private Map<String, Long> stilbenesCountsByMonthAndYear;
    private Map<String, Long> ractopamineCountsByMonthAndYear;

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

    public Map<String, Long> getChloramphenicolCountsByMonthAndYear() {
        return chloramphenicolCountsByMonthAndYear;
    }

    public void setChloramphenicolCountsByMonthAndYear(Map<String, Long> chloramphenicolCountsByMonthAndYear) {
        this.chloramphenicolCountsByMonthAndYear = chloramphenicolCountsByMonthAndYear;
    }

    public Map<String, Long> getNitrofuranAozCountsByMonthAndYear() {
        return nitrofuranAozCountsByMonthAndYear;
    }

    public void setNitrofuranAozCountsByMonthAndYear(Map<String, Long> nitrofuranAozCountsByMonthAndYear) {
        this.nitrofuranAozCountsByMonthAndYear = nitrofuranAozCountsByMonthAndYear;
    }

    public Map<String, Long> getBetaAgonistsCountsByMonthAndYear() {
        return betaAgonistsCountsByMonthAndYear;
    }

    public void setBetaAgonistsCountsByMonthAndYear(Map<String, Long> betaAgonistsCountsByMonthAndYear) {
        this.betaAgonistsCountsByMonthAndYear = betaAgonistsCountsByMonthAndYear;
    }

    public Map<String, Long> getCorticosteroidsCountsByMonthAndYear() {
        return corticosteroidsCountsByMonthAndYear;
    }

    public void setCorticosteroidsCountsByMonthAndYear(Map<String, Long> corticosteroidsCountsByMonthAndYear) {
        this.corticosteroidsCountsByMonthAndYear = corticosteroidsCountsByMonthAndYear;
    }

    public Map<String, Long> getOlaquindoxCountsByMonthAndYear() {
        return olaquindoxCountsByMonthAndYear;
    }

    public void setOlaquindoxCountsByMonthAndYear(Map<String, Long> olaquindoxCountsByMonthAndYear) {
        this.olaquindoxCountsByMonthAndYear = olaquindoxCountsByMonthAndYear;
    }

    public Map<String, Long> getNitrufuranAmozCountsByMonthAndYear() {
        return nitrufuranAmozCountsByMonthAndYear;
    }

    public void setNitrufuranAmozCountsByMonthAndYear(Map<String, Long> nitrufuranAmozCountsByMonthAndYear) {
        this.nitrufuranAmozCountsByMonthAndYear = nitrufuranAmozCountsByMonthAndYear;
    }

    public Map<String, Long> getStilbenesCountsByMonthAndYear() {
        return stilbenesCountsByMonthAndYear;
    }

    public void setStilbenesCountsByMonthAndYear(Map<String, Long> stilbenesCountsByMonthAndYear) {
        this.stilbenesCountsByMonthAndYear = stilbenesCountsByMonthAndYear;
    }

    public Map<String, Long> getRactopamineCountsByMonthAndYear() {
        return ractopamineCountsByMonthAndYear;
    }

    public void setRactopamineCountsByMonthAndYear(Map<String, Long> ractopamineCountsByMonthAndYear) {
        this.ractopamineCountsByMonthAndYear = ractopamineCountsByMonthAndYear;
    }
}
