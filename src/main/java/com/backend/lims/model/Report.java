package com.backend.lims.model;

import java.time.LocalDate;

public class Report {
    private String province;
    private String monthYear;
    private String testType;
    private long totalTests;
    private long positiveTests;
    private long negativeTests;
    private String sampleType;
    private String testingPurpose;

    public Report(String province, String monthYear, String testType, long totalTests, long positiveTests, long negativeTests, String sampleType, String testingPurpose) {
        this.province = province;
        this.monthYear = monthYear;
        this.testType = testType;
        this.totalTests = totalTests;
        this.positiveTests = positiveTests;
        this.negativeTests = negativeTests;
        this.sampleType = sampleType;
        this.testingPurpose = testingPurpose;
    }

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public long getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(long totalTests) {
		this.totalTests = totalTests;
	}

	public long getPositiveTests() {
		return positiveTests;
	}

	public void setPositiveTests(long positiveTests) {
		this.positiveTests = positiveTests;
	}

	public long getNegativeTests() {
		return negativeTests;
	}

	public void setNegativeTests(long negativeTests) {
		this.negativeTests = negativeTests;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getTestingPurpose() {
		return testingPurpose;
	}

	public void setTestingPurpose(String testingPurpose) {
		this.testingPurpose = testingPurpose;
	}
    
    
}