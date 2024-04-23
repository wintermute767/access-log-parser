package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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


    //задание 5
    public static boolean palindrom(int[] arr) {
        Integer arrHalf = arr.length / 2;
        for (int i = 0; i < arrHalf; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //задание 6
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("arr=" + Arrays.toString(arr));
    }

    //задание 7
    public static int[] reverseBack(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr.clone();
    }

    //задание 8
    public static int[] concat(int[] arr1, int[] arr2) {
        int aLen = arr1.length;
        int bLen = arr2.length;
        int[] result = new int[aLen + bLen];

        System.arraycopy(arr1, 0, result, 0, aLen);
        System.arraycopy(arr2, 0, result, aLen, bLen);
        return result;
    }

    //задание 9
    public static int[] findAll(int[] arr, int x) {
        List<Integer> indexesList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indexesList.add(i);
            }
        }
        int[] findIndex = new int[indexesList.size()];

        for (int i = 0; i < indexesList.size(); i++) {
            findIndex[i] = indexesList.get(i);
        }
        return findIndex;
    }

    //задание 10
    public static int[] deleteNegative(int[] arr) {
        List<Integer> positiveList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveList.add(arr[i]);
            }
        }
        int[] positiveIndex = new int[positiveList.size()];

        for (int i = 0; i < positiveList.size(); i++) {
            positiveIndex[i] = positiveList.get(i);
        }
        return positiveIndex;
    }


    //задание 11
    public static int[] add(int[] arr, int x, int pos) {
        if (pos <= arr.length - 1) {
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (i == pos) {
                    resultList.add(x);
                }
                resultList.add(arr[i]);
            }
            int[] resultArray = new int[resultList.size()];

            for (int i = 0; i < resultList.size(); i++) {
                resultArray[i] = resultList.get(i);
            }
            return resultArray;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("результат: " + Arrays.toString(add(new int[]{1, 2, 3, 4, 5}, new int[]{7, 8, 9}, 3)));
    }

    //задание 12
    public static int[] add(int[] arr, int[] ins, int pos) {
        if (pos <= arr.length - 1) {
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (i == pos) {
                    for (int k = 0; k < ins.length; k++) {
                        resultList.add(ins[k]);
                    }
                }
                resultList.add(arr[i]);
            }
            int[] resultArray = new int[resultList.size()];

            for (int i = 0; i < resultList.size(); i++) {
                resultArray[i] = resultList.get(i);
            }
            return resultArray;
        } else {
            return null;
        }
    }
}
