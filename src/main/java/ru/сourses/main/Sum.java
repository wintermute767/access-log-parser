package ru.сourses.main;

import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        double result = 0;

        for (String arg : args) {
            double argDouble;
            if (checkingArg(arg)) {
                argDouble = Double.parseDouble(arg);
            } else {
                argDouble = 0;
            }
            result += argDouble;
        }
        System.out.println("результат: " + result);
    }

    private static boolean checkingArg(String arg) {
        //проверим каждый аргумент
        //список символов после запятой
        String afterPointСorrectSymbols = "0123456789";
        //список символов до запятой
        String beforePointСorrectSymbols = afterPointСorrectSymbols + "-";
        //разделим на до и после запятой
        String[] argArray;
        if (arg.contains(".")) {
            argArray = arg.split("\\.");
        } else if (arg.contains(",")) {
            argArray = arg.split(",");
        } else argArray = new String[]{arg};

        if (argArray.length == 1) {
            //если запятой нет то проверим только один раз
            return checkingString(argArray[0], beforePointСorrectSymbols);
        } else if (argArray.length == 2) {
            //если запятая есть то проверим обе части
            return checkingString(argArray[0], beforePointСorrectSymbols) && checkingString(argArray[1], afterPointСorrectSymbols);
        } else
            //если 2 и более запятых то сразу false
            return false;
    }

    private static boolean checkingString(String stingForChecking, String stringWithСorrectSymbols) {
        return Arrays.stream(stingForChecking.split(""))
                .filter(s -> !stringWithСorrectSymbols.contains(s))
                .findFirst()
                .isEmpty();
    }
}
