package com.mentors;

import java.util.Objects;

/**
 * This class represents a fraction with numerator and denominator.
 * Fractions can be added together using the add method.
 * The Fraction class could have some issues or could be improved.
 * Try to find all mistakes, fix the code and write unit tests.
 *
 * @author Gennadii Chursov
 */
public class Fraction {
    public Integer numerator;
    public Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction other) {
        int commonDenominator = lcm(this.denominator, other.denominator);
        int newNumerator = this.numerator * (commonDenominator / this.denominator) + other.numerator * (commonDenominator / other.denominator);
        return new Fraction(newNumerator, commonDenominator);
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return Math.abs(a * (b / gcd(a, b)));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return Objects.equals(numerator, fraction.numerator) && Objects.equals(denominator, fraction.denominator);
    }
}
