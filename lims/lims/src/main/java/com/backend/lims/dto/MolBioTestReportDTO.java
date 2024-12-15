package com.backend.lims.dto;

import java.util.Map;

public class MolBioTestReportDTO {
    private Map<String, Long> dogCounts;
    private Map<String, Long> catCounts;
    private Map<String, Long> chickenCounts;
    private Map<String, Long> buffaloCounts;
    private Map<String, Long> cattleCounts;
    private Map<String, Long> horseCounts;
    private Map<String, Long> goatCounts;
    private Map<String, Long> sheepCounts;
    private Map<String, Long> swineCounts;

    public Map<String, Long> getDogCounts() {
        return dogCounts;
    }

    public void setDogCounts(Map<String, Long> dogCounts2) {
        this.dogCounts = dogCounts2;
    }

    public Map<String, Long> getCatCounts() {
        return catCounts;
    }

    public void setCatCounts(Map<String, Long> catCounts) {
        this.catCounts = catCounts;
    }

    public Map<String, Long> getChickenCounts() {
        return chickenCounts;
    }

    public void setChickenCounts(Map<String, Long> chickenCounts) {
        this.chickenCounts = chickenCounts;
    }

    public Map<String, Long> getBuffaloCounts() {
        return buffaloCounts;
    }

    public void setBuffaloCounts(Map<String, Long> buffaloCounts) {
        this.buffaloCounts = buffaloCounts;
    }

    public Map<String, Long> getCattleCounts() {
        return cattleCounts;
    }

    public void setCattleCounts(Map<String, Long> cattleCounts) {
        this.cattleCounts = cattleCounts;
    }

    public Map<String, Long> getHorseCounts() {
        return horseCounts;
    }

    public void setHorseCounts(Map<String, Long> horseCounts) {
        this.horseCounts = horseCounts;
    }

    public Map<String, Long> getGoatCounts() {
        return goatCounts;
    }

    public void setGoatCounts(Map<String, Long> goatCounts) {
        this.goatCounts = goatCounts;
    }

    public Map<String, Long> getSheepCounts() {
        return sheepCounts;
    }

    public void setSheepCounts(Map<String, Long> sheepCounts) {
        this.sheepCounts = sheepCounts;
    }

    public Map<String, Long> getSwineCounts() {
        return swineCounts;
    }

    public void setSwineCounts(Map<String, Long> swineCounts) {
        this.swineCounts = swineCounts;
    }
}
