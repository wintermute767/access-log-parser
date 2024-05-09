package ru.kotov.autotests.statistic;

import ru.kotov.autotests.log.components.LogEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogStatistic {
    public static String getBotStatistic(List<LogEntry> logEntries, List<String> statisticBotList) {
        Map<String, Integer> botStatistic = new HashMap<>();
        Integer responseWithUserAgent = 0;
        for (LogEntry logEntry : logEntries) {
            responseWithUserAgent++;
            if (logEntry.getUserAgent() != null) {
                String botName = logEntry.getUserAgent().getBotName();
                botStatistic.computeIfAbsent(botName, integer -> 0);
                botStatistic.computeIfPresent(botName, (Sting, integer) -> integer + 1);
            }
        }
        if (!responseWithUserAgent.equals(0)) {
            int finalResponseWithUserAgent = responseWithUserAgent;
            String botStatisticString = botStatistic
                    .keySet()
                    .stream()
                    .filter(string -> statisticBotList.contains(string))
                    .map(string -> {
                        int botRequests = botStatistic.get(string).intValue();
                        Double ratio = getPercent(botRequests,finalResponseWithUserAgent);
                        return String.format("%s количество запросов: %d, соотношение от общего количества запросов: %.3f%%",
                                string, botRequests, ratio);
                    }).collect(Collectors.joining("\n"));
            return String.format("Общее количество запросов: %d\n%s",
                    responseWithUserAgent, botStatisticString);
        } else {
            return String.format("Общее количество запросов: 0");
        }
    }

    private static Double getPercent(int x, int y) {
        return ((double) x) / y * 100;
    }
}
