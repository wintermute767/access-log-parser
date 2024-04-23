package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        System.out.println("результат: " + findLast(new int[]{1, 2, 3, 4, 2, 2, 5}, 2));

    }

    //задание 1
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    //задание 2
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == x) return i;
        }
        return -1;
    }
}