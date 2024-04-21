package org.example;

import model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void testToString() {
        Polynomial p1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial("-5x^6-2x^3+15x-23");
        String result1 = p1.toString();
        String result2 = p2.toString();
        assertEquals (result1, "+1.0x^3-2.0x^2+6.0x^1-5.0x^0");
        assertEquals (result2, "-5.0x^6-2.0x^3+15.0x^1-23.0x^0");
    }
}