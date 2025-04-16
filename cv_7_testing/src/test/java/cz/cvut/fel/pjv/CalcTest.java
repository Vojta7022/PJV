package cz.cvut.fel.pjv;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalcTest {

    @org.junit.jupiter.api.BeforeAll
    static void initTest() {
        System.out.println("init");
    }

    @org.junit.jupiter.api.AfterAll
    static void cleanTest() {
        System.out.println("clean");
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("add");
        Calc calc = new Calc();
        Assertions.assertEquals(15, calc.add(10, 5), "10 + 5 should equal 15");
        Assertions.assertEquals(0, calc.add(0, 0), "0 + 0 should equal 0");
        Assertions.assertEquals(-5, calc.add(-10, 5), "-10 + 5 should equal -5");
        Assertions.assertEquals(5, calc.add(10, -5), "10 + -5 should equal 5");
        Assertions.assertEquals(0, calc.add(-5, 5), "-5 + 5 should equal 0");
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        System.out.println("subtract");
        Calc calc = new Calc();
        Assertions.assertEquals(5, calc.subtract(10, 5));
        Assertions.assertEquals(0, calc.subtract(0, 0));
        Assertions.assertEquals(-15, calc.subtract(-10, 5));
        Assertions.assertEquals(15, calc.subtract(10, -5));
        Assertions.assertEquals(-10, calc.subtract(-5, 5));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        System.out.println("multiply");
        Calc calc = new Calc();
        Assertions.assertEquals(50, calc.multiply(10, 5));
        Assertions.assertEquals(0, calc.multiply(0, 0));
        Assertions.assertEquals(-50, calc.multiply(-10, 5));
        Assertions.assertEquals(-50, calc.multiply(10, -5));
        Assertions.assertEquals(-25, calc.multiply(-5, 5));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        System.out.println("divide");
        Calc calc = new Calc();
        Assertions.assertEquals(2, calc.divide(10, 5));
        Assertions.assertEquals(0, calc.divide(0, 1));
        Assertions.assertEquals(-2, calc.divide(-10, 5));
        Assertions.assertEquals(-2, calc.divide(10, -5));
        Assertions.assertEquals(-1, calc.divide(-5, 5));

        // Test division by zero
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(10, 0);
        });
        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}