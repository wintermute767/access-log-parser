package ru.kotov.autotests.log.components;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.kotov.autotests.customExeption.CustomParcerLogException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Slf4j
public class LogEntry {
    private String fullStringLog;
    private final InetAddress ipAddress;
    private final ZonedDateTime dateAndTime;
    private final RequestMethod requestMethod;
    private final String url;
    private final HTTPProtocol HTTPProtocol;
    private final Integer codeResponse;
    private final Integer byteResponse;
    private final String refer;
    private final UserAgent userAgent;

    public LogEntry(String fullStringLog) throws CustomParcerLogException {
        this.fullStringLog = fullStringLog;

        String mainRegex = "^(.{7,15})\\s(.*)\\s(.*)\\s\\[(.*)\\]\\s\\\"(.{3,7})\\s(.*)\\s(.*)\\\"\\s(\\d{3})\\s(\\d{1,})\\s\\\"(.*)\\\"\\s\\\"(.*)\\\"$";
        Pattern pattern = Pattern.compile(mainRegex);
        Matcher result = pattern.matcher(fullStringLog);
        if (result.find()) {
            this.ipAddress = getIpAddressFromLog(result.group(1));
            this.dateAndTime = getDateAndTime(result.group(4));
            this.requestMethod = getRequestMethod(result.group(5));
            this.url = result.group(6);
            this.HTTPProtocol = getHTTPProtocol(result.group(7));
            this.codeResponse = getCodeResponse(result.group(8));
            this.byteResponse = getByteResponse(result.group(9));
            this.refer = result.group(10);
            this.userAgent = new UserAgent(result.group(11));
        } else {
            throw new CustomParcerLogException(String.format(
                    "Невозможно обработать строку из-за неправильного формата\sСтрока: %s", fullStringLog));
        }

    }


    private InetAddress getIpAddressFromLog(String stringIpAddress) {
        if (stringIpAddress == null) return null;
        try {
            return InetAddress.getByName(stringIpAddress);
        } catch (UnknownHostException e) {
            log.debug(e.getMessage());
            return null;
        }
    }

    private ZonedDateTime getDateAndTime(String stringZonedDateTime) {
        if (stringZonedDateTime == null) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z").withLocale(Locale.US);
            return ZonedDateTime.parse(stringZonedDateTime, formatter);
        } catch (IllegalArgumentException e) {
            log.debug(e.getMessage());
            return null;
        }
    }

    private RequestMethod getRequestMethod(String stringRequestMethod) {
        if (stringRequestMethod == null) return null;
        try {
            return RequestMethod.valueOf(stringRequestMethod);
        } catch (IllegalArgumentException e) {
            log.debug(e.getMessage());
            return null;
        }
    }


    private HTTPProtocol getHTTPProtocol(String stringHTTPProtocol) {
        if (stringHTTPProtocol == null) return null;
        try {
            return HTTPProtocol.getHTTPProtocolEnum(stringHTTPProtocol);
        } catch (IllegalArgumentException e) {
            log.debug(e.getMessage());
            return null;
        }
    }

    private Integer getCodeResponse(String stringCodeResponse) {
        if (stringCodeResponse == null) return null;
        try {
            return Integer.valueOf(stringCodeResponse);
        } catch (IllegalArgumentException e) {
            log.debug(e.getMessage());
            return null;
        }

    }

    private Integer getByteResponse(String stringByteResponse) {
        if (stringByteResponse == null) return null;
        try {
            return Integer.valueOf(stringByteResponse);
        } catch (IllegalArgumentException e) {
            log.debug(e.getMessage());
            return null;
        }
    }
}
