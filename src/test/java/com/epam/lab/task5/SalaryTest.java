package com.epam.lab.task5;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class SalaryTest {
    private static Person person;
    private static Salary salary;
    private final static double THE_SAME_VALUE = 0.00;
    private final static int NUMBER_OF_MONTH_IN_YEAR = 12;

    @BeforeClass
    public static void initPerson() {
        person = new Person("Sarah", "Connor", 30000.00);
        salary = new Salary();
    }

    @Test
    public void shouldCalculateYearlySalary() {
        double result = salary.calculateYearlySalary(person, NUMBER_OF_MONTH_IN_YEAR);
        assertEquals(360000.00, result, 0.0);
    }

    @Test
    public void shouldBeNotNullInputParameter() {
        salary.calculateYearlySalary(person, NUMBER_OF_MONTH_IN_YEAR);
        assertNotNull(person);
    }

    @Test
    public void shouldConvertMonthlySalaryUahToUsd() throws ArithmeticException {
        double currentExchangeRates = 26.2;
        double result = salary.convertMonthlySalaryUahToUsd(person, currentExchangeRates);
        assertEquals(1145.0381679389313, result, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticException() throws ArithmeticException {
        salary.convertMonthlySalaryUahToUsd(person, THE_SAME_VALUE);
    }

    //Test private methods
    @SuppressWarnings("unchecked")
    @Test
    public void shouldCalculateNumbersOfWorkingHoursPerMonth() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> classInstance = salary.getClass();
        Method method = classInstance.getDeclaredMethod("calculateNumbersOfWorkingHoursPerMonth", int.class, int.class);
        method.setAccessible(true);
        int numbersOfDayInMonth = 30;
        int numbersOfWorkingHoursPerDay = 8;
        assertEquals(240, method.invoke(salary, numbersOfDayInMonth, numbersOfWorkingHoursPerDay));
    }

    @Test
    public void shouldCalculateHourRate() {
        boolean result = (salary.calculateHourRate(person)) == 125.00;
        assertTrue(true);
    }
}