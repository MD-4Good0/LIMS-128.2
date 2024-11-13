package com.backend.lims.dto;

public class ChemMicrobialTestDTO {
    private String betaLactams;
    private String tetracyclines;
    private String sulfonamides;
    private String aminoglycosides;
    private String macrolides;
    private String quinolones;

    public ChemMicrobialTestDTO() {
    }

    public ChemMicrobialTestDTO(String betaLactams, String tetracyclines, String sulfonamides, String aminoglycosides, String macrolides, String quinolones) {
        this.betaLactams = betaLactams;
        this.tetracyclines = tetracyclines;
        this.sulfonamides = sulfonamides;
        this.aminoglycosides = aminoglycosides;
        this.macrolides = macrolides;
        this.quinolones = quinolones;
    }

    public String getBetaLactams() {
        return betaLactams;
    }

    public void setBetaLactams(String betaLactams) {
        this.betaLactams = betaLactams;
    }

    public String getTetracyclines() {
        return tetracyclines;
    }

    public void setTetracyclines(String tetracyclines) {
        this.tetracyclines = tetracyclines;
    }

    public String getSulfonamides() {
        return sulfonamides;
    }

    public void setSulfonamides(String sulfonamides) {
        this.sulfonamides = sulfonamides;
    }

    public String getAminoglycosides() {
        return aminoglycosides;
    }

    public void setAminoglycosides(String aminoglycosides) {
        this.aminoglycosides = aminoglycosides;
    }

    public String getMacrolides() {
        return macrolides;
    }

    public void setMacrolides(String macrolides) {
        this.macrolides = macrolides;
    }

    public String getQuinolones() {
        return quinolones;
    }

    public void setQuinolones(String quinolones) {
        this.quinolones = quinolones;
    }
}