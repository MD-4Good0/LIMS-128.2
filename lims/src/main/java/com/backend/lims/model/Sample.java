package com.backend.lims.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Entity
@Transactional
public class Sample {
    @Id
    private Long sampleId;
    // Sample Information
    private String sampleTypeDescription;
    private String lotBatchNo;
    private String sampleSource;
    private String sampleProvince;
    private LocalDate productionDate;
    private LocalDate expiryDate;
    private LocalDate samplingDate;
    private String samplerName;

    @ManyToOne
    @JoinColumn(name = "fkRequestId", referencedColumnName = "requestId")
    private Request request;

    public Sample() {
    }

    public Sample(Long sampleId, String sampleTypeDescription, String lotBatchNo, String sampleSource, String sampleProvince, LocalDate productionDate, LocalDate expiryDate, LocalDate samplingDate, String samplerName, Request request) {
        super();
        this.sampleId = sampleId;
        this.sampleTypeDescription = sampleTypeDescription;
        this.lotBatchNo = lotBatchNo;
        this.sampleSource = sampleSource;
        this.sampleProvince = sampleProvince;
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
        this.samplingDate = samplingDate;
        this.samplerName = samplerName;
        this.request = request;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleTypeDescription() {
        return sampleTypeDescription;
    }

    public void setSampleTypeDescription(String sampleTypeDescription) {
        this.sampleTypeDescription = sampleTypeDescription;
    }

    public String getLotBatchNo() {
        return lotBatchNo;
    }

    public void setLotBatchNo(String lotBatchNo) {
        this.lotBatchNo = lotBatchNo;
    }

    public String getSampleSource() {
        return sampleSource;
    }

    public void setSampleSource(String sampleSource) {
        this.sampleSource = sampleSource;
    }

    public String getSampleProvince() {
        return sampleProvince;
    }

    public void setSampleProvince(String sampleProvince) {
        this.sampleProvince = sampleProvince;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(LocalDate samplingDate) {
        this.samplingDate = samplingDate;
    }

    public String getSamplerName() {
        return samplerName;
    }

    public void setSamplerName(String samplerName) {
        this.samplerName = samplerName;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}