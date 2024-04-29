package ru.kotov.autotests;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Student {
    private final String name;
    private int[] grades;


    public Student(String newName, int[] grades) {
        checkName(newName);
        checkGrades(grades);
        this.name = newName;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return name+":["+ Arrays.stream(grades).mapToObj(String::valueOf).collect(Collectors.joining(",")) +"]";
    }

    public Student(String name) {
        this.name = name;
        this.grades = new int[]{};
    }
    private void checkName(String newName) {
        if (newName.length() == 0) {
            throw new IllegalArgumentException("Для создания нового объекта поле имя не должно быть пустым");
        }
        String alphabet="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Arrays.stream(newName.split("")).forEach(value -> {
            if(!alphabet.contains(value)){
                throw new IllegalArgumentException("Имя должно состоять только из латинских букв");
            }
        });
    }
    private void checkGrades(int[] gradesForChecking) {
        Arrays.stream(gradesForChecking).forEach(value -> {
            if (value < 2 || value > 5) {
                throw new IllegalArgumentException("Оценки могут быть только от 2 до 5");
            }
        });
    }
    public void addGrade(int grade){
        int[] newGrades = new int[grades.length + 1];
        for (int i = 0; i < grades.length; i++) {
            newGrades[i] = grades[i];
        }
        newGrades[grades.length]=grade;
        checkGrades(newGrades);
        this.grades=newGrades;
    }
    public int[] getGrades() {
        int[] ints = grades.clone();
        return ints;
    }
}
