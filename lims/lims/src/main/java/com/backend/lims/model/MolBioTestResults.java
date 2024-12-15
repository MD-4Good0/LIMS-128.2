package com.backend.lims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Transactional
public class MolBioTestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long molBioResultId;
    private Long sampleId;
    private String dog;
    private String cat;
    private String chicken;
    private String buffalo;
    private String cattle;
    private String horse;
    private String goat;
    private String sheep;
    private String swine;
    
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;

    // LocalDateTime fields for analysis dates of animals
    private LocalDate dogAnalysisDate;
    private LocalDate catAnalysisDate;
    private LocalDate chickenAnalysisDate;
    private LocalDate buffaloAnalysisDate;
    private LocalDate cattleAnalysisDate;
    private LocalDate horseAnalysisDate;
    private LocalDate goatAnalysisDate;
    private LocalDate sheepAnalysisDate;
    private LocalDate swineAnalysisDate;
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    @JsonIgnore
    private Result result;

    public MolBioTestResults() {
    }

    public MolBioTestResults(Long molBioResultId, Long sampleId, String dog, String cat, String chicken, String buffalo, String cattle, String horse, String goat, String sheep, String swine, LocalDate dogAnalysisDate, LocalDate catAnalysisDate, LocalDate chickenAnalysisDate, LocalDate buffaloAnalysisDate, LocalDate cattleAnalysisDate, LocalDate horseAnalysisDate, LocalDate goatAnalysisDate, LocalDate sheepAnalysisDate, LocalDate swineAnalysisDate, Result result) {
        this.molBioResultId = molBioResultId;
        this.sampleId = sampleId;
        this.dog = dog;
        this.cat = cat;
        this.chicken = chicken;
        this.buffalo = buffalo;
        this.cattle = cattle;
        this.horse = horse;
        this.goat = goat;
        this.sheep = sheep;
        this.swine = swine;
        this.dogAnalysisDate = dogAnalysisDate;
        this.catAnalysisDate = catAnalysisDate;
        this.chickenAnalysisDate = chickenAnalysisDate;
        this.buffaloAnalysisDate = buffaloAnalysisDate;
        this.cattleAnalysisDate = cattleAnalysisDate;
        this.horseAnalysisDate = horseAnalysisDate;
        this.goatAnalysisDate = goatAnalysisDate;
        this.sheepAnalysisDate = sheepAnalysisDate;
        this.swineAnalysisDate = swineAnalysisDate;
        this.result = result;
    }
    

    public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Long getMolBioResultId() {
        return molBioResultId;
    }

    public void setMolBioResultId(Long molBioResultId) {
        this.molBioResultId = molBioResultId;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    public String getBuffalo() {
        return buffalo;
    }

    public void setBuffalo(String buffalo) {
        this.buffalo = buffalo;
    }

    public String getCattle() {
        return cattle;
    }

    public void setCattle(String cattle) {
        this.cattle = cattle;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public String getGoat() {
        return goat;
    }

    public void setGoat(String goat) {
        this.goat = goat;
    }

    public String getSheep() {
        return sheep;
    }

    public void setSheep(String sheep) {
        this.sheep = sheep;
    }

    public String getSwine() {
        return swine;
    }

    public void setSwine(String swine) {
        this.swine = swine;
    }

    public LocalDate getDogAnalysisDate() {
        return dogAnalysisDate;
    }

    public void setDogAnalysisDate(LocalDate dogAnalysisDate) {
        this.dogAnalysisDate = dogAnalysisDate;
    }

    public LocalDate getCatAnalysisDate() {
        return catAnalysisDate;
    }

    public void setCatAnalysisDate(LocalDate catAnalysisDate) {
        this.catAnalysisDate = catAnalysisDate;
    }

    public LocalDate getChickenAnalysisDate() {
        return chickenAnalysisDate;
    }

    public void setChickenAnalysisDate(LocalDate chickenAnalysisDate) {
        this.chickenAnalysisDate = chickenAnalysisDate;
    }

    public LocalDate getBuffaloAnalysisDate() {
        return buffaloAnalysisDate;
    }

    public void setBuffaloAnalysisDate(LocalDate buffaloAnalysisDate) {
        this.buffaloAnalysisDate = buffaloAnalysisDate;
    }

    public LocalDate getCattleAnalysisDate() {
        return cattleAnalysisDate;
    }

    public void setCattleAnalysisDate(LocalDate cattleAnalysisDate) {
        this.cattleAnalysisDate = cattleAnalysisDate;
    }

    public LocalDate getHorseAnalysisDate() {
        return horseAnalysisDate;
    }

    public void setHorseAnalysisDate(LocalDate horseAnalysisDate) {
        this.horseAnalysisDate = horseAnalysisDate;
    }

    public LocalDate getGoatAnalysisDate() {
        return goatAnalysisDate;
    }

    public void setGoatAnalysisDate(LocalDate goatAnalysisDate) {
        this.goatAnalysisDate = goatAnalysisDate;
    }

    public LocalDate getSheepAnalysisDate() {
        return sheepAnalysisDate;
    }

    public void setSheepAnalysisDate(LocalDate sheepAnalysisDate) {
        this.sheepAnalysisDate = sheepAnalysisDate;
    }

    public LocalDate getSwineAnalysisDate() {
        return swineAnalysisDate;
    }

    public void setSwineAnalysisDate(LocalDate swineAnalysisDate) {
        this.swineAnalysisDate = swineAnalysisDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
