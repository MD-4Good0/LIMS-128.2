package com.backend.lims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Transactional
public class MicrobioTestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long microbioResultId;
    private Long sampleId;

    // Test Results ~> 100mg or smthng
    private String standardPlateCount;
    private String staphylococcusAureus;
    private String salmonellaSp;
    private String campylobacter;
    private String cultureAndSensitivityTest;
    private String coliformCount;
    private String eColi;
    private String eColiAndeColi0O157;
    private String yeastAndMolds;

    // Analyte Dates
    private LocalDate standardPlateCountAnalysisDate;
    private LocalDate staphylococcusAureusAnalysisDate;
    private LocalDate salmonellaSpAnalysisDate;
    private LocalDate campylobacterAnalysisDate;
    private LocalDate cultureAndSensitivityTestAnalysisDate;
    private LocalDate coliformCountAnalysisDate;
    private LocalDate eColiAnalysisDate;
    private LocalDate eColiAndeColi0O157AnalysisDate;
    private LocalDate yeastAndMoldsAnalysisDate;

    // Test Remarks ~> Positive/Negative
    private String standardPlateCountRemarks;
    private String staphylococcusAureusRemarks;
    private String salmonellaSpRemarks;
    private String campylobacterRemarks;
    private String cultureAndSensitivityTestRemarks;
    private String coliformCountRemarks;
    private String eColiRemarks;
    private String eColiAndeColi0O157Remarks;
    private String yeastAndMoldsRemarks;

    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    @JsonIgnore
    private Result result;

    public MicrobioTestResults() {
    }

    public MicrobioTestResults(Long microbioResultId, Long sampleId, String standardPlateCount, String staphylococcusAureus, String salmonellaSp, String campylobacter, String cultureAndSensitivityTest, String coliformCount, String eColi, String eColiAndeColi0O157, String yeastAndMolds, LocalDate standardPlateCountAnalysisDate, LocalDate staphylococcusAureusAnalysisDate, LocalDate salmonellaSpAnalysisDate, LocalDate campylobacterAnalysisDate, LocalDate cultureAndSensitivityTestAnalysisDate, LocalDate coliformCountAnalysisDate, LocalDate eColiAnalysisDate, LocalDate eColiAndeColi0O157AnalysisDate, LocalDate yeastAndMoldsAnalysisDate, String standardPlateCountRemarks, String staphylococcusAureusRemarks, String salmonellaSpRemarks, String campylobacterRemarks, String cultureAndSensitivityTestRemarks, String coliformCountRemarks, String eColiRemarks, String eColiAndeColi0O157Remarks, String yeastAndMoldsRemarks, Result result) {
        this.microbioResultId = microbioResultId;
        this.sampleId = sampleId;
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
        this.standardPlateCountRemarks = standardPlateCountRemarks;
        this.staphylococcusAureusRemarks = staphylococcusAureusRemarks;
        this.salmonellaSpRemarks = salmonellaSpRemarks;
        this.campylobacterRemarks = campylobacterRemarks;
        this.cultureAndSensitivityTestRemarks = cultureAndSensitivityTestRemarks;
        this.coliformCountRemarks = coliformCountRemarks;
        this.eColiRemarks = eColiRemarks;
        this.eColiAndeColi0O157Remarks = eColiAndeColi0O157Remarks;
        this.yeastAndMoldsRemarks = yeastAndMoldsRemarks;
        this.result = result;
    }

    public Long getMicrobioResultId() {
        return microbioResultId;
    }

    public void setMicrobioResultId(Long microbioResultId) {
        this.microbioResultId = microbioResultId;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
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

    public String getStandardPlateCountRemarks() {
        return standardPlateCountRemarks;
    }

    public void setStandardPlateCountRemarks(String standardPlateCountRemarks) {
        this.standardPlateCountRemarks = standardPlateCountRemarks;
    }

    public String getStaphylococcusAureusRemarks() {
        return staphylococcusAureusRemarks;
    }

    public void setStaphylococcusAureusRemarks(String staphylococcusAureusRemarks) {
        this.staphylococcusAureusRemarks = staphylococcusAureusRemarks;
    }

    public String getSalmonellaSpRemarks() {
        return salmonellaSpRemarks;
    }

    public void setSalmonellaSpRemarks(String salmonellaSpRemarks) {
        this.salmonellaSpRemarks = salmonellaSpRemarks;
    }

    public String getCampylobacterRemarks() {
        return campylobacterRemarks;
    }

    public void setCampylobacterRemarks(String campylobacterRemarks) {
        this.campylobacterRemarks = campylobacterRemarks;
    }

    public String getCultureAndSensitivityTestRemarks() {
        return cultureAndSensitivityTestRemarks;
    }

    public void setCultureAndSensitivityTestRemarks(String cultureAndSensitivityTestRemarks) {
        this.cultureAndSensitivityTestRemarks = cultureAndSensitivityTestRemarks;
    }

    public String getColiformCountRemarks() {
        return coliformCountRemarks;
    }

    public void setColiformCountRemarks(String coliformCountRemarks) {
        this.coliformCountRemarks = coliformCountRemarks;
    }

    public String geteColiRemarks() {
        return eColiRemarks;
    }

    public void seteColiRemarks(String eColiRemarks) {
        this.eColiRemarks = eColiRemarks;
    }

    public String geteColiAndeColi0O157Remarks() {
        return eColiAndeColi0O157Remarks;
    }

    public void seteColiAndeColi0O157Remarks(String eColiAndeColi0O157Remarks) {
        this.eColiAndeColi0O157Remarks = eColiAndeColi0O157Remarks;
    }

    public String getYeastAndMoldsRemarks() {
        return yeastAndMoldsRemarks;
    }

    public void setYeastAndMoldsRemarks(String yeastAndMoldsRemarks) {
        this.yeastAndMoldsRemarks = yeastAndMoldsRemarks;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}