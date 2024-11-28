package com.backend.lims.dto;
import java.util.Map;

public class ChemMicrobialTestReportDTO {
    private Map<String, Long> betaLactamsCounts;
    private Map<String, Long> tetracyclinesCounts;
    private Map<String, Long> sulfonamidesCounts;
    private Map<String, Long> aminoglycosidesCounts;
    private Map<String, Long> macrolidesCounts;
    private Map<String, Long> quinolonesCounts;

    public Map<String, Long> getBetaLactamsCounts() {
        return betaLactamsCounts;
    }

    public void setBetaLactamsCounts(Map<String, Long> betaLactamsCounts2) {
        this.betaLactamsCounts = betaLactamsCounts2;
    }

    public Map<String, Long> getTetracyclinesCounts() {
        return tetracyclinesCounts;
    }

    public void setTetracyclinesCounts(Map<String, Long> tetracyclinesCounts) {
        this.tetracyclinesCounts = tetracyclinesCounts;
    }

    public Map<String, Long> getSulfonamidesCounts() {
        return sulfonamidesCounts;
    }

    public void setSulfonamidesCounts(Map<String, Long> sulfonamidesCounts) {
        this.sulfonamidesCounts = sulfonamidesCounts;
    }

    public Map<String, Long> getAminoglycosidesCounts() {
        return aminoglycosidesCounts;
    }

    public void setAminoglycosidesCounts(Map<String, Long> aminoglycosidesCounts) {
        this.aminoglycosidesCounts = aminoglycosidesCounts;
    }

    public Map<String, Long> getMacrolidesCounts() {
        return macrolidesCounts;
    }

    public void setMacrolidesCounts(Map<String, Long> macrolidesCounts) {
        this.macrolidesCounts = macrolidesCounts;
    }

    public Map<String, Long> getQuinolonesCounts() {
        return quinolonesCounts;
    }

    public void setQuinolonesCounts(Map<String, Long> quinolonesCounts) {
        this.quinolonesCounts = quinolonesCounts;
    }

}
