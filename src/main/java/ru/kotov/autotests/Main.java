package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Andrew", new int[]{2, 3, 4, 5});
        System.out.println(student1);
        student1.addGrade(2);
        System.out.println(student1);
        student1.addGrade(3);
        System.out.println(student1);
        student1.addGrade(4);
        System.out.println(student1);
        student1.addGrade(5);
        System.out.println(student1);
        System.out.println("Попытаемся исправить первую двойку на 5, что делать нельзя");
        int[] studentGrace = student1.getGrades();
        studentGrace[0]=5;
        System.out.println(student1);

    }

}