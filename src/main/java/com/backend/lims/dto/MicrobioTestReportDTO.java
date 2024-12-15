package com.backend.lims.dto;

import java.util.Map;

public class MicrobioTestReportDTO {
    private Map<Object, Long> standardPlateCount;
    private Map<Object, Long> staphylococcusAureus;
    private Map<Object, Long> salmonellaSp;
    private Map<Object, Long> campylobacter;
    private Map<Object, Long> cultureAndSensitivityTest;
    private Map<Object, Long> coliformCount;
    private Map<Object, Long> eColi;
    private Map<Object, Long> eColiAndeColi0O157;
    private Map<Object, Long> yeastAndMolds;

    private Map<String, Long> standardPlateCountCountsByMonthAndYear;
    private Map<String, Long> staphylococcusAureusCountsByMonthAndYear;
    private Map<String, Long> salmonellaSpCountsByMonthAndYear;
    private Map<String, Long> campylobacterCountsByMonthAndYear;
    private Map<String, Long> cultureAndSensitivityTestCountsByMonthAndYear;
    private Map<String, Long> coliformCountCountsByMonthAndYear;
    private Map<String, Long> eColiCountsByMonthAndYear;
    private Map<String, Long> eColiAndEColi0O157CountsByMonthAndYear;
    private Map<String, Long> yeastAndMoldsCountsByMonthAndYear;

    private Map<String, Map<String, Integer>> StandardPlatePosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> StaphylococcusPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> SalmonellaSpPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> CampylobacterPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> CultureAndSensitivityPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> ColiformPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> EColiPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> EColiAndEColiO157PosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> yeastAndMoldsPosNegCountsByMonthAndYear;

    public Map<String, Map<String, Integer>> getStandardPlatePosNegCountsByMonthAndYear() {
        return StandardPlatePosNegCountsByMonthAndYear;
    }

    public void setStandardPlatePosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> standardPlatePosNegCountsByMonthAndYear) {
        StandardPlatePosNegCountsByMonthAndYear = standardPlatePosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getStaphylococcusPosNegCountsByMonthAndYear() {
        return StaphylococcusPosNegCountsByMonthAndYear;
    }

    public void setStaphylococcusPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> staphylococcusPosNegCountsByMonthAndYear) {
        StaphylococcusPosNegCountsByMonthAndYear = staphylococcusPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getSalmonellaSpPosNegCountsByMonthAndYear() {
        return SalmonellaSpPosNegCountsByMonthAndYear;
    }

    public void setSalmonellaSpPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> salmonellaSpPosNegCountsByMonthAndYear) {
        SalmonellaSpPosNegCountsByMonthAndYear = salmonellaSpPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getCampylobacterPosNegCountsByMonthAndYear() {
        return CampylobacterPosNegCountsByMonthAndYear;
    }

    public void setCampylobacterPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> campylobacterPosNegCountsByMonthAndYear) {
        CampylobacterPosNegCountsByMonthAndYear = campylobacterPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getCultureAndSensitivityPosNegCountsByMonthAndYear() {
        return CultureAndSensitivityPosNegCountsByMonthAndYear;
    }

    public void setCultureAndSensitivityPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> cultureAndSensitivityTestPosNegCountsByMonthAndYear) {
        CultureAndSensitivityPosNegCountsByMonthAndYear = cultureAndSensitivityTestPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getColiformPosNegCountsByMonthAndYear() {
        return ColiformPosNegCountsByMonthAndYear;
    }

    public void setColiformPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> coliformPosNegCountsByMonthAndYear) {
        ColiformPosNegCountsByMonthAndYear = coliformPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getEColiPosNegCountsByMonthAndYear() {
        return EColiPosNegCountsByMonthAndYear;
    }

    public void setEColiPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> EColiPosNegCountsByMonthAndYear) {
        this.EColiPosNegCountsByMonthAndYear = EColiPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getEColiAndEColiO157PosNegCountsByMonthAndYear() {
        return EColiAndEColiO157PosNegCountsByMonthAndYear;
    }

    public void setEColiAndEColiO157PosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> EColiAndEColiO157PosNegCountsByMonthAndYear) {
        this.EColiAndEColiO157PosNegCountsByMonthAndYear = EColiAndEColiO157PosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getYeastAndMoldsPosNegCountsByMonthAndYear() {
        return yeastAndMoldsPosNegCountsByMonthAndYear;
    }

    public void setYeastAndMoldsPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> yeastAndMoldsPosNegCountsByMonthAndYear) {
        this.yeastAndMoldsPosNegCountsByMonthAndYear = yeastAndMoldsPosNegCountsByMonthAndYear;
    }

    public Map<Object, Long> geteColiAndeColi0O157() {
        return eColiAndeColi0O157;
    }

    public void seteColiAndeColi0O157(Map<Object, Long> eColiAndeColi0O157) {
        this.eColiAndeColi0O157 = eColiAndeColi0O157;
    }

    public Map<Object, Long> geteColi() {
        return eColi;
    }

    public void seteColi(Map<Object, Long> eColi) {
        this.eColi = eColi;
    }

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

    public Map<String, Long> getStandardPlateCountCountsByMonthAndYear() {
        return standardPlateCountCountsByMonthAndYear;
    }

    public void setStandardPlateCountCountsByMonthAndYear(Map<String, Long> standardPlateCountCountsByMonthAndYear) {
        this.standardPlateCountCountsByMonthAndYear = standardPlateCountCountsByMonthAndYear;
    }

    public Map<String, Long> getStaphylococcusAureusCountsByMonthAndYear() {
        return staphylococcusAureusCountsByMonthAndYear;
    }

    public void setStaphylococcusAureusCountsByMonthAndYear(Map<String, Long> staphylococcusAureusCountsByMonthAndYear) {
        this.staphylococcusAureusCountsByMonthAndYear = staphylococcusAureusCountsByMonthAndYear;
    }

    public Map<String, Long> getSalmonellaSpCountsByMonthAndYear() {
        return salmonellaSpCountsByMonthAndYear;
    }

    public void setSalmonellaSpCountsByMonthAndYear(Map<String, Long> salmonellaSpCountsByMonthAndYear) {
        this.salmonellaSpCountsByMonthAndYear = salmonellaSpCountsByMonthAndYear;
    }

    public Map<String, Long> getCampylobacterCountsByMonthAndYear() {
        return campylobacterCountsByMonthAndYear;
    }

    public void setCampylobacterCountsByMonthAndYear(Map<String, Long> campylobacterCountsByMonthAndYear) {
        this.campylobacterCountsByMonthAndYear = campylobacterCountsByMonthAndYear;
    }

    public Map<String, Long> getCultureAndSensitivityTestCountsByMonthAndYear() {
        return cultureAndSensitivityTestCountsByMonthAndYear;
    }

    public void setCultureAndSensitivityTestCountsByMonthAndYear(Map<String, Long> cultureAndSensitivityTestCountsByMonthAndYear) {
        this.cultureAndSensitivityTestCountsByMonthAndYear = cultureAndSensitivityTestCountsByMonthAndYear;
    }

    public Map<String, Long> getColiformCountCountsByMonthAndYear() {
        return coliformCountCountsByMonthAndYear;
    }

    public void setColiformCountCountsByMonthAndYear(Map<String, Long> coliformCountCountsByMonthAndYear) {
        this.coliformCountCountsByMonthAndYear = coliformCountCountsByMonthAndYear;
    }

    public Map<String, Long> geteColiCountsByMonthAndYear() {
        return eColiCountsByMonthAndYear;
    }

    public void seteColiCountsByMonthAndYear(Map<String, Long> eColiCountsByMonthAndYear) {
        this.eColiCountsByMonthAndYear = eColiCountsByMonthAndYear;
    }

    public Map<String, Long> geteColiAndEColi0O157CountsByMonthAndYear() {
        return eColiAndEColi0O157CountsByMonthAndYear;
    }

    public void seteColiAndEColi0O157CountsByMonthAndYear(Map<String, Long> eColiAndEColi0O157CountsByMonthAndYear) {
        this.eColiAndEColi0O157CountsByMonthAndYear = eColiAndEColi0O157CountsByMonthAndYear;
    }

    public Map<String, Long> getYeastAndMoldsCountsByMonthAndYear() {
        return yeastAndMoldsCountsByMonthAndYear;
    }

    public void setYeastAndMoldsCountsByMonthAndYear(Map<String, Long> yeastAndMoldsCountsByMonthAndYear) {
        this.yeastAndMoldsCountsByMonthAndYear = yeastAndMoldsCountsByMonthAndYear;
    }
}
