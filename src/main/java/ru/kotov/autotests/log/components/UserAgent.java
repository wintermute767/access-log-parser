package ru.kotov.autotests.log.components;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Data
public class UserAgent {

    private final String fullString;

    private final String browser;
    private final String operatingSystem;
    private final String botName;

    public UserAgent(String fullString) {
        this.fullString = fullString;
        this.botName = getBotName(fullString);
        this.browser = getBrowserName(fullString);
        this.operatingSystem = getOperatingSystem(fullString);

    }
    public boolean isBot() {
        return this.getFullString().contains("bot");
    }
    private String getBotName(String fullString) {
        Matcher matcher = Pattern
                .compile("\\s\\(compatible\\;\\s+?(.+?)\\;")
                .matcher(fullString);
        try {
            if (matcher.find()) {
                return matcher.group(1);
            } else return "Other";
        } catch (Exception ex) {
            log.error("Error parse UserAgent string: {}\nerror: {}", fullString, ex.getMessage());
            return null;
        }
    }

    private String getOperatingSystem(String fullString) {
        if (fullString.contains("Linux")) {
            return "Linux";
        } else if (fullString.contains("Windows")) {
            return "Windows";
        } else if (fullString.contains("Mac OS")) {
            return "Mac OS";
        } else return "other";
    }

    private String getBrowserName(String fullString) {
        Matcher matcherOpera = Pattern
                .compile("^Opera\\/")
                .matcher(fullString);
        Matcher matcherEdge = Pattern
                .compile("^Mozilla.+?Chrome\\/+?.+?\\s+?Safari\\/+?.+?Edg\\/")
                .matcher(fullString);
        Matcher matcherChrome = Pattern
                .compile("^Mozilla.+?Chrome\\/+?.+?\\s+?Safari\\/+?.+?")
                .matcher(fullString);
        Matcher matcherFirefox = Pattern
                .compile("^Mozilla.+?Firefox\\/")
                .matcher(fullString);
        Matcher matcherSafari = Pattern
                .compile("^Mozilla.+?Version\\/.+?Safari\\/")
                .matcher(fullString);
        try {
            if (matcherOpera.find()) {
                return "Opera";
            } else if (matcherEdge.find()) {
                return "Edge";
            } else if (matcherChrome.find()) {
                return "Chrome";
            } else if (matcherFirefox.find()) {
                return "Firefox";
            } else if (matcherSafari.find()) {
                return "Safari";
            } else {
                return "Other";
            }
        } catch (Exception ex) {
            log.error("Error parse UserAgent string: {}\nerror: {}", fullString, ex.getMessage());
            return null;
        }
    }
}
