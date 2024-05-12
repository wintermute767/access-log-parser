package ru.kotov.autotests;

import java.util.Arrays;
import java.util.List;

public class ClassForTest {
    public String publicStringField;
    private Integer privateIntegerField;
    private static Double privateStaticDoubleField = 1111.2222;
    public List<String> publicListField;
    int intField;
    char charField;

    public ClassForTest(String publicStringField, Integer privateIntegerField, List<String> publicListField, int intField, char charField) {
        this.publicStringField = publicStringField;
        this.privateIntegerField = privateIntegerField;
        this.publicListField = publicListField;
        this.intField = intField;
        this.charField = charField;
    }

    @Override
    public String toString() {
        return "ClassForTest{" +
                "publicStringField='" + publicStringField + '\'' +
                ", privateIntegerField=" + privateIntegerField +
                ", publicListField=" + publicListField +
                ", intField=" + intField +
                ", charArrayField=" + charField +
                '}';
    }
}
