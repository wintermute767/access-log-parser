package ru.kotov.autotests;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    StudentTest() {
    }
    @Test
    @DisplayName("Проверка невозможности изменить Оценки")
    void changeGrades() {
        Student student = new Student("Bob");
        student.addGrade(2);
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);
        List grades= student.getGrades();
        grades.add(6);
        assertEquals(new ArrayList(Arrays.asList(2, 3, 4, 5)), student.getGrades());
    }

    @Test
    @DisplayName("Проверка корректности смены имени")
    void setName() {
        Student student = new Student("Bob");
        student.setName("Andrey");
        Assertions.assertEquals("Andrey", student.getName());
    }

    @Test
    @DisplayName("Проверка получения имени")
    void getName() {
        Student student = new Student("Bob");
        Assertions.assertEquals("Bob", student.getName());
    }

    @Test
    @DisplayName("Проверка получения оценок")
    void getGrades() {
        Student student = new Student("Bob");
        student.addGrade(2);
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);
        Assertions.assertEquals(new ArrayList(Arrays.asList(2, 3, 4, 5)), student.getGrades());
    }

    @RepeatedTest(
            value = 4,
            name = "Добавление корректной оценки"
    )
    void addGrade(RepetitionInfo repetitionInfo) {
        Student stud = new Student("Bob");
        stud.addGrade(repetitionInfo.getCurrentRepetition() + 1);
        Assertions.assertEquals(stud.getGrades().get(0), repetitionInfo.getCurrentRepetition() + 1);
    }
    @RepeatedTest(
            value = 4,
            name = "Добавление не корректной оценки больше 5"
    )
    void addWrongGrade1(RepetitionInfo repetitionInfo) {
        Student stud = new Student("Bob");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> stud.addGrade(repetitionInfo.getCurrentRepetition() + 5));
        assertEquals(repetitionInfo.getCurrentRepetition() + 5+" is wrong grade", exception.getMessage());
    }
    @RepeatedTest(
            value = 4,
            name = "Добавление не корректной оценки меньше 2"
    )
    void addWrongGrade2(RepetitionInfo repetitionInfo) {
        Student stud = new Student("Bob");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> stud.addGrade(repetitionInfo.getCurrentRepetition() - 3));
        assertEquals(repetitionInfo.getCurrentRepetition() - 3+" is wrong grade", exception.getMessage());
    }
    @Test
    @DisplayName("Проверка получения HashCode")
    void testHashCode() {
        Student student = new Student("Bob");
        student.addGrade(2);
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);

        int testHash = 7;
        testHash = 13 * testHash + Objects.hashCode("Bob");
        testHash = 13 * testHash + Objects.hashCode(new ArrayList(Arrays.asList(2, 3, 4, 5)));
        assertEquals(testHash,student.hashCode());
    }

    @Test
    @DisplayName("Проверка получения Equals для одного и того же объекта")
    void testEquals1() {
        Student student = new Student("Bob");
        student.addGrade(2);
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);
        assertTrue(student.equals(student));
    }
    @Test
    @DisplayName("Проверка получения Equals для двух одинаковых объекта")
    void testEquals2() {
        Student student1 = new Student("Bob");
        student1.addGrade(2);
        student1.addGrade(3);
        student1.addGrade(4);
        student1.addGrade(5);

        Student student2 = new Student("Bob");
        student2.addGrade(2);
        student2.addGrade(3);
        student2.addGrade(4);
        student2.addGrade(5);
        assertTrue(student1.equals(student2));
    }
    @Test
    @DisplayName("Проверка получения Equals с объекта другого типа")
    void testEquals3() {
        Student student1 = new Student("Bob");
        student1.addGrade(2);
        student1.addGrade(3);
        student1.addGrade(4);
        student1.addGrade(5);

        String student2 = "Bob";
        assertFalse(student1.equals(student2));
    }
    @Test
    @DisplayName("Проверка получения Equals для объекта с null")
    void testEquals4() {
        Student student1 = new Student("Bob");
        student1.addGrade(2);
        student1.addGrade(3);
        student1.addGrade(4);
        student1.addGrade(5);

        Student student2 = null;
        assertFalse(student1.equals(student2));
    }
    @Test
    @DisplayName("Проверка получения Equals для двух разных объектов с полем Name")
    void testEquals5() {
        Student student1 = new Student("Bob");
        student1.addGrade(2);
        student1.addGrade(3);
        student1.addGrade(4);
        student1.addGrade(5);

        Student student2 = new Student("NotBob");
        student2.addGrade(2);
        student2.addGrade(3);
        student2.addGrade(4);
        student2.addGrade(5);
        assertFalse(student1.equals(student2));
    }
    @Test
    @DisplayName("Проверка получения Equals для двух разных объектов с полем Grades")
    void testEquals6() {
        Student student1 = new Student("Bob");
        student1.addGrade(2);
        student1.addGrade(3);
        student1.addGrade(4);
        student1.addGrade(5);

        Student student2 = new Student("Bob");
        student2.addGrade(2);
        student2.addGrade(3);
        student2.addGrade(4);
        student2.addGrade(4);
        assertFalse(student1.equals(student2));
    }
    @Test
    @DisplayName("Проверка получения ToString")
    void testToString() {
        Student student = new Student("Bob");
        student.addGrade(2);
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);
        assertEquals("Student{" + "name=Bob, marks=" + (new ArrayList(Arrays.asList(2, 3, 4, 5))).toString()+ '}',student.toString());
    }
}