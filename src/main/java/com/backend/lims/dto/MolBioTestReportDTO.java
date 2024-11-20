package com.backend.lims.dto;

import java.util.Map;

public class MolBioTestReportDTO {
    private Map<Object, Long> dogCounts;
    private Map<Object, Long> catCounts;
    private Map<Object, Long> chickenCounts;
    private Map<Object, Long> buffaloCounts;
    private Map<Object, Long> cattleCounts;
    private Map<Object, Long> horseCounts;
    private Map<Object, Long> goatCounts;
    private Map<Object, Long> sheepCounts;
    private Map<Object, Long> swineCounts;

    public Map<Object, Long> getDogCounts() {
        return dogCounts;
    }

    public void setDogCounts(Map<Object, Long> dogCounts) {
        this.dogCounts = dogCounts;
    }

    public Map<Object, Long> getCatCounts() {
        return catCounts;
    }

    public void setCatCounts(Map<Object, Long> catCounts) {
        this.catCounts = catCounts;
    }

    public Map<Object, Long> getChickenCounts() {
        return chickenCounts;
    }

    public void setChickenCounts(Map<Object, Long> chickenCounts) {
        this.chickenCounts = chickenCounts;
    }

    public Map<Object, Long> getBuffaloCounts() {
        return buffaloCounts;
    }

    public void setBuffaloCounts(Map<Object, Long> buffaloCounts) {
        this.buffaloCounts = buffaloCounts;
    }

    public Map<Object, Long> getCattleCounts() {
        return cattleCounts;
    }

    public void setCattleCounts(Map<Object, Long> cattleCounts) {
        this.cattleCounts = cattleCounts;
    }

    public Map<Object, Long> getHorseCounts() {
        return horseCounts;
    }

    public void setHorseCounts(Map<Object, Long> horseCounts) {
        this.horseCounts = horseCounts;
    }

    public Map<Object, Long> getGoatCounts() {
        return goatCounts;
    }

    public void setGoatCounts(Map<Object, Long> goatCounts) {
        this.goatCounts = goatCounts;
    }

    public Map<Object, Long> getSheepCounts() {
        return sheepCounts;
    }

    public void setSheepCounts(Map<Object, Long> sheepCounts) {
        this.sheepCounts = sheepCounts;
    }

    public Map<Object, Long> getSwineCounts() {
        return swineCounts;
    }

    public void setSwineCounts(Map<Object, Long> swineCounts) {
        this.swineCounts = swineCounts;
    }
}
