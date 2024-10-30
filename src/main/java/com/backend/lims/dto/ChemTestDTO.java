package com.backend.lims.dto;

public class ChemTestDTO {
    private String betaLactams;
    private String tetracyclines;
    private String sulfonamides;
    private String aminoglycosides;
    private String macrolides;
    private String quinolones;
    // Enzyme-Linked ImmunoSorbent
    private String chloramphenicol;
    private String nitrofuranAoz;
    private String beta_agonists;
    private String corticosteroids;
    private String olaquindox;
    private String nitrufuranAmoz;
    private String stilbenes;
    private String ractopamine;

    public ChemTestDTO() {
    }

    public ChemTestDTO(String betaLactams, String tetracyclines, String sulfonamides, String aminoglycosides, String macrolides, String quinolones, String chloramphenicol, String nitrofuranAoz, String beta_agonists, String corticosteroids, String olaquindox, String nitrufuranAmoz, String stilbenes, String ractopamine) {
        this.betaLactams = betaLactams;
        this.tetracyclines = tetracyclines;
        this.sulfonamides = sulfonamides;
        this.aminoglycosides = aminoglycosides;
        this.macrolides = macrolides;
        this.quinolones = quinolones;
        this.chloramphenicol = chloramphenicol;
        this.nitrofuranAoz = nitrofuranAoz;
        this.beta_agonists = beta_agonists;
        this.corticosteroids = corticosteroids;
        this.olaquindox = olaquindox;
        this.nitrufuranAmoz = nitrufuranAmoz;
        this.stilbenes = stilbenes;
        this.ractopamine = ractopamine;
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

    public String getChloramphenicol() {
        return chloramphenicol;
    }

    public void setChloramphenicol(String chloramphenicol) {
        this.chloramphenicol = chloramphenicol;
    }

    public String getNitrofuranAoz() {
        return nitrofuranAoz;
    }

    public void setNitrofuranAoz(String nitrofuranAoz) {
        this.nitrofuranAoz = nitrofuranAoz;
    }

    public String getBeta_agonists() {
        return beta_agonists;
    }

    public void setBeta_agonists(String beta_agonists) {
        this.beta_agonists = beta_agonists;
    }

    public String getCorticosteroids() {
        return corticosteroids;
    }

    public void setCorticosteroids(String corticosteroids) {
        this.corticosteroids = corticosteroids;
    }

    public String getOlaquindox() {
        return olaquindox;
    }

    public void setOlaquindox(String olaquindox) {
        this.olaquindox = olaquindox;
    }

    public String getNitrufuranAmoz() {
        return nitrufuranAmoz;
    }

    public void setNitrufuranAmoz(String nitrufuranAmoz) {
        this.nitrufuranAmoz = nitrufuranAmoz;
    }

    public String getStilbenes() {
        return stilbenes;
    }

    public void setStilbenes(String stilbenes) {
        this.stilbenes = stilbenes;
    }

    public String getRactopamine() {
        return ractopamine;
    }

    public void setRactopamine(String ractopamine) {
        this.ractopamine = ractopamine;
    }
}
