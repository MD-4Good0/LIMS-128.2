package com.backend.lims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;
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

    // LocalDateTime fields for analysis dates of animals
    private LocalDateTime dogAnalysisDate;
    private LocalDateTime catAnalysisDate;
    private LocalDateTime chickenAnalysisDate;
    private LocalDateTime buffaloAnalysisDate;
    private LocalDateTime cattleAnalysisDate;
    private LocalDateTime horseAnalysisDate;
    private LocalDateTime goatAnalysisDate;
    private LocalDateTime sheepAnalysisDate;
    private LocalDateTime swineAnalysisDate;
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    @JsonIgnore
    private Result result;

    public MolBioTestResults() {
    }

    public MolBioTestResults(Long molBioResultId, Long sampleId, String dog, String cat, String chicken, String buffalo, String cattle, String horse, String goat, String sheep, String swine, LocalDateTime dogAnalysisDate, LocalDateTime catAnalysisDate, LocalDateTime chickenAnalysisDate, LocalDateTime buffaloAnalysisDate, LocalDateTime cattleAnalysisDate, LocalDateTime horseAnalysisDate, LocalDateTime goatAnalysisDate, LocalDateTime sheepAnalysisDate, LocalDateTime swineAnalysisDate, Result result) {
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

    public LocalDateTime getDogAnalysisDate() {
        return dogAnalysisDate;
    }

    public void setDogAnalysisDate(LocalDateTime dogAnalysisDate) {
        this.dogAnalysisDate = dogAnalysisDate;
    }

    public LocalDateTime getCatAnalysisDate() {
        return catAnalysisDate;
    }

    public void setCatAnalysisDate(LocalDateTime catAnalysisDate) {
        this.catAnalysisDate = catAnalysisDate;
    }

    public LocalDateTime getChickenAnalysisDate() {
        return chickenAnalysisDate;
    }

    public void setChickenAnalysisDate(LocalDateTime chickenAnalysisDate) {
        this.chickenAnalysisDate = chickenAnalysisDate;
    }

    public LocalDateTime getBuffaloAnalysisDate() {
        return buffaloAnalysisDate;
    }

    public void setBuffaloAnalysisDate(LocalDateTime buffaloAnalysisDate) {
        this.buffaloAnalysisDate = buffaloAnalysisDate;
    }

    public LocalDateTime getCattleAnalysisDate() {
        return cattleAnalysisDate;
    }

    public void setCattleAnalysisDate(LocalDateTime cattleAnalysisDate) {
        this.cattleAnalysisDate = cattleAnalysisDate;
    }

    public LocalDateTime getHorseAnalysisDate() {
        return horseAnalysisDate;
    }

    public void setHorseAnalysisDate(LocalDateTime horseAnalysisDate) {
        this.horseAnalysisDate = horseAnalysisDate;
    }

    public LocalDateTime getGoatAnalysisDate() {
        return goatAnalysisDate;
    }

    public void setGoatAnalysisDate(LocalDateTime goatAnalysisDate) {
        this.goatAnalysisDate = goatAnalysisDate;
    }

    public LocalDateTime getSheepAnalysisDate() {
        return sheepAnalysisDate;
    }

    public void setSheepAnalysisDate(LocalDateTime sheepAnalysisDate) {
        this.sheepAnalysisDate = sheepAnalysisDate;
    }

    public LocalDateTime getSwineAnalysisDate() {
        return swineAnalysisDate;
    }

    public void setSwineAnalysisDate(LocalDateTime swineAnalysisDate) {
        this.swineAnalysisDate = swineAnalysisDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
