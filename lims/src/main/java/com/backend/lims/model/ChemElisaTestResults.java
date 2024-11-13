package com.backend.lims.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChemElisaTestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long chemElisaResultId;
    private Long sampleId;

    // Enzyme-Linked ImmunoSorbent
    private String chloramphenicol;
    private String nitrofuranAoz;
    private String beta_agonists;
    private String corticosteroids;
    private String olaquindox;
    private String nitrufuranAmoz;
    private String stilbenes;
    private String ractopamine;

    // LocalDateTime fields for analysis dates of additional substances
    private LocalDateTime chloramphenicolAnalysisDate;
    private LocalDateTime nitrofuranAozAnalysisDate;
    private LocalDateTime beta_agonistsAnalysisDate;
    private LocalDateTime corticosteroidsAnalysisDate;
    private LocalDateTime olaquindoxAnalysisDate;
    private LocalDateTime nitrufuranAmozAnalysisDate;
    private LocalDateTime stilbenesAnalysisDate;
    private LocalDateTime ractopamineAnalysisDate;
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private Result result;

    public ChemElisaTestResults() {
    }

    public ChemElisaTestResults(Long chemElisaResultId, Long sampleId, String chloramphenicol, String nitrofuranAoz, String beta_agonists, String corticosteroids, String olaquindox, String nitrufuranAmoz, String stilbenes, String ractopamine, LocalDateTime chloramphenicolAnalysisDate, LocalDateTime nitrofuranAozAnalysisDate, LocalDateTime beta_agonistsAnalysisDate, LocalDateTime corticosteroidsAnalysisDate, LocalDateTime olaquindoxAnalysisDate, LocalDateTime nitrufuranAmozAnalysisDate, LocalDateTime stilbenesAnalysisDate, LocalDateTime ractopamineAnalysisDate, Result result) {
        this.chemElisaResultId = chemElisaResultId;
        this.sampleId = sampleId;
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
        this.result = result;
    }

    public Long getChemElisaResultId() {
        return chemElisaResultId;
    }

    public void setChemElisaResultId(Long chemElisaResultId) {
        this.chemElisaResultId = chemElisaResultId;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
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

    public LocalDateTime getChloramphenicolAnalysisDate() {
        return chloramphenicolAnalysisDate;
    }

    public void setChloramphenicolAnalysisDate(LocalDateTime chloramphenicolAnalysisDate) {
        this.chloramphenicolAnalysisDate = chloramphenicolAnalysisDate;
    }

    public LocalDateTime getNitrofuranAozAnalysisDate() {
        return nitrofuranAozAnalysisDate;
    }

    public void setNitrofuranAozAnalysisDate(LocalDateTime nitrofuranAozAnalysisDate) {
        this.nitrofuranAozAnalysisDate = nitrofuranAozAnalysisDate;
    }

    public LocalDateTime getBeta_agonistsAnalysisDate() {
        return beta_agonistsAnalysisDate;
    }

    public void setBeta_agonistsAnalysisDate(LocalDateTime beta_agonistsAnalysisDate) {
        this.beta_agonistsAnalysisDate = beta_agonistsAnalysisDate;
    }

    public LocalDateTime getCorticosteroidsAnalysisDate() {
        return corticosteroidsAnalysisDate;
    }

    public void setCorticosteroidsAnalysisDate(LocalDateTime corticosteroidsAnalysisDate) {
        this.corticosteroidsAnalysisDate = corticosteroidsAnalysisDate;
    }

    public LocalDateTime getOlaquindoxAnalysisDate() {
        return olaquindoxAnalysisDate;
    }

    public void setOlaquindoxAnalysisDate(LocalDateTime olaquindoxAnalysisDate) {
        this.olaquindoxAnalysisDate = olaquindoxAnalysisDate;
    }

    public LocalDateTime getNitrufuranAmozAnalysisDate() {
        return nitrufuranAmozAnalysisDate;
    }

    public void setNitrufuranAmozAnalysisDate(LocalDateTime nitrufuranAmozAnalysisDate) {
        this.nitrufuranAmozAnalysisDate = nitrufuranAmozAnalysisDate;
    }

    public LocalDateTime getStilbenesAnalysisDate() {
        return stilbenesAnalysisDate;
    }

    public void setStilbenesAnalysisDate(LocalDateTime stilbenesAnalysisDate) {
        this.stilbenesAnalysisDate = stilbenesAnalysisDate;
    }

    public LocalDateTime getRactopamineAnalysisDate() {
        return ractopamineAnalysisDate;
    }

    public void setRactopamineAnalysisDate(LocalDateTime ractopamineAnalysisDate) {
        this.ractopamineAnalysisDate = ractopamineAnalysisDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
