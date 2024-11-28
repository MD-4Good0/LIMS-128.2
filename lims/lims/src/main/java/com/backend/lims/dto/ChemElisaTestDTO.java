package com.backend.lims.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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
    
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

    private LocalDate chloramphenicolAnalysisDate;
    private LocalDate nitrofuranAozAnalysisDate;
    private LocalDate beta_agonistsAnalysisDate;
    private LocalDate corticosteroidsAnalysisDate;
    private LocalDate olaquindoxAnalysisDate;
    private LocalDate nitrufuranAmozAnalysisDate;
    private LocalDate stilbenesAnalysisDate;
    private LocalDate ractopamineAnalysisDate;

    public ChemElisaTestDTO() {
    }

    public ChemElisaTestDTO(String chloramphenicol, String nitrofuranAoz, String beta_agonists, String corticosteroids, String olaquindox, String nitrufuranAmoz, String stilbenes, String ractopamine, LocalDate chloramphenicolAnalysisDate, LocalDate nitrofuranAozAnalysisDate, LocalDate beta_agonistsAnalysisDate, LocalDate corticosteroidsAnalysisDate, LocalDate olaquindoxAnalysisDate, LocalDate nitrufuranAmozAnalysisDate, LocalDate stilbenesAnalysisDate, LocalDate ractopamineAnalysisDate) {
        this.chloramphenicol = chloramphenicol;
        this.nitrofuranAoz = nitrofuranAoz;
        this.beta_agonists = beta_agonists;
        this.corticosteroids = corticosteroids;
        this.olaquindox = olaquindox;
        this.nitrufuranAmoz = nitrufuranAmoz;
        this.stilbenes = stilbenes;
        this.ractopamine = ractopamine;
        this.chloramphenicolAnalysisDate = chloramphenicolAnalysisDate;
        this.nitrofuranAozAnalysisDate = nitrofuranAozAnalysisDate;
        this.beta_agonistsAnalysisDate = beta_agonistsAnalysisDate;
        this.corticosteroidsAnalysisDate = corticosteroidsAnalysisDate;
        this.olaquindoxAnalysisDate = olaquindoxAnalysisDate;
        this.nitrufuranAmozAnalysisDate = nitrufuranAmozAnalysisDate;
        this.stilbenesAnalysisDate = stilbenesAnalysisDate;
        this.ractopamineAnalysisDate = ractopamineAnalysisDate;
    }
    
    

    public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
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

    public LocalDate getChloramphenicolAnalysisDate() {
        return chloramphenicolAnalysisDate;
    }

    public void setChloramphenicolAnalysisDate(LocalDate chloramphenicolAnalysisDate) {
        this.chloramphenicolAnalysisDate = chloramphenicolAnalysisDate;
    }

    public LocalDate getNitrofuranAozAnalysisDate() {
        return nitrofuranAozAnalysisDate;
    }

    public void setNitrofuranAozAnalysisDate(LocalDate nitrofuranAozAnalysisDate) {
        this.nitrofuranAozAnalysisDate = nitrofuranAozAnalysisDate;
    }

    public LocalDate getBeta_agonistsAnalysisDate() {
        return beta_agonistsAnalysisDate;
    }

    public void setBeta_agonistsAnalysisDate(LocalDate beta_agonistsAnalysisDate) {
        this.beta_agonistsAnalysisDate = beta_agonistsAnalysisDate;
    }

    public LocalDate getCorticosteroidsAnalysisDate() {
        return corticosteroidsAnalysisDate;
    }

    public void setCorticosteroidsAnalysisDate(LocalDate corticosteroidsAnalysisDate) {
        this.corticosteroidsAnalysisDate = corticosteroidsAnalysisDate;
    }

    public LocalDate getOlaquindoxAnalysisDate() {
        return olaquindoxAnalysisDate;
    }

    public void setOlaquindoxAnalysisDate(LocalDate olaquindoxAnalysisDate) {
        this.olaquindoxAnalysisDate = olaquindoxAnalysisDate;
    }

    public LocalDate getNitrufuranAmozAnalysisDate() {
        return nitrufuranAmozAnalysisDate;
    }

    public void setNitrufuranAmozAnalysisDate(LocalDate nitrufuranAmozAnalysisDate) {
        this.nitrufuranAmozAnalysisDate = nitrufuranAmozAnalysisDate;
    }

    public LocalDate getStilbenesAnalysisDate() {
        return stilbenesAnalysisDate;
    }

    public void setStilbenesAnalysisDate(LocalDate stilbenesAnalysisDate) {
        this.stilbenesAnalysisDate = stilbenesAnalysisDate;
    }

    public LocalDate getRactopamineAnalysisDate() {
        return ractopamineAnalysisDate;
    }

    public void setRactopamineAnalysisDate(LocalDate ractopamineAnalysisDate) {
        this.ractopamineAnalysisDate = ractopamineAnalysisDate;
    }
}
