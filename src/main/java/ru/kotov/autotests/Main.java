package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 5);
        Fraction f3 = new Fraction(7, 8);
        System.out.println(f1.sum(f2).sum(f3).minus(5));
    }

}