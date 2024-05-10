package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.logerReader.LogReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ru.kotov.autotests.logerReader.LogReader.checksPathToFileLog;


@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> simpleList = newListWithSetSize(12);
        System.out.println("До перестановки: ");
        simpleList.forEach(integer -> System.out.print(integer+" "));
        pairwisePermutation(simpleList);
        System.out.println("\nПосле перестановки: ");
        simpleList.forEach(integer -> System.out.print(integer+" "));
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