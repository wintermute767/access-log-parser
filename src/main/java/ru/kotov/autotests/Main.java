package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.customExeption.CustomParcerLogException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int rightLogFileName = 0;
        while (true) {
            log.info("Введите путь к файлу с логами");
            String path = new Scanner(System.in).nextLine();
            rightLogFileName++;
            if (!checksPathToFileLog(path)) {
                log.warn("Указанный файл не существует или указанный путь является путём к папке, а не к файлу");
                continue;
            }
            log.info("Путь указан верно. Это файл номер {}", rightLogFileName);
            readLogFile(path);
        }

    }

    public static void readLogFile(String path) {
        int countSting = 0;
        int maxSting = 0;
        int minString = 0;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader =
                    new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                countSting++;
                if (length > 1024) {
                    throw new CustomParcerLogException(String.format("Maximum line length of 1024 characters exceeded. String number %d, string lenght %d",countSting, length));
                }
                if (length > maxSting) {
                    maxSting = length;
                }
                if (length < minString || minString==0 ) {
                    minString = length;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("Прочитано строк в файле: {}, самая длинная строка: {}, самая короткая строка: {}", countSting, maxSting, minString);
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