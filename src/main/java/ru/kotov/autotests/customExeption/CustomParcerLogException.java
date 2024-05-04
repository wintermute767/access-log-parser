package ru.kotov.autotests.customExeption;

import lombok.Data;

@Data
public class CustomParcerLogException extends RuntimeException {
    private String message;
    public CustomParcerLogException(String massage) {
        this.message=massage;
    }


    @Override
    public String toString() {
        return "CustomLogException{" +
                "message='" + message + '\'' +
                '}';
    }
}
