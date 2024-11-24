package com.backend.lims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Entity
@Transactional
public class MicrobioTestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long microbioResultId;
    private Long sampleId;
    private String standardPlateCount;
    private String staphylococcusAureus;
    private String salmonellaSp;
    private String campylobacter;
    private String cultureAndSensitivityTest;
    private String coliformCount;
    private String eColi;
    private String eColiAndeColi0O157;
    private String yeastAndMolds;

    private LocalDateTime standardPlateCountAnalysisDate;
    private LocalDateTime staphylococcusAureusAnalysisDate;
    private LocalDateTime salmonellaSpAnalysisDate;
    private LocalDateTime campylobacterAnalysisDate;
    private LocalDateTime cultureAndSensitivityTestAnalysisDate;
    private LocalDateTime coliformCountAnalysisDate;
    private LocalDateTime eColiAnalysisDate;
    private LocalDateTime eColiAndeColi0O157AnalysisDate;
    private LocalDateTime yeastAndMoldsAnalysisDate;
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    @JsonIgnore
    private Result result;

    public MicrobioTestResults() {
    }

    public MicrobioTestResults(Long microbioResultId, Long sampleId, String standardPlateCount, String staphylococcusAureus, String salmonellaSp, String campylobacter, String cultureAndSensitivityTest, String coliformCount, String eColi, String eColiAndeColi0O157, String yeastAndMolds, LocalDateTime standardPlateCountAnalysisDate, LocalDateTime staphylococcusAureusAnalysisDate, LocalDateTime salmonellaSpAnalysisDate, LocalDateTime campylobacterAnalysisDate, LocalDateTime cultureAndSensitivityTestAnalysisDate, LocalDateTime coliformCountAnalysisDate, LocalDateTime eColiAnalysisDate, LocalDateTime eColiAndeColi0O157AnalysisDate, LocalDateTime yeastAndMoldsAnalysisDate, Result result) {
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

    public LocalDateTime getStandardPlateCountAnalysisDate() {
        return standardPlateCountAnalysisDate;
    }

    public void setStandardPlateCountAnalysisDate(LocalDateTime standardPlateCountAnalysisDate) {
        this.standardPlateCountAnalysisDate = standardPlateCountAnalysisDate;
    }

    public LocalDateTime getStaphylococcusAureusAnalysisDate() {
        return staphylococcusAureusAnalysisDate;
    }

    public void setStaphylococcusAureusAnalysisDate(LocalDateTime staphylococcusAureusAnalysisDate) {
        this.staphylococcusAureusAnalysisDate = staphylococcusAureusAnalysisDate;
    }

    public LocalDateTime getSalmonellaSpAnalysisDate() {
        return salmonellaSpAnalysisDate;
    }

    public void setSalmonellaSpAnalysisDate(LocalDateTime salmonellaSpAnalysisDate) {
        this.salmonellaSpAnalysisDate = salmonellaSpAnalysisDate;
    }

    public LocalDateTime getCampylobacterAnalysisDate() {
        return campylobacterAnalysisDate;
    }

    public void setCampylobacterAnalysisDate(LocalDateTime campylobacterAnalysisDate) {
        this.campylobacterAnalysisDate = campylobacterAnalysisDate;
    }

    public LocalDateTime getCultureAndSensitivityTestAnalysisDate() {
        return cultureAndSensitivityTestAnalysisDate;
    }

    public void setCultureAndSensitivityTestAnalysisDate(LocalDateTime cultureAndSensitivityTestAnalysisDate) {
        this.cultureAndSensitivityTestAnalysisDate = cultureAndSensitivityTestAnalysisDate;
    }

    public LocalDateTime getColiformCountAnalysisDate() {
        return coliformCountAnalysisDate;
    }

    public void setColiformCountAnalysisDate(LocalDateTime coliformCountAnalysisDate) {
        this.coliformCountAnalysisDate = coliformCountAnalysisDate;
    }

    public LocalDateTime geteColiAnalysisDate() {
        return eColiAnalysisDate;
    }

    public void seteColiAnalysisDate(LocalDateTime eColiAnalysisDate) {
        this.eColiAnalysisDate = eColiAnalysisDate;
    }

    public LocalDateTime geteColiAndeColi0O157AnalysisDate() {
        return eColiAndeColi0O157AnalysisDate;
    }

    public void seteColiAndeColi0O157AnalysisDate(LocalDateTime eColiAndeColi0O157AnalysisDate) {
        this.eColiAndeColi0O157AnalysisDate = eColiAndeColi0O157AnalysisDate;
    }

    public LocalDateTime getYeastAndMoldsAnalysisDate() {
        return yeastAndMoldsAnalysisDate;
    }

    public void setYeastAndMoldsAnalysisDate(LocalDateTime yeastAndMoldsAnalysisDate) {
        this.yeastAndMoldsAnalysisDate = yeastAndMoldsAnalysisDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}