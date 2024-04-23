package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int rightLogFileName=0;
        while (true) {
            log.info("Введите путь к файлу с логами");
            String path = new Scanner(System.in).nextLine();
            rightLogFileName++;
            if (!checksPathToFileLog(path)) {
                log.warn("Указанный файл не существует или указанный путь является путём к папке, а не к файлу");
                continue;
            }
            log.info("Путь указан верно. Это файл номер {}",rightLogFileName);
        }

    }

    public static boolean checksPathToFileLog(String path) {
        File file = new File(path);
        boolean fileExists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (fileExists && !isDirectory) {
            return true;
        }
        return false;
    }
}