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
    private final String browserVersion;
    private final String botName;
    private final String operatingSystem;

    public UserAgent(String fullString) {
        this.fullString = fullString;
        UserAgentContext userAgentContext = parseStringUserAgent(fullString);
        this.browser = userAgentContext.getNotFinalBrowser();
        this.browserVersion = userAgentContext.getNotFinalBrowserVersion();
        this.botName = userAgentContext.getNotFinalBotName();
        this.operatingSystem = userAgentContext.getNotFinalOperatingSystem();
    }

    private UserAgentContext parseStringUserAgent(String fullString) {
        UserAgentContext uerAgentContext = new UserAgentContext();
        Matcher matcherV03 = Pattern
                .compile("^(.+?)\\s+?.*$")
                .matcher(fullString);
        Matcher matcherV02 = Pattern
                .compile("^(.+?)\\s+?\\(.*http.+?\\)$")
                .matcher(fullString);
        Matcher matcherV01 = Pattern
                .compile("^[^\\s]+?$")
                .matcher(fullString);
        Matcher matcherV0 = Pattern
                .compile("^(.+?)\\s+?\\(+?.+?;(.+)\\)+?$")
                .matcher(fullString);
        Matcher matcherV11 = Pattern
                .compile("^(.+?)\\s+?\\(+?(.+)\\)+?\\s+?(.+?)$")
                .matcher(fullString);
        Matcher matcherV1 = Pattern
                .compile("^(.+?)\\s+?\\(+?.+?;\\s+?(.+);(.+)\\)+?$")
                .matcher(fullString);
        Matcher matcherV2 = Pattern
                .compile("^(.+?)\\s+?\\(\\+http.+?;\\s+.+?;\\s+?(.+)\\)+?")
                .matcher(fullString);
        Matcher matcherV22 = Pattern
                .compile("^(.+?)\\s+?\\(\\+http.+?;\\s+?(.+)\\)+?")
                .matcher(fullString);
        Matcher matcherV3 = Pattern
                .compile("^(.+?)\\s+?\\(.+?;\\s+(.+?);\\s+?(.+);\\s+.+\\)+?$")
                .matcher(fullString);
        Matcher matcherV4 = Pattern
                .compile("^(.+?)\\s+?\\(compatible;\\s+(.+?);\\s+?\\++.+\\)+?")
                .matcher(fullString);
        Matcher matcherV5 = Pattern
                .compile("^(.+?)\\s+?.+?\\s+?\\(.+?;\\s+?.+?;\\s+?(.+?);.+?\\)\\s+?(.+?)$")
                .matcher(fullString);
        Matcher matcherV6 = Pattern
                .compile("^(.+?)\\s+?\\(+?(.+?)\\s?\\)+?\\s+?.+?\\s+?\\(+?.+?\\)\\s+?(.+?)$")
                .matcher(fullString);
        Matcher matcherV7 = Pattern
                .compile("^(.+?)\\s+?\\(+?(.+?)\\s?\\)+?\\s+?.+?\\s+?\\(+?.+?\\)\\s+?(.+?)\\s\\(+?.+?\\;\\s+?(.+?)\\;\\s.+?\\)$")
                .matcher(fullString);
        Matcher matcherV8 = Pattern
                .compile("")
                .matcher(fullString);
        try {
            if (matcherV7.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV7.group(1));
                uerAgentContext.setNotFinalBrowserVersion(matcherV7.group(3));
                uerAgentContext.setNotFinalBotName(matcherV7.group(4));
                uerAgentContext.setNotFinalOperatingSystem(matcherV7.group(2));
            } else if (matcherV6.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV6.group(1));
                uerAgentContext.setNotFinalBrowserVersion(matcherV6.group(3));
                uerAgentContext.setNotFinalOperatingSystem(matcherV6.group(2));
            } else if (matcherV5.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV5.group(1));
                uerAgentContext.setNotFinalBrowserVersion(matcherV5.group(3));
                uerAgentContext.setNotFinalBotName(matcherV5.group(2));
            } else if (matcherV4.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV4.group(1));
                uerAgentContext.setNotFinalBotName(matcherV4.group(2));
            } else if (matcherV3.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV3.group(1));
                uerAgentContext.setNotFinalBotName(matcherV3.group(2));
                uerAgentContext.setNotFinalOperatingSystem(matcherV3.group(3));
            } else if (matcherV2.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV2.group(1));
                uerAgentContext.setNotFinalBotName(matcherV2.group(2));
            } else if (matcherV22.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV22.group(1));
                uerAgentContext.setNotFinalBotName(matcherV22.group(2));
            } else if (matcherV1.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV1.group(1));
                uerAgentContext.setNotFinalBotName(matcherV1.group(2));
                uerAgentContext.setNotFinalOperatingSystem(matcherV1.group(3));
            } else if (matcherV11.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV11.group(1));
                uerAgentContext.setNotFinalBrowserVersion(matcherV11.group(3));
                uerAgentContext.setNotFinalOperatingSystem(matcherV11.group(2));
            } else if (matcherV0.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV0.group(1));
                uerAgentContext.setNotFinalBotName(matcherV0.group(2));
            } else if (matcherV01.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV01.group(0));
            } else if (matcherV02.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV02.group(1));
            } else if (matcherV03.find()) {
                uerAgentContext.setNotFinalBrowser(matcherV03.group(1));
            } else {
                if (!fullString.equals("-")) {
                    System.out.println(fullString);
                }
            }
        } catch (Exception ex) {
            log.error("Error parse UserAgent string: {}\nerror: {}", fullString, ex.getMessage());
        }
        return uerAgentContext;
    }

    @Data
    private class UserAgentContext {
        private String notFinalBrowser = null;
        private String notFinalBrowserVersion = null;
        private String notFinalBotName = null;
        private String notFinalOperatingSystem = null;
    }
}
