package ru.kotov.autotests;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    StudentTest() {
    }
    @Test
    @DisplayName("Проверка добавления правильной оценки при checkGrade всегда true")
    void addGrades1() {
        Student student = new Student("Bob");
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        Mockito.when(repo.checkGrade(Mockito.anyInt())).thenReturn(true);
        student.setRepo(repo);
        student.addGrade(5);
        assertEquals(5, student.getGrades().get(0));
    }
    @Test
    @DisplayName("Проверка добавления не правильной оценки при checkGrade всегда true")
    void addGrades2() {
        Student student = new Student("Bob");
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        Mockito.when(repo.checkGrade(Mockito.anyInt())).thenReturn(true);
        student.setRepo(repo);
        student.addGrade(10);
        assertEquals(10, student.getGrades().get(0));
    }
    @Test
    @DisplayName("Проверка добавления правильной оценки при checkGrade всегда false")
    void addGrades3() {
        Student student = new Student("Bob");
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        Mockito.when(repo.checkGrade(Mockito.anyInt())).thenReturn(false);
        student.setRepo(repo);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> student.addGrade(5));
        assertEquals( 5 + " is wrong grade", exception.getMessage());
    }
    @Test
    @DisplayName("Проверка добавления не правильной оценки при checkGrade всегда false")
    void addGrades4() {
        Student student = new Student("Bob");
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        Mockito.when(repo.checkGrade(Mockito.anyInt())).thenReturn(false);
        student.setRepo(repo);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> student.addGrade(10));
        assertEquals( 10 + " is wrong grade", exception.getMessage());
    }
}