package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.customExeption.CustomParcerLogException;
import ru.kotov.autotests.log.components.LogEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\AVKotov\\Downloads\\access.log";
        readLogFile(path);
//        int rightLogFileName = 0;
//        while (true) {
//            log.info("Введите путь к файлу с логами");
//            String path = new Scanner(System.in).nextLine();
//            rightLogFileName++;
//            if (!checksPathToFileLog(path)) {
//                log.warn("Указанный файл не существует или указанный путь является путём к папке, а не к файлу");
//                continue;
//            }
//            log.info("Путь указан верно. Это файл номер {}", rightLogFileName);
//            readLogFile(path);
//        }

    }

    public static void readLogFile(String path) {
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
        log.info("Прочитано строк в файле: {}\n", countSting);
        log.info(getBotStatistic(logEntries));

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


    public static String getBotStatistic(List<LogEntry> logEntries) {
        Map<String, Integer> botStatistic = new HashMap<>();
        int responseWithUserAgent = 0;
        for(LogEntry logEntry : logEntries){
            responseWithUserAgent++;
            if(logEntry.getUserAgent() != null){
                String botName = logEntry.getUserAgent().getBotName();
                botStatistic.computeIfAbsent(botName, integer -> 0);
                botStatistic.computeIfPresent(botName, (Sting, integer) -> integer + 1);

            }
        }
        return String.format("Количество запросов с User-agent: %d\n" +
                        "Количество запросов по ботам: %s",
                responseWithUserAgent, botStatistic.toString());
    }
}