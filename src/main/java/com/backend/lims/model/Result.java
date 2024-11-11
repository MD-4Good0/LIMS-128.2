package com.backend.lims.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity
@Transactional
public class Result {
    // Map the details from the request ~> Done in frontend
    @Id
    private Long resultId;
    private Long requestId; // Make foreign key
    private Long testerId;
    private String testerUsername;

    @OneToMany(targetEntity = MicrobioTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<MicrobioTestResults> microbialTestResults;

    @OneToMany(targetEntity = ChemTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<ChemTestResults> chemTestResults;

    @OneToMany(targetEntity = MolBioTestResults.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private List<MolBioTestResults> molBioTestResults;

    public Result() {
    }

    public Result(Long resultId, Long requestId, Long testerId, String testerUsername, List<MicrobioTestResults> microbialTestResults, List<ChemTestResults> chemTestResults, List<MolBioTestResults> molBioTestResults) {
        super();
        this.resultId = resultId;
        this.requestId = requestId;
        this.testerId = testerId;
        this.testerUsername = testerUsername;
        this.microbialTestResults = microbialTestResults;
        this.chemTestResults = chemTestResults;
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

    public List<MicrobioTestResults> getMicrobioTestResults() {
        return microbialTestResults;
    }

    public void setMicrobioTestResults(List<MicrobioTestResults> microbialTestResults) {
        this.microbialTestResults = microbialTestResults;
    }

    public List<ChemTestResults> getChemTestResults() {
        return chemTestResults;
    }

    public void setChemTestResults(List<ChemTestResults> chemTestResults) {
        this.chemTestResults = chemTestResults;
    }

    public List<MolBioTestResults> getMolBioTestResults() {
        return molBioTestResults;
    }

    public void setMolBioTestResults(List<MolBioTestResults> molBioTestResults) {
        this.molBioTestResults = molBioTestResults;
    }
}
