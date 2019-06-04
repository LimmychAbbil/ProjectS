package net.lim.recipes.model;

public enum Difficulty {
    EASY,
    MODERATE,
    HARD;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
