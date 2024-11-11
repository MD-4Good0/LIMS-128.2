package com.backend.lims.dto;

import java.util.Map;

public class MicrobialTestReportDTO {
    private Map<Object, Long> standardPlateCount;
    private Map<Object, Long> staphylococcusAureus;
    private Map<Object, Long> salmonellaSp;
    private Map<Object, Long> campylobacter;
    private Map<Object, Long> cultureAndSensitivityTest;
    private Map<Object, Long> coliformCount;
    private Map<Object, Long> eColi;
    private Map<Object, Long> eColiAndeColi0O157;
    private Map<Object, Long> yeastAndMolds;

    public Map<Object, Long> getStandardPlateCount() {
        return standardPlateCount;
    }

    public void setStandardPlateCount(Map<Object, Long> standardPlateCount) {
        this.standardPlateCount = standardPlateCount;
    }

    public Map<Object, Long> getStaphylococcusAureus() {
        return staphylococcusAureus;
    }

    public void setStaphylococcusAureus(Map<Object, Long> staphylococcusAureus) {
        this.staphylococcusAureus = staphylococcusAureus;
    }

    public Map<Object, Long> getSalmonellaSp() {
        return salmonellaSp;
    }

    public void setSalmonellaSp(Map<Object, Long> salmonellaSp) {
        this.salmonellaSp = salmonellaSp;
    }

    public Map<Object, Long> getCampylobacter() {
        return campylobacter;
    }

    public void setCampylobacter(Map<Object, Long> campylobacter) {
        this.campylobacter = campylobacter;
    }

    public Map<Object, Long> getCultureAndSensitivityTest() {
        return cultureAndSensitivityTest;
    }

    public void setCultureAndSensitivityTest(Map<Object, Long> cultureAndSensitivityTest) {
        this.cultureAndSensitivityTest = cultureAndSensitivityTest;
    }

    public Map<Object, Long> getColiformCount() {
        return coliformCount;
    }

    public void setColiformCount(Map<Object, Long> coliformCount) {
        this.coliformCount = coliformCount;
    }

    public Map<Object, Long> getEColi() {
        return eColi;
    }

    public void setEColi(Map<Object, Long> eColi) {
        this.eColi = eColi;
    }

    public Map<Object, Long> getEColiAndeColi0O157() {
        return eColiAndeColi0O157;
    }

    public void setEColiAndeColi0O157(Map<Object, Long> eColiAndeColi0O157) {
        this.eColiAndeColi0O157 = eColiAndeColi0O157;
    }

    public Map<Object, Long> getYeastAndMolds() {
        return yeastAndMolds;
    }

    public void setYeastAndMolds(Map<Object, Long> yeastAndMolds) {
        this.yeastAndMolds = yeastAndMolds;
    }
}
