package com.backend.lims.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

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
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private Result result;

    public MicrobioTestResults() {
    }

    public MicrobioTestResults(Long microbioResultId, Long sampleId, String standardPlateCount, String staphylococcusAureus, String salmonellaSp, String campylobacter, String cultureAndSensitivityTest, String coliformCount, String eColi, String eColiAndeColi0O157, String yeastAndMolds, Result result) {
        super();
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
        this.result = result;
    }

    public Long getMicrobioResultId() {
        return microbioResultId;
    }

    public void setMicrobioResultId(Long microbialResultId) {
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}