package com.backend.lims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.time.LocalDate;
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
    private LocalDate betaLactamsAnalysisDate;
    private LocalDate tetracyclinesAnalysisDate;
    private LocalDate sulfonamidesAnalysisDate;
    private LocalDate aminoglycosidesAnalysisDate;
    private LocalDate macrolidesAnalysisDate;
    private LocalDate quinolonesAnalysisDate;
    
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    
    
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    @JsonIgnore
    private Result result;

    public ChemMicrobialTestResults() {
    }

    public ChemMicrobialTestResults(Long chemMicrobialResultId, Long sampleId, String betaLactams, String tetracyclines, String sulfonamides, String aminoglycosides, String macrolides, String quinolones, LocalDate betaLactamsAnalysisDate, LocalDate tetracyclinesAnalysisDate, LocalDate sulfonamidesAnalysisDate, LocalDate aminoglycosidesAnalysisDate, LocalDate macrolidesAnalysisDate, LocalDate quinolonesAnalysisDate, Result result) {
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

    public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
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

    public LocalDate getBetaLactamsAnalysisDate() {
        return betaLactamsAnalysisDate;
    }

    public void setBetaLactamsAnalysisDate(LocalDate betaLactamsAnalysisDate) {
        this.betaLactamsAnalysisDate = betaLactamsAnalysisDate;
    }

    public LocalDate getTetracyclinesAnalysisDate() {
        return tetracyclinesAnalysisDate;
    }

    public void setTetracyclinesAnalysisDate(LocalDate tetracyclinesAnalysisDate) {
        this.tetracyclinesAnalysisDate = tetracyclinesAnalysisDate;
    }

    public LocalDate getSulfonamidesAnalysisDate() {
        return sulfonamidesAnalysisDate;
    }

    public void setSulfonamidesAnalysisDate(LocalDate sulfonamidesAnalysisDate) {
        this.sulfonamidesAnalysisDate = sulfonamidesAnalysisDate;
    }

    public LocalDate getAminoglycosidesAnalysisDate() {
        return aminoglycosidesAnalysisDate;
    }

    public void setAminoglycosidesAnalysisDate(LocalDate aminoglycosidesAnalysisDate) {
        this.aminoglycosidesAnalysisDate = aminoglycosidesAnalysisDate;
    }

    public LocalDate getMacrolidesAnalysisDate() {
        return macrolidesAnalysisDate;
    }

    public void setMacrolidesAnalysisDate(LocalDate macrolidesAnalysisDate) {
        this.macrolidesAnalysisDate = macrolidesAnalysisDate;
    }

    public LocalDate getQuinolonesAnalysisDate() {
        return quinolonesAnalysisDate;
    }

    public void setQuinolonesAnalysisDate(LocalDate quinolonesAnalysisDate) {
        this.quinolonesAnalysisDate = quinolonesAnalysisDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}