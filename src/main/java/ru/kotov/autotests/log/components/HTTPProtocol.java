package ru.kotov.autotests.log.components;

public enum HTTPProtocol {
    HTTP1("HTTP/1.0"),
    HTTP11("HTTP/1.1"),
    HTTP2("HTTP/2.0");

    private final String httpProtocol;

    HTTPProtocol(String httpProtocol) {
        this.httpProtocol = httpProtocol;
    }

    public String getHttpProtocol() {
        return httpProtocol;
    }

    public static HTTPProtocol getHTTPProtocolEnum(String httpProtocol) throws IllegalArgumentException {
        for (HTTPProtocol enumOne : values()) {
            if (enumOne.getHttpProtocol().equals(httpProtocol)) {
                return enumOne;
            }
        }
        throw new IllegalArgumentException("No enum found with HTTP Protocol: [" + httpProtocol + "]");
    }
}
