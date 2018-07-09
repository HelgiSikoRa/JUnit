package com.epam.lab.task2;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SalaryTest {
    private static Person person;
    private static Salary salary;
    private static double currentExchangeRates = 26.2;
    final static double THE_SAME_VALUE = 0.00;
    final static int NUMBER_OF_MONTH_IN_YEAR = 12;

    @BeforeClass
    public static void initPerson() {
        person = new Person();
        person.setFirstName("Sarah");
        person.setLastName("Connor");
        person.setMonthlySalary(30000.00);
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
        double result = salary.convertMonthlySalaryUahToUsd(person, currentExchangeRates);
        assertEquals(1145.0381679389313, result, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticException() throws ArithmeticException {
        salary.convertMonthlySalaryUahToUsd(person, THE_SAME_VALUE);
    }
}