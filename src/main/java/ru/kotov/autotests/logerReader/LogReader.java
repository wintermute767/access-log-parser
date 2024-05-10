package ru.kotov.autotests.logerReader;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.customExeption.CustomParcerLogException;
import ru.kotov.autotests.log.components.LogEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ru.kotov.autotests.statistic.Statistics;

@Slf4j
@Getter
public class LogReader {
    private List<LogEntry> logEntries = new ArrayList<>();
    private Statistics logStatistic = new Statistics();

    public LogReader() {
    }

    public void readLogFile(String path) {
        log.info("Начинаю читать лог файл. Ждите!");
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();

                if (length > 1024) {
                    throw new CustomParcerLogException(String.format(
                            "Максимальная длина строки превышает 1024 символа. " +
                                    "Строка номер %d, длина строки %d\n" +
                                    "Строка с ошибкой %s",
                            logStatistic.getCountLog() + 1, length, line));
                }
                if (line != null) {
                    try{
                        LogEntry logEntry = new LogEntry(line);
                        this.logEntries.add(logEntry);
                        this.logStatistic.addEntry(logEntry);
                    }catch (CustomParcerLogException e){
                        log.error("Чтение строки закончилось с ошибкой: {}",e.getMessage());
                    }

                }
            }
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
        log.info("Файл лога обработан");
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
