package com.backend.lims.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity
@Transactional
public class Result {
    // Map the details from the request ~> Done in frontend
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_seq")
    @SequenceGenerator(name = "result_seq", sequenceName = "result_seq", allocationSize = 1)
    private Long resultId;
    private Long requestId; // Make foreign key
    private Long testerId;
    private String testerUsername;

    // Check result
    private Boolean completeRequest;
    private Boolean completeChemElisa;
    private Boolean completeChemMicrobial;
    private Boolean completeMolBio;
    private Boolean completeMicrobio;

    @OneToMany(targetEntity = MicrobioTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<MicrobioTestResults> microbioTestResults;

    @OneToMany(targetEntity = ChemMicrobialTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<ChemMicrobialTestResults> chemMicrobialTestResults;

    @OneToMany(targetEntity = ChemElisaTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<ChemElisaTestResults> chemElisaTestResults;

    @OneToMany(targetEntity = MolBioTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<MolBioTestResults> molBioTestResults;

    public Result() {
    }

    public Result(Long resultId, Long requestId, Long testerId, String testerUsername, Boolean completeRequest, Boolean completeChemElisa, Boolean completeChemMicrobial, Boolean completeMolBio, Boolean completeMicrobio, List<MicrobioTestResults> microbioTestResults, List<ChemMicrobialTestResults> chemMicrobialTestResults, List<ChemElisaTestResults> chemElisaTestResults, List<MolBioTestResults> molBioTestResults) {
        this.resultId = resultId;
        this.requestId = requestId;
        this.testerId = testerId;
        this.testerUsername = testerUsername;
        this.completeRequest = completeRequest;
        this.completeChemElisa = completeChemElisa;
        this.completeChemMicrobial = completeChemMicrobial;
        this.completeMolBio = completeMolBio;
        this.completeMicrobio = completeMicrobio;
        this.microbioTestResults = microbioTestResults;
        this.chemMicrobialTestResults = chemMicrobialTestResults;
        this.chemElisaTestResults = chemElisaTestResults;
        this.molBioTestResults = molBioTestResults;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getTesterId() {
        return testerId;
    }

    public void setTesterId(Long testerId) {
        this.testerId = testerId;
    }

    public String getTesterUsername() {
        return testerUsername;
    }

    public void setTesterUsername(String testerUsername) {
        this.testerUsername = testerUsername;
    }

    public Boolean getCompleteRequest() {
        return completeRequest;
    }

    public void setCompleteRequest(Boolean completeRequest) {
        this.completeRequest = completeRequest;
    }

    public Boolean getCompleteChemElisa() {
        return completeChemElisa;
    }

    public void setCompleteChemElisa(Boolean completeChemElisa) {
        this.completeChemElisa = completeChemElisa;
    }

    public Boolean getCompleteChemMicrobial() {
        return completeChemMicrobial;
    }

    public void setCompleteChemMicrobial(Boolean completeChemMicrobial) {
        this.completeChemMicrobial = completeChemMicrobial;
    }

    public Boolean getCompleteMolBio() {
        return completeMolBio;
    }

    public void setCompleteMolBio(Boolean completeMolBio) {
        this.completeMolBio = completeMolBio;
    }

    public Boolean getCompleteMicrobio() {
        return completeMicrobio;
    }

    public void setCompleteMicrobio(Boolean completeMicrobio) {
        this.completeMicrobio = completeMicrobio;
    }

    public List<MicrobioTestResults> getMicrobioTestResults() {
        return microbioTestResults;
    }

    public void setMicrobioTestResults(List<MicrobioTestResults> microbioTestResults) {
        this.microbioTestResults = microbioTestResults;
    }

    public List<ChemMicrobialTestResults> getChemMicrobialTestResults() {
        return chemMicrobialTestResults;
    }

    public void setChemMicrobialTestResults(List<ChemMicrobialTestResults> chemMicrobialTestResults) {
        this.chemMicrobialTestResults = chemMicrobialTestResults;
    }

    public List<ChemElisaTestResults> getChemElisaTestResults() {
        return chemElisaTestResults;
    }

    public void setChemElisaTestResults(List<ChemElisaTestResults> chemElisaTestResults) {
        this.chemElisaTestResults = chemElisaTestResults;
    }

    public List<MolBioTestResults> getMolBioTestResults() {
        return molBioTestResults;
    }

    public void setMolBioTestResults(List<MolBioTestResults> molBioTestResults) {
        this.molBioTestResults = molBioTestResults;
    }
}