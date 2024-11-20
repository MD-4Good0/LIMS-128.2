package com.backend.lims.dto;

public class MolBioTestDTO {
    private String dog;
    private String cat;
    private String chicken;
    private String buffalo;
    private String cattle;
    private String horse;
    private String goat;
    private String sheep;
    private String swine;

    public MolBioTestDTO() {
    }

    public MolBioTestDTO(String dog, String cat, String chicken, String buffalo, String cattle, String horse, String goat, String sheep, String swine) {
        this.dog = dog;
        this.cat = cat;
        this.chicken = chicken;
        this.buffalo = buffalo;
        this.cattle = cattle;
        this.horse = horse;
        this.goat = goat;
        this.sheep = sheep;
        this.swine = swine;
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
}