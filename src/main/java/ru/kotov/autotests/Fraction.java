package ru.kotov.autotests;

public class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным");
        }
        this.denominator = denominator;
    }

    public Fraction sum(Fraction a, Fraction b) {
        int newDenominator = this.nok(a.denominator, b.denominator);
        int newNumerator = a.numerator * (newDenominator / a.denominator) + b.numerator * (newDenominator / b.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(Fraction b) {
        int newDenominator = this.nok(denominator, b.denominator);
        int newNumerator = numerator * (newDenominator / denominator) - b.numerator * (newDenominator / b.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(int number) {
        Fraction b = new Fraction(denominator * number, denominator);
        return minus(b);
    }

    private int nok(int a, int b) {
        return a * b / nod(a, b);
    }

    private int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nod(b, a % b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private int getPrivateNumerator() {
        return numerator;
    }

    private int getPrivateDenominator() {
        return denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}
