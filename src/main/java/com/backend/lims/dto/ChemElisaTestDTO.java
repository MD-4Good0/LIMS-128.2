package com.backend.lims.dto;

public class ChemElisaTestDTO {
    // Enzyme-Linked ImmunoSorbent
    private String chloramphenicol;
    private String nitrofuranAoz;
    private String beta_agonists;
    private String corticosteroids;
    private String olaquindox;
    private String nitrufuranAmoz;
    private String stilbenes;
    private String ractopamine;

    public ChemElisaTestDTO() {
    }

    public ChemElisaTestDTO(String chloramphenicol, String nitrofuranAoz, String beta_agonists, String corticosteroids, String olaquindox, String nitrufuranAmoz, String stilbenes, String ractopamine) {
        this.chloramphenicol = chloramphenicol;
        this.nitrofuranAoz = nitrofuranAoz;
        this.beta_agonists = beta_agonists;
        this.corticosteroids = corticosteroids;
        this.olaquindox = olaquindox;
        this.nitrufuranAmoz = nitrufuranAmoz;
        this.stilbenes = stilbenes;
        this.ractopamine = ractopamine;
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
