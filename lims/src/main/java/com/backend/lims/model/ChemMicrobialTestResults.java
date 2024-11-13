package com.backend.lims.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Entity
@Transactional
public class ChemMicrobialTestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long chemMicrobialResultId;
    private Long sampleId;
    // Microbial Inhibition
    private String betaLactams;
    private String tetracyclines;
    private String sulfonamides;
    private String aminoglycosides;
    private String macrolides;
    private String quinolones;

    // LocalDateTime fields for analysis dates of antibiotics
    private LocalDateTime betaLactamsAnalysisDate;
    private LocalDateTime tetracyclinesAnalysisDate;
    private LocalDateTime sulfonamidesAnalysisDate;
    private LocalDateTime aminoglycosidesAnalysisDate;
    private LocalDateTime macrolidesAnalysisDate;
    private LocalDateTime quinolonesAnalysisDate;

    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private Result result;

    public ChemMicrobialTestResults() {
    }

    public ChemMicrobialTestResults(Long chemMicrobialResultId, Long sampleId, String betaLactams, String tetracyclines, String sulfonamides, String aminoglycosides, String macrolides, String quinolones, LocalDateTime betaLactamsAnalysisDate, LocalDateTime tetracyclinesAnalysisDate, LocalDateTime sulfonamidesAnalysisDate, LocalDateTime aminoglycosidesAnalysisDate, LocalDateTime macrolidesAnalysisDate, LocalDateTime quinolonesAnalysisDate, Result result) {
        this.chemMicrobialResultId = chemMicrobialResultId;
        this.sampleId = sampleId;
        this.betaLactams = betaLactams;
        this.tetracyclines = tetracyclines;
        this.sulfonamides = sulfonamides;
        this.aminoglycosides = aminoglycosides;
        this.macrolides = macrolides;
        this.quinolones = quinolones;
        this.betaLactamsAnalysisDate = betaLactamsAnalysisDate;
        this.tetracyclinesAnalysisDate = tetracyclinesAnalysisDate;
        this.sulfonamidesAnalysisDate = sulfonamidesAnalysisDate;
        this.aminoglycosidesAnalysisDate = aminoglycosidesAnalysisDate;
        this.macrolidesAnalysisDate = macrolidesAnalysisDate;
        this.quinolonesAnalysisDate = quinolonesAnalysisDate;
        this.result = result;
    }

    public Long getChemMicrobialResultId() {
        return chemMicrobialResultId;
    }

    public void setChemMicrobialResultId(Long chemMicrobialResultId) {
        this.chemMicrobialResultId = chemMicrobialResultId;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
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

    public LocalDateTime getBetaLactamsAnalysisDate() {
        return betaLactamsAnalysisDate;
    }

    public void setBetaLactamsAnalysisDate(LocalDateTime betaLactamsAnalysisDate) {
        this.betaLactamsAnalysisDate = betaLactamsAnalysisDate;
    }

    public LocalDateTime getTetracyclinesAnalysisDate() {
        return tetracyclinesAnalysisDate;
    }

    public void setTetracyclinesAnalysisDate(LocalDateTime tetracyclinesAnalysisDate) {
        this.tetracyclinesAnalysisDate = tetracyclinesAnalysisDate;
    }

    public LocalDateTime getSulfonamidesAnalysisDate() {
        return sulfonamidesAnalysisDate;
    }

    public void setSulfonamidesAnalysisDate(LocalDateTime sulfonamidesAnalysisDate) {
        this.sulfonamidesAnalysisDate = sulfonamidesAnalysisDate;
    }

    public LocalDateTime getAminoglycosidesAnalysisDate() {
        return aminoglycosidesAnalysisDate;
    }

    public void setAminoglycosidesAnalysisDate(LocalDateTime aminoglycosidesAnalysisDate) {
        this.aminoglycosidesAnalysisDate = aminoglycosidesAnalysisDate;
    }

    public LocalDateTime getMacrolidesAnalysisDate() {
        return macrolidesAnalysisDate;
    }

    public void setMacrolidesAnalysisDate(LocalDateTime macrolidesAnalysisDate) {
        this.macrolidesAnalysisDate = macrolidesAnalysisDate;
    }

    public LocalDateTime getQuinolonesAnalysisDate() {
        return quinolonesAnalysisDate;
    }

    public void setQuinolonesAnalysisDate(LocalDateTime quinolonesAnalysisDate) {
        this.quinolonesAnalysisDate = quinolonesAnalysisDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}