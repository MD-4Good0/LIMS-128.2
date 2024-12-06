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

    private Map<String, Long> dogCountsByMonthAndYear;
    private Map<String, Long> catCountsByMonthAndYear;
    private Map<String, Long> chickenCountsByMonthAndYear;
    private Map<String, Long> buffaloCountsByMonthAndYear;
    private Map<String, Long> cattleCountsByMonthAndYear;
    private Map<String, Long> horseCountsByMonthAndYear;
    private Map<String, Long> goatCountsByMonthAndYear;
    private Map<String, Long> sheepCountsByMonthAndYear;
    private Map<String, Long> swineCountsByMonthAndYear;

    private Map<String, Map<String, Integer>> dogPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> catPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> chickenPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> buffaloPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> cattlePosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> horsePosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> goatPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> sheepPosNegCountsByMonthAndYear;
    private Map<String, Map<String, Integer>> swinePosNegCountsByMonthAndYear;

    public Map<String, Map<String, Integer>> getDogPosNegCountsByMonthAndYear() {
        return dogPosNegCountsByMonthAndYear;
    }

    public void setDogPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> dogPosNegCountsByMonthAndYear) {
        this.dogPosNegCountsByMonthAndYear = dogPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getCatPosNegCountsByMonthAndYear() {
        return catPosNegCountsByMonthAndYear;
    }

    public void setCatPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> catPosNegCountsByMonthAndYear) {
        this.catPosNegCountsByMonthAndYear = catPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getSwinePosNegCountsByMonthAndYear() {
        return swinePosNegCountsByMonthAndYear;
    }

    public void setSwinePosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> swinePosNegCountsByMonthAndYear) {
        this.swinePosNegCountsByMonthAndYear = swinePosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getSheepPosNegCountsByMonthAndYear() {
        return sheepPosNegCountsByMonthAndYear;
    }

    public void setSheepPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> sheepPosNegCountsByMonthAndYear) {
        this.sheepPosNegCountsByMonthAndYear = sheepPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getGoatPosNegCountsByMonthAndYear() {
        return goatPosNegCountsByMonthAndYear;
    }

    public void setGoatPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> goatPosNegCountsByMonthAndYear) {
        this.goatPosNegCountsByMonthAndYear = goatPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getHorsePosNegCountsByMonthAndYear() {
        return horsePosNegCountsByMonthAndYear;
    }

    public void setHorsePosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> horsePosNegCountsByMonthAndYear) {
        this.horsePosNegCountsByMonthAndYear = horsePosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getCattlePosNegCountsByMonthAndYear() {
        return cattlePosNegCountsByMonthAndYear;
    }

    public void setCattlePosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> cattlePosNegCountsByMonthAndYear) {
        this.cattlePosNegCountsByMonthAndYear = cattlePosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getBuffaloPosNegCountsByMonthAndYear() {
        return buffaloPosNegCountsByMonthAndYear;
    }

    public void setBuffaloPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> buffaloPosNegCountsByMonthAndYear) {
        this.buffaloPosNegCountsByMonthAndYear = buffaloPosNegCountsByMonthAndYear;
    }

    public Map<String, Map<String, Integer>> getChickenPosNegCountsByMonthAndYear() {
        return chickenPosNegCountsByMonthAndYear;
    }

    public void setChickenPosNegCountsByMonthAndYear(Map<String, Map<String, Integer>> chickenPosNegCountsByMonthAndYear) {
        this.chickenPosNegCountsByMonthAndYear = chickenPosNegCountsByMonthAndYear;
    }

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

    public Map<String, Long> getDogCountsByMonthAndYear() {
        return dogCountsByMonthAndYear;
    }

    public void setDogCountsByMonthAndYear(Map<String, Long> dogCountsByMonthAndYear) {
        this.dogCountsByMonthAndYear = dogCountsByMonthAndYear;
    }

    public Map<String, Long> getCatCountsByMonthAndYear() {
        return catCountsByMonthAndYear;
    }

    public void setCatCountsByMonthAndYear(Map<String, Long> catCountsByMonthAndYear) {
        this.catCountsByMonthAndYear = catCountsByMonthAndYear;
    }

    public Map<String, Long> getChickenCountsByMonthAndYear() {
        return chickenCountsByMonthAndYear;
    }

    public void setChickenCountsByMonthAndYear(Map<String, Long> chickenCountsByMonthAndYear) {
        this.chickenCountsByMonthAndYear = chickenCountsByMonthAndYear;
    }

    public Map<String, Long> getBuffaloCountsByMonthAndYear() {
        return buffaloCountsByMonthAndYear;
    }

    public void setBuffaloCountsByMonthAndYear(Map<String, Long> buffaloCountsByMonthAndYear) {
        this.buffaloCountsByMonthAndYear = buffaloCountsByMonthAndYear;
    }

    public Map<String, Long> getCattleCountsByMonthAndYear() {
        return cattleCountsByMonthAndYear;
    }

    public void setCattleCountsByMonthAndYear(Map<String, Long> cattleCountsByMonthAndYear) {
        this.cattleCountsByMonthAndYear = cattleCountsByMonthAndYear;
    }

    public Map<String, Long> getHorseCountsByMonthAndYear() {
        return horseCountsByMonthAndYear;
    }

    public void setHorseCountsByMonthAndYear(Map<String, Long> horseCountsByMonthAndYear) {
        this.horseCountsByMonthAndYear = horseCountsByMonthAndYear;
    }

    public Map<String, Long> getGoatCountsByMonthAndYear() {
        return goatCountsByMonthAndYear;
    }

    public void setGoatCountsByMonthAndYear(Map<String, Long> goatCountsByMonthAndYear) {
        this.goatCountsByMonthAndYear = goatCountsByMonthAndYear;
    }

    public Map<String, Long> getSheepCountsByMonthAndYear() {
        return sheepCountsByMonthAndYear;
    }

    public void setSheepCountsByMonthAndYear(Map<String, Long> sheepCountsByMonthAndYear) {
        this.sheepCountsByMonthAndYear = sheepCountsByMonthAndYear;
    }

    public Map<String, Long> getSwineCountsByMonthAndYear() {
        return swineCountsByMonthAndYear;
    }

    public void setSwineCountsByMonthAndYear(Map<String, Long> swineCountsByMonthAndYear) {
        this.swineCountsByMonthAndYear = swineCountsByMonthAndYear;
    }
}
