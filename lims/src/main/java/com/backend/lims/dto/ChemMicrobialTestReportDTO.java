package com.backend.lims.dto;
import java.util.Map;

public class ChemMicrobialTestReportDTO {
    private Map<Object, Long> betaLactamsCounts;
    private Map<Object, Long> tetracyclinesCounts;
    private Map<Object, Long> sulfonamidesCounts;
    private Map<Object, Long> aminoglycosidesCounts;
    private Map<Object, Long> macrolidesCounts;
    private Map<Object, Long> quinolonesCounts;

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

}
