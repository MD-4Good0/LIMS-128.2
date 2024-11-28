package com.backend.lims.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class MicrobioTestDTO {
    private String standardPlateCount;
    private String staphylococcusAureus;
    private String salmonellaSp;
    private String campylobacter;
    private String cultureAndSensitivityTest;
    private String coliformCount;
    private String eColi;
    private String eColiAndeColi0O157;
    private String yeastAndMolds;
    
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

    private LocalDate standardPlateCountAnalysisDate;
    private LocalDate staphylococcusAureusAnalysisDate;
    private LocalDate salmonellaSpAnalysisDate;
    private LocalDate campylobacterAnalysisDate;
    private LocalDate cultureAndSensitivityTestAnalysisDate;
    private LocalDate coliformCountAnalysisDate;
    private LocalDate eColiAnalysisDate;
    private LocalDate eColiAndeColi0O157AnalysisDate;
    private LocalDate yeastAndMoldsAnalysisDate;

    public MicrobioTestDTO() {
    }

    public MicrobioTestDTO(String standardPlateCount, String staphylococcusAureus, String salmonellaSp, String campylobacter, String cultureAndSensitivityTest, String coliformCount, String eColi, String eColiAndeColi0O157, String yeastAndMolds, LocalDate standardPlateCountAnalysisDate, LocalDate staphylococcusAureusAnalysisDate, LocalDate salmonellaSpAnalysisDate, LocalDate campylobacterAnalysisDate, LocalDate cultureAndSensitivityTestAnalysisDate, LocalDate coliformCountAnalysisDate, LocalDate eColiAnalysisDate, LocalDate eColiAndeColi0O157AnalysisDate, LocalDate yeastAndMoldsAnalysisDate) {
        this.standardPlateCount = standardPlateCount;
        this.staphylococcusAureus = staphylococcusAureus;
        this.salmonellaSp = salmonellaSp;
        this.campylobacter = campylobacter;
        this.cultureAndSensitivityTest = cultureAndSensitivityTest;
        this.coliformCount = coliformCount;
        this.eColi = eColi;
        this.eColiAndeColi0O157 = eColiAndeColi0O157;
        this.yeastAndMolds = yeastAndMolds;
        this.standardPlateCountAnalysisDate = standardPlateCountAnalysisDate;
        this.staphylococcusAureusAnalysisDate = staphylococcusAureusAnalysisDate;
        this.salmonellaSpAnalysisDate = salmonellaSpAnalysisDate;
        this.campylobacterAnalysisDate = campylobacterAnalysisDate;
        this.cultureAndSensitivityTestAnalysisDate = cultureAndSensitivityTestAnalysisDate;
        this.coliformCountAnalysisDate = coliformCountAnalysisDate;
        this.eColiAnalysisDate = eColiAnalysisDate;
        this.eColiAndeColi0O157AnalysisDate = eColiAndeColi0O157AnalysisDate;
        this.yeastAndMoldsAnalysisDate = yeastAndMoldsAnalysisDate;
    }
    
    

    public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getStandardPlateCount() {
        return standardPlateCount;
    }

    public void setStandardPlateCount(String standardPlateCount) {
        this.standardPlateCount = standardPlateCount;
    }

    public String getStaphylococcusAureus() {
        return staphylococcusAureus;
    }

    public void setStaphylococcusAureus(String staphylococcusAureus) {
        this.staphylococcusAureus = staphylococcusAureus;
    }

    public String getSalmonellaSp() {
        return salmonellaSp;
    }

    public void setSalmonellaSp(String salmonellaSp) {
        this.salmonellaSp = salmonellaSp;
    }

    public String getCampylobacter() {
        return campylobacter;
    }

    public void setCampylobacter(String campylobacter) {
        this.campylobacter = campylobacter;
    }

    public String getCultureAndSensitivityTest() {
        return cultureAndSensitivityTest;
    }

    public void setCultureAndSensitivityTest(String cultureAndSensitivityTest) {
        this.cultureAndSensitivityTest = cultureAndSensitivityTest;
    }

    public String getColiformCount() {
        return coliformCount;
    }

    public void setColiformCount(String coliformCount) {
        this.coliformCount = coliformCount;
    }

    public String geteColi() {
        return eColi;
    }

    public void seteColi(String eColi) {
        this.eColi = eColi;
    }

    public String geteColiAndeColi0O157() {
        return eColiAndeColi0O157;
    }

    public void seteColiAndeColi0O157(String eColiAndeColi0O157) {
        this.eColiAndeColi0O157 = eColiAndeColi0O157;
    }

    public String getYeastAndMolds() {
        return yeastAndMolds;
    }

    public void setYeastAndMolds(String yeastAndMolds) {
        this.yeastAndMolds = yeastAndMolds;
    }

    public LocalDate getStandardPlateCountAnalysisDate() {
        return standardPlateCountAnalysisDate;
    }

    public void setStandardPlateCountAnalysisDate(LocalDate standardPlateCountAnalysisDate) {
        this.standardPlateCountAnalysisDate = standardPlateCountAnalysisDate;
    }

    public LocalDate getStaphylococcusAureusAnalysisDate() {
        return staphylococcusAureusAnalysisDate;
    }

    public void setStaphylococcusAureusAnalysisDate(LocalDate staphylococcusAureusAnalysisDate) {
        this.staphylococcusAureusAnalysisDate = staphylococcusAureusAnalysisDate;
    }

    public LocalDate getSalmonellaSpAnalysisDate() {
        return salmonellaSpAnalysisDate;
    }

    public void setSalmonellaSpAnalysisDate(LocalDate salmonellaSpAnalysisDate) {
        this.salmonellaSpAnalysisDate = salmonellaSpAnalysisDate;
    }

    public LocalDate getCampylobacterAnalysisDate() {
        return campylobacterAnalysisDate;
    }

    public void setCampylobacterAnalysisDate(LocalDate campylobacterAnalysisDate) {
        this.campylobacterAnalysisDate = campylobacterAnalysisDate;
    }

    public LocalDate getCultureAndSensitivityTestAnalysisDate() {
        return cultureAndSensitivityTestAnalysisDate;
    }

    public void setCultureAndSensitivityTestAnalysisDate(LocalDate cultureAndSensitivityTestAnalysisDate) {
        this.cultureAndSensitivityTestAnalysisDate = cultureAndSensitivityTestAnalysisDate;
    }

    public LocalDate getColiformCountAnalysisDate() {
        return coliformCountAnalysisDate;
    }

    public void setColiformCountAnalysisDate(LocalDate coliformCountAnalysisDate) {
        this.coliformCountAnalysisDate = coliformCountAnalysisDate;
    }

    public LocalDate geteColiAnalysisDate() {
        return eColiAnalysisDate;
    }

    public void seteColiAnalysisDate(LocalDate eColiAnalysisDate) {
        this.eColiAnalysisDate = eColiAnalysisDate;
    }

    public LocalDate geteColiAndeColi0O157AnalysisDate() {
        return eColiAndeColi0O157AnalysisDate;
    }

    public void seteColiAndeColi0O157AnalysisDate(LocalDate eColiAndeColi0O157AnalysisDate) {
        this.eColiAndeColi0O157AnalysisDate = eColiAndeColi0O157AnalysisDate;
    }

    public LocalDate getYeastAndMoldsAnalysisDate() {
        return yeastAndMoldsAnalysisDate;
    }

    public void setYeastAndMoldsAnalysisDate(LocalDate yeastAndMoldsAnalysisDate) {
        this.yeastAndMoldsAnalysisDate = yeastAndMoldsAnalysisDate;
    }
}