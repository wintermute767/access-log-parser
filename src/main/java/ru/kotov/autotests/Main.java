package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Main {

    //задание 1
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    //задание 2
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) return i;
        }
        return -1;
    }


    //задание 3
    public static int maxAbs(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxValue)) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    //задание 4
    public static int countPositive(int[] arr) {
        int positive = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive++;
            }
        }
        return positive;
    }

    public static void main(String[] args) {
        System.out.println("результат: " + palindrom(new int[]{1, -2, -7, 4, 2, 2, 5}));
        System.out.println("результат: " + palindrom(new int[]{1, -2, -7, 4, -7, -2, 1}));

    }

    //задание 5
    public static boolean palindrom(int[] arr) {
        Integer arrHalf= arr.length/2;
        for (int i = 0; i < arrHalf; i++) {
            if (arr[i] != arr[arr.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}
