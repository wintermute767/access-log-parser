package ru.сourses.dishes;

public enum LevelOfSharpness{
    VERY_HOT("очень острый"),
    HOT("острый"),
    NOT_HOT("не острый");
    private final String level;
    LevelOfSharpness(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
