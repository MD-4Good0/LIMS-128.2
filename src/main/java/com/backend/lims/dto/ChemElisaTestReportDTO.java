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

    private Map<String, Map<String, Integer>> ChloramphenicolPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> NitrofuranAozPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> BetaAgonistsPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> CorticosteroidsPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> OlaquindoxPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> NitrofuranAmozPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> StilbenesPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> RactopaminePosNegCountsByMonthAndYear;

    public Map<String, Map<String, Integer>> getChloramphenicolPosNegCountsByMonthAndYear() {
        return ChloramphenicolPosNegCountsByMonthAndYear;
    }

    public void setChloramphenicolPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> chloramphenicolPosNegCountsByMonthAndYear) {
        ChloramphenicolPosNegCountsByMonthAndYear = chloramphenicolPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getNitrofuranAozPosNegCountsByMonthAndYear() {
        return NitrofuranAozPosNegCountsByMonthAndYear;
    }

    public void setNitrofuranAozPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> nitrofuranAozPosNegCountsByMonthAndYear) {
        NitrofuranAozPosNegCountsByMonthAndYear = nitrofuranAozPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getBetaAgonistsPosNegCountsByMonthAndYear() {
        return BetaAgonistsPosNegCountsByMonthAndYear;
    }

    public void setBetaAgonistsPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> betaAgonistsPosNegCountsByMonthAndYear) {
        BetaAgonistsPosNegCountsByMonthAndYear = betaAgonistsPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getCorticosteroidsPosNegCountsByMonthAndYear() {
        return CorticosteroidsPosNegCountsByMonthAndYear;
    }

    public void setCorticosteroidsPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> corticosteroidsPosNegCountsByMonthAndYear) {
        CorticosteroidsPosNegCountsByMonthAndYear = corticosteroidsPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getOlaquindoxPosNegCountsByMonthAndYear() {
        return OlaquindoxPosNegCountsByMonthAndYear;
    }

    public void setOlaquindoxPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> olaquindoxPosNegCountsByMonthAndYear) {
        OlaquindoxPosNegCountsByMonthAndYear = olaquindoxPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getNitrofuranAmozPosNegCountsByMonthAndYear() {
        return NitrofuranAmozPosNegCountsByMonthAndYear;
    }

    public void setNitrofuranAmozPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> nitrofuranAmozPosNegCountsByMonthAndYear) {
        NitrofuranAmozPosNegCountsByMonthAndYear = nitrofuranAmozPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getStilbenesPosNegCountsByMonthAndYear() {
        return StilbenesPosNegCountsByMonthAndYear;
    }

    public void setStilbenesPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> stilbenesPosNegCountsByMonthAndYear) {
        StilbenesPosNegCountsByMonthAndYear = stilbenesPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getRactopaminePosNegCountsByMonthAndYear() {
        return RactopaminePosNegCountsByMonthAndYear;
    }

    public void setRactopaminePosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> ractopaminePosNegCountsByMonthAndYear) {
        RactopaminePosNegCountsByMonthAndYear = ractopaminePosNegCountsByMonthAndYear;
    }

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
