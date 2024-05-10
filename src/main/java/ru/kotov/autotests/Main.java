package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.logerReader.LogReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.kotov.autotests.logerReader.LogReader.checksPathToFileLog;


@Slf4j
public class Main {
    public static void main(String[] args) {
        ArrayList<String> listForTest = new ArrayList<>(Arrays.asList("Порядок", "слов", "в", "строке", "должен", "быть", "равен", "порядку", "слов", "в", "потоке."));
        Stream<String> streamForTest = listForTest.stream();
        System.out.println("Слова в стриме: " + listForTest);
        System.out.println("Слова после обработки: " + getStringFromStream(streamForTest));

    }

    public static String getStringFromStream(Stream<String> stringStream) {
        return stringStream.collect(Collectors.joining(" "));
    }

    public static void reverse(ArrayList<Integer> intList) {
        int n = intList.size() - 1;
        for (int i = 0; i < intList.size() / 2; i++) {
            int temp = intList.get(i);
            intList.set(i, intList.get(n - i));
            intList.set(n - i, temp);
        }
    }

    public static void reverse(int[] intArray) {
        int n = intArray.length - 1;
        for (int i = 0; i < intArray.length / 2; i++) {
            int temp = intArray[i];
            intArray[i] = intArray[n - i];
            intArray[n - i] = temp;
        }
    }


    public static void bubbleSort(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(ArrayList<Integer> intList) {
        for (int i = 0; i < intList.size() - 1; i++) {
            for (int j = 0; j < intList.size() - i - 1; j++) {
                if (intList.get(j) > intList.get(j + 1)) {
                    int temp = intList.get(j);
                    intList.set(j, intList.get(j + 1));
                    intList.set(j + 1, temp);
                }
            }
        }
    }

    public static List<Integer> newListWithSetSize(int size) {
        List<Integer> simpleList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            simpleList.add(i);
        }
        return simpleList;
    }

    public static void pairwisePermutation(List<Integer> listForPermutation) {
        int firstElement = listForPermutation.getFirst();
        int sizeList = listForPermutation.size();
        listForPermutation.removeFirst();
        listForPermutation.add(firstElement);
    }
}