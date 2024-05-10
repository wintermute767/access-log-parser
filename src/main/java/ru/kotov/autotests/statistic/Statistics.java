package ru.kotov.autotests.statistic;

import lombok.Getter;
import ru.kotov.autotests.log.components.LogEntry;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class Statistics {
    private long totalTraffic = 0;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private Map<String, Integer> botStatistic = new HashMap<>();
    private Map<String, Integer> operationSystemStatistic = new HashMap<>();
    private Map<String, Integer> browserStatistic = new HashMap<>();
    private int countLog = 0;
    private List<String> listOfBotsToDisplay = List.of("YandexBot/3.0", "Googlebot/2.1");

    public Statistics() {
    }

    public void addEntry(LogEntry logEntry) {
        countLog++;
        setMinAndMaxTime(logEntry);
        setTotalTraffic(logEntry);
        setBotStatistic(logEntry);
        setOperationSystemStatistic(logEntry);
        setBrowserStatistic(logEntry);
    }

    private void setTotalTraffic(LogEntry logEntry) {
        this.totalTraffic += logEntry.getByteResponse();
    }

    private void setMinAndMaxTime(LogEntry logEntry) {

        LocalDateTime localDateTime = logEntry.getDateAndTime().toLocalDateTime();
        if (minTime == null) {
            this.minTime = localDateTime;
        } else if (minTime.isBefore(localDateTime)) {
            this.minTime = localDateTime;
        }
        if (maxTime == null) {
            this.maxTime = localDateTime;
        } else if (maxTime.isAfter(localDateTime)) {
            this.maxTime = localDateTime;
        }

    }

    public long getTrafficRate() {
        if (minTime != null || maxTime != null || totalTraffic != 0) {
            Long hours = Long.valueOf(getHouseBetweenMinAndMaxTimeInStatistic());
            return totalTraffic / hours;
        }
        return 0;
    }

    public int getHouseBetweenMinAndMaxTimeInStatistic() {
        return Math.toIntExact(ChronoUnit.HOURS.between(maxTime,minTime));
    }

    public void setBotStatistic(LogEntry logEntry) {
        if (logEntry.getUserAgent() != null) {
            String botName = logEntry.getUserAgent().getBotName();
            this.botStatistic.computeIfAbsent(botName, integer -> 0);
            this.botStatistic.computeIfPresent(botName, (Sting, integer) -> integer + 1);
        }
    }
    public void setOperationSystemStatistic(LogEntry logEntry) {
        if (logEntry.getUserAgent() != null) {
            String operatingSystem = logEntry.getUserAgent().getOperatingSystem();
            this.operationSystemStatistic.computeIfAbsent(operatingSystem, integer -> 0);
            this.operationSystemStatistic.computeIfPresent(operatingSystem, (Sting, integer) -> integer + 1);
        }
    }
    public void setBrowserStatistic(LogEntry logEntry) {
        if (logEntry.getUserAgent() != null) {
            String browser = logEntry.getUserAgent().getBrowser();
            this.browserStatistic.computeIfAbsent(browser, integer -> 0);
            this.browserStatistic.computeIfPresent(browser, (Sting, integer) -> integer + 1);
        }
    }

    private static Double getPercent(int x, int y) {
        return ((double) x) / y * 100;
    }

    @Override
    public String toString() {
        if (countLog != 0) {
            String botStatisticString = botStatistic
                    .keySet()
                    .stream()
                    .filter(string -> listOfBotsToDisplay.contains(string))
                    .map(string -> {
                        int botRequests = botStatistic.get(string).intValue();
                        double ratio = getPercent(botRequests, countLog);
                        return String.format("%s количество запросов: %d, соотношение от общего количества запросов: %.3f%%",
                                string, botRequests, ratio);
                    }).collect(Collectors.joining("\n"));

            return String.format("Общее количество запросов: %d\n" +
                            "Статистика по ботам:\n%s\n" +
                            "Общее количество трафика: %d\n" +
                            "Самое ранне время в лог файле: %s\n" +
                            "Самое позднее время в лог файле: %s\n" +
                            "Количество часов между самое ранним и самым позднем временем: %d\n" +
                            "Среднее значение трафика за час: %d\n"+
                            "Статистика по операционным системам: %s\n"+
                            "Статистика по браузерам: %s\n",
                    countLog,
                    botStatisticString,
                    totalTraffic,
                    minTime.toString(),
                    maxTime.toString(),
                    getHouseBetweenMinAndMaxTimeInStatistic(),
                    getTrafficRate(),
                    operationSystemStatistic.toString(),
                    browserStatistic.toString());
        } else {
            return String.format("Общее количество запросов: 0");
        }
    }
}
