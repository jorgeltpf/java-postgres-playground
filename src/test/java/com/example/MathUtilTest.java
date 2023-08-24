package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.example.MathUtil;

public class MathUtilTest {
    @Test
    void testMdcP1() {
        int a = 6, b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP3Negativo() {
        int a = -6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP3Positivo() {
        int a = -6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP6() {
        int a = 6, b = 2;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP7() {
        int a = 6, b = 2;
        int esperado = MathUtil.mdc(-a, b);
        int obtido = MathUtil.mdc(-a, -b);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP8() {
        int a = 6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP8Negativo() {
        int a = 6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, -a);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12() {
        int p = 7, a = p;
        int esperado = 7;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12UmPrimo() {
        int p = 7, a = 2;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12UmPrimoEhUm() {
        int p = 7, a = 1;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcCasoGeral() {
        int p = 12, a = 9;
        int esperado = 3;
        int obtido = MathUtil.mdc(p, a);
        assertEquals(esperado, obtido);
    }
}
