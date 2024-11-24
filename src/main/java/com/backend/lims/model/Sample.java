package com.backend.lims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "fkRequestId", referencedColumnName = "requestId")
    @JsonIgnore
    private Request request;

    public Sample() {
    }

    public Sample(Long sampleId, String sampleTypeDescription) {
        this.sampleId = sampleId;
        this.sampleTypeDescription = sampleTypeDescription;
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
}