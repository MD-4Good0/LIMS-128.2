package com.backend.lims.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

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
    @ManyToOne
    @JoinColumn(name = "fkResultId", referencedColumnName = "resultId")
    private Result result;

    public MolBioTestResults() {
    }

    public MolBioTestResults(Long molBioResultId, Long sampleId, String dog, String cat, String chicken, String buffalo, String cattle, String horse, String goat, String sheep, String swine, Result result) {
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
