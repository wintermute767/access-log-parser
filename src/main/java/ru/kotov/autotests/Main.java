package ru.kotov.autotests;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
        System.out.println(cat.toString());
        clearAllFieldsObject(cat);
        System.out.println(cat.toString());

        ClassForTest classForTest = new ClassForTest("value1", 2, new ArrayList<>(Arrays.asList("value3")), 44, 'a');
        System.out.println(classForTest.toString());
        clearAllFieldsObject(classForTest);
        System.out.println(classForTest.toString());
    }

    public static void clearAllFieldsObject(Object object) {
        Arrays.stream(object.getClass().getDeclaredFields()).forEach(field -> {
            if (!field.getType().isPrimitive()) {
                field.setAccessible(true);
                try {
                    field.set(object, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}