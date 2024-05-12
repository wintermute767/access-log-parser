package ru.kotov.autotests;

public interface StudentRepository {
    int getRaintingForGradeSum(int sum);
    boolean checkGrade(int grade);
}
