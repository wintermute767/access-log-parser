package ru.kotov.autotests.statistic;

import lombok.Getter;
import ru.kotov.autotests.log.components.LogEntry;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
    private HashSet<String> uniquePage = new HashSet<>();
    private HashSet<String> uniquePageNotExist = new HashSet<>();
    private int countUserVisits = 0;
    private int countErrorRequest = 0;
    private HashSet<InetAddress> setUniqueIPAddressOnlyUser = new HashSet<>();
    private HashSet<InetAddress> setUniqueIPAddress = new HashSet<>();

    public Statistics() {
    }

    public void addEntry(LogEntry logEntry) {
        countLog++;
        setMinAndMaxTime(logEntry);
        setTotalTraffic(logEntry);
        setBotStatistic(logEntry);
        setOperationSystemStatistic(logEntry);
        setBrowserStatistic(logEntry);
        setUniquePage(logEntry);
        setUniquePageNotExist(logEntry);
        setCountUserVisits(logEntry);
        setCountCountErrorRequest(logEntry);
        setCountUniqueIPAddressOnlyUser(logEntry);
        setCountUniqueIPAddress(logEntry);
    }

    private int getAverageNumberRequestsPerUser() {
        if(setUniqueIPAddressOnlyUser.size()!=0){
            return getAverageNumberUserVisits() / setUniqueIPAddressOnlyUser.size();
        }else return 0;
    }

    private void setCountUniqueIPAddressOnlyUser(LogEntry logEntry) {
        if (!logEntry.getUserAgent().isBot()) setUniqueIPAddressOnlyUser.add(logEntry.getIpAddress());
    }
    private void setCountUniqueIPAddress(LogEntry logEntry) {
        setUniqueIPAddress.add(logEntry.getIpAddress());
    }

    private void setCountCountErrorRequest(LogEntry logEntry) {
        Integer codeResponse = logEntry.getCodeResponse();
        if (codeResponse >= 400 && codeResponse < 600) countErrorRequest++;
    }

    private int getAverageErrorRequest() {
        Integer hours = getHouseBetweenMinAndMaxTimeInStatistic();
        if (minTime != null || maxTime != null || hours != 0) {
            return countErrorRequest / hours;
        } else return 0;
    }

    private int getAverageNumberUserVisits() {
        Integer hours = getHouseBetweenMinAndMaxTimeInStatistic();
        if (minTime != null || maxTime != null || hours != 0) {
            return countUserVisits / hours;
        } else return 0;
    }

    private void setCountUserVisits(LogEntry logEntry) {
        if (!logEntry.getUserAgent().isBot()) {
            countUserVisits++;
        }
    }

    public HashMap<String, Double> getBrowserStatisticRatioToOne() {
        HashMap<String, Double> result = new HashMap<String, Double>();
        int countAllBrowserStatistic = browserStatistic
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        browserStatistic.keySet()
                .stream()
                .forEach(string -> {
                    double exactValue = (double) browserStatistic.get(string) / countAllBrowserStatistic;
                    double roundedValue = Math.round(exactValue * 1000.0) / 1000.0;
                    result.put(string, roundedValue);
                });
        return result;
    }

    public HashMap<String, Double> getOperationSystemStatisticRatioToOne() {
        HashMap<String, Double> result = new HashMap<String, Double>();
        int countAllOperationSystemStatistic = operationSystemStatistic
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        operationSystemStatistic.keySet()
                .stream()
                .forEach(string -> {
                    double exactValue = (double) operationSystemStatistic.get(string) / countAllOperationSystemStatistic;
                    double roundedValue = Math.round(exactValue * 1000.0) / 1000.0;
                    result.put(string, roundedValue);
                });
        return result;
    }

    private void setUniquePage(LogEntry logEntry) {
        if (logEntry.getCodeResponse() == 200) {
            this.uniquePage.add(logEntry.getUrl());
        }
    }

    private void setUniquePageNotExist(LogEntry logEntry) {
        if (logEntry.getCodeResponse() == 404) {
            this.uniquePageNotExist.add(logEntry.getUrl());
        }
    }

    public String getUniquePageNotExistAsString() {
        return String.join("\n", uniquePageNotExist);
    }

    public String getUniquePageAsString() {
        return String.join("\n", uniquePage);
    }

    private void setTotalTraffic(LogEntry logEntry) {
        this.totalTraffic += logEntry.getByteResponse();
    }

    private void setMinAndMaxTime(LogEntry logEntry) {

        LocalDateTime localDateTime = getLocalDateTime(logEntry);
        if (minTime == null) {
            this.minTime = localDateTime;
        } else if (minTime.isAfter(localDateTime)) {
            this.minTime = localDateTime;
        }
        if (maxTime == null) {
            this.maxTime = localDateTime;
        } else if (maxTime.isBefore(localDateTime)) {
            this.maxTime = localDateTime;
        }

    }

    private static LocalDateTime getLocalDateTime(LogEntry logEntry) {
        LocalDateTime localDateTime = logEntry.getDateAndTime().toLocalDateTime();
        return localDateTime;
    }

    public long getTrafficRate() {
        if (minTime != null || maxTime != null || totalTraffic != 0) {
            Integer hours = getHouseBetweenMinAndMaxTimeInStatistic();
            return totalTraffic / hours;
        }
        return 0;
    }

    public int getHouseBetweenMinAndMaxTimeInStatistic() {
        return Math.toIntExact(ChronoUnit.HOURS.between(minTime, maxTime));
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
                            "Среднее значение трафика за час: %d\n" +
                            "Статистика по операционным системам с абсолютными значениями: %s\n" +
                            "Статистика по операционным системам с относительными значениями: %s\n" +
                            "Статистика по браузерам с абсолютными значениями: %s\n" +
                            "Статистика по браузерам с относительными значениями: %s\n" +
                            "Среднее количество запросов за час от пользователей: %d\n" +
                            "Среднее количество запросов за час с ошибками: %d\n" +
                            "Средней посещаемости за час одним пользователем: %d",
                    countLog,
                    botStatisticString,
                    totalTraffic,
                    minTime.toString(),
                    maxTime.toString(),
                    getHouseBetweenMinAndMaxTimeInStatistic(),
                    getTrafficRate(),
                    operationSystemStatistic.toString(),
                    getOperationSystemStatisticRatioToOne().toString(),
                    browserStatistic.toString(),
                    getBrowserStatisticRatioToOne(),
                    getAverageNumberUserVisits(),
                    getAverageErrorRequest(),
                    getAverageNumberRequestsPerUser());
        } else {
            return String.format("Общее количество запросов: 0");
        }
    }
}
