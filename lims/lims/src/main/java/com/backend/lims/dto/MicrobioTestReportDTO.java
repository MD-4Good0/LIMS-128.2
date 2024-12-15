package com.backend.lims.dto;

import java.util.Map;

public class MicrobioTestReportDTO {
    private Map<String, Long> standardPlateCount;
    private Map<String, Long> staphylococcusAureus;
    private Map<String, Long> salmonellaSp;
    private Map<String, Long> campylobacter;
    private Map<String, Long> cultureAndSensitivityTest;
    private Map<String, Long> coliformCount;
    private Map<String, Long> eColi;
    private Map<String, Long> eColiAndeColi0O157;
    private Map<String, Long> yeastAndMolds;

    public Map<String, Long> getStandardPlateCount() {
        return standardPlateCount;
    }

    public void setStandardPlateCount(Map<String, Long> standardPlateCounts) {
        this.standardPlateCount = standardPlateCounts;
    }

    public Map<String, Long> getStaphylococcusAureus() {
        return staphylococcusAureus;
    }

    public void setStaphylococcusAureus(Map<String, Long> staphylococcusAureus) {
        this.staphylococcusAureus = staphylococcusAureus;
    }

    public Map<String, Long> getSalmonellaSp() {
        return salmonellaSp;
    }

    public void setSalmonellaSp(Map<String, Long> salmonellaSp) {
        this.salmonellaSp = salmonellaSp;
    }

    public Map<String, Long> getCampylobacter() {
        return campylobacter;
    }

    public void setCampylobacter(Map<String, Long> campylobacter) {
        this.campylobacter = campylobacter;
    }

    public Map<String, Long> getCultureAndSensitivityTest() {
        return cultureAndSensitivityTest;
    }

    public void setCultureAndSensitivityTest(Map<String, Long> cultureAndSensitivityTest) {
        this.cultureAndSensitivityTest = cultureAndSensitivityTest;
    }

    public Map<String, Long> getColiformCount() {
        return coliformCount;
    }

    public void setColiformCount(Map<String, Long> coliformCount) {
        this.coliformCount = coliformCount;
    }

    public Map<String, Long> getEColi() {
        return eColi;
    }

    public void setEColi(Map<String, Long> eColi) {
        this.eColi = eColi;
    }

    public Map<String, Long> getEColiAndeColi0O157() {
        return eColiAndeColi0O157;
    }

    public void setEColiAndeColi0O157(Map<String, Long> eColiAndeColi0O157) {
        this.eColiAndeColi0O157 = eColiAndeColi0O157;
    }

    public Map<String, Long> getYeastAndMolds() {
        return yeastAndMolds;
    }

    public void setYeastAndMolds(Map<String, Long> yeastAndMolds) {
        this.yeastAndMolds = yeastAndMolds;
    }
}
