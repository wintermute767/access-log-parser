package ru.kotov.autotests.logerReader;

import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.customExeption.CustomParcerLogException;
import ru.kotov.autotests.log.components.LogEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ru.kotov.autotests.statistic.LogStatistic;

@Slf4j
public class LogReader {

    public static void readLogFile(String path) {
        log.info("Начинаю читать лог файл");
        int countSting = 0;
        List<LogEntry> logEntries = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader =
                    new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                countSting++;
                if (length > 1024) {
                    throw new CustomParcerLogException(String.format("Maximum line length of 1024 characters exceeded. String number %d, string lenght %d", countSting, length));
                }
                if (line != null) {
                    LogEntry logEntry = new LogEntry(line);
                    logEntries.add(logEntry);
                }
            }
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
        log.info("Прочитано строк в файле: {}", countSting);
        log.info(LogStatistic.getBotStatistic(logEntries, List.of("YandexBot/3.0", "Googlebot/2.1")));

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
