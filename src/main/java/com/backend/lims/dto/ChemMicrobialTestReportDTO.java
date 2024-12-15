package com.backend.lims.dto;
import java.util.Map;

public class ChemMicrobialTestReportDTO {
    private Map<Object, Long> betaLactamsCounts;
    private Map<Object, Long> tetracyclinesCounts;
    private Map<Object, Long> sulfonamidesCounts;
    private Map<Object, Long> aminoglycosidesCounts;
    private Map<Object, Long> macrolidesCounts;
    private Map<Object, Long> quinolonesCounts;

    private Map<String, Long> betaLactamsCountsByMonthAndYear;
    private Map<String, Long> tetracyclinesCountsByMonthAndYear;
    private Map<String, Long> sulfonamidesCountsByMonthAndYear;
    private Map<String, Long> aminoglycosidesCountsByMonthAndYear;
    private Map<String, Long> macrolidesCountsByMonthAndYear;
    private Map<String, Long> quinolonesCountsByMonthAndYear;

    private Map<String, Map<String, Integer>> BetaLactamsPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> TetracyclinesPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> SulfonamidesPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> AminoglycosidesPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> MacrolidesPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> QuinolonesPosNegCountsByMonthAndYear;

    public Map<String, Map<String, Integer>> getBetaLactamsPosNegCountsByMonthAndYear() {
        return BetaLactamsPosNegCountsByMonthAndYear;
    }

    public void setBetaLactamsPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> betaLactamsPosNegCountsByMonthAndYear) {
        BetaLactamsPosNegCountsByMonthAndYear = betaLactamsPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getTetracyclinesPosNegCountsByMonthAndYear() {
        return TetracyclinesPosNegCountsByMonthAndYear;
    }

    public void setTetracyclinesPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> tetracyclinesPosNegCountsByMonthAndYear) {
        TetracyclinesPosNegCountsByMonthAndYear = tetracyclinesPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getSulfonamidesPosNegCountsByMonthAndYear() {
        return SulfonamidesPosNegCountsByMonthAndYear;
    }

    public void setSulfonamidesPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> sulfonamidesPosNegCountsByMonthAndYear) {
        SulfonamidesPosNegCountsByMonthAndYear = sulfonamidesPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getAminoglycosidesPosNegCountsByMonthAndYear() {
        return AminoglycosidesPosNegCountsByMonthAndYear;
    }

    public void setAminoglycosidesPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> aminoglycosidesPosNegCountsByMonthAndYear) {
        AminoglycosidesPosNegCountsByMonthAndYear = aminoglycosidesPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getMacrolidesPosNegCountsByMonthAndYear() {
        return MacrolidesPosNegCountsByMonthAndYear;
    }

    public void setMacrolidesPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> macrolidesPosNegCountsByMonthAndYear) {
        MacrolidesPosNegCountsByMonthAndYear = macrolidesPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getQuinolonesPosNegCountsByMonthAndYear() {
        return QuinolonesPosNegCountsByMonthAndYear;
    }

    public void setQuinolonesPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> quinolonesPosNegCountsByMonthAndYear) {
        QuinolonesPosNegCountsByMonthAndYear = quinolonesPosNegCountsByMonthAndYear;
    }

    public Map<Object, Long> getBetaLactamsCounts() {
        return betaLactamsCounts;
    }

    public void setBetaLactamsCounts(Map<Object, Long> betaLactamsCounts) {
        this.betaLactamsCounts = betaLactamsCounts;
    }

    public Map<Object, Long> getTetracyclinesCounts() {
        return tetracyclinesCounts;
    }

    public void setTetracyclinesCounts(Map<Object, Long> tetracyclinesCounts) {
        this.tetracyclinesCounts = tetracyclinesCounts;
    }

    public Map<Object, Long> getSulfonamidesCounts() {
        return sulfonamidesCounts;
    }

    public void setSulfonamidesCounts(Map<Object, Long> sulfonamidesCounts) {
        this.sulfonamidesCounts = sulfonamidesCounts;
    }

    public Map<Object, Long> getAminoglycosidesCounts() {
        return aminoglycosidesCounts;
    }

    public void setAminoglycosidesCounts(Map<Object, Long> aminoglycosidesCounts) {
        this.aminoglycosidesCounts = aminoglycosidesCounts;
    }

    public Map<Object, Long> getMacrolidesCounts() {
        return macrolidesCounts;
    }

    public void setMacrolidesCounts(Map<Object, Long> macrolidesCounts) {
        this.macrolidesCounts = macrolidesCounts;
    }

    public Map<Object, Long> getQuinolonesCounts() {
        return quinolonesCounts;
    }

    public void setQuinolonesCounts(Map<Object, Long> quinolonesCounts) {
        this.quinolonesCounts = quinolonesCounts;
    }

    public Map<String, Long> getBetaLactamsCountsByMonthAndYear() {
        return betaLactamsCountsByMonthAndYear;
    }

    public void setBetaLactamsCountsByMonthAndYear(Map<String, Long> betaLactamsCountsByMonthAndYear) {
        this.betaLactamsCountsByMonthAndYear = betaLactamsCountsByMonthAndYear;
    }

    public Map<String, Long> getTetracyclinesCountsByMonthAndYear() {
        return tetracyclinesCountsByMonthAndYear;
    }

    public void setTetracyclinesCountsByMonthAndYear(Map<String, Long> tetracyclinesCountsByMonthAndYear) {
        this.tetracyclinesCountsByMonthAndYear = tetracyclinesCountsByMonthAndYear;
    }

    public Map<String, Long> getSulfonamidesCountsByMonthAndYear() {
        return sulfonamidesCountsByMonthAndYear;
    }

    public void setSulfonamidesCountsByMonthAndYear(Map<String, Long> sulfonamidesCountsByMonthAndYear) {
        this.sulfonamidesCountsByMonthAndYear = sulfonamidesCountsByMonthAndYear;
    }

    public Map<String, Long> getAminoglycosidesCountsByMonthAndYear() {
        return aminoglycosidesCountsByMonthAndYear;
    }

    public void setAminoglycosidesCountsByMonthAndYear(Map<String, Long> aminoglycosidesCountsByMonthAndYear) {
        this.aminoglycosidesCountsByMonthAndYear = aminoglycosidesCountsByMonthAndYear;
    }

    public Map<String, Long> getMacrolidesCountsByMonthAndYear() {
        return macrolidesCountsByMonthAndYear;
    }

    public void setMacrolidesCountsByMonthAndYear(Map<String, Long> macrolidesCountsByMonthAndYear) {
        this.macrolidesCountsByMonthAndYear = macrolidesCountsByMonthAndYear;
    }

    public Map<String, Long> getQuinolonesCountsByMonthAndYear() {
        return quinolonesCountsByMonthAndYear;
    }

    public void setQuinolonesCountsByMonthAndYear(Map<String, Long> quinolonesCountsByMonthAndYear) {
        this.quinolonesCountsByMonthAndYear = quinolonesCountsByMonthAndYear;
    }
}
