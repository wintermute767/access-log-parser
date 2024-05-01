package ru.сourses.dishes;

public class Sauce {
    private String name;
    private LevelOfSharpness level;

    public Sauce(String name, LevelOfSharpness level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Соус " + name + ": " + level.getLevel();
    }
}
