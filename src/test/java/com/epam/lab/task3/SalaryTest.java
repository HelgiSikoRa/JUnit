package com.epam.lab.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SalaryTest extends TestWatcher {
    private static Person person;
    private static Salary salary;
    private final static double THE_SAME_VALUE = 0.00;
    private final static int NUMBER_OF_MONTH_IN_YEAR = 12;
    private final static Logger LOG = LogManager.getLogger(SalaryTest.class);

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            LOG.error(description.toString(), e);
            super.failed(e, description);
        }

        @Override
        protected void succeeded(Description description) {
            LOG.info(description.toString());
            super.succeeded(description);
        }
    };

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
        double currentExchangeRates = 26.2;
        double result = salary.convertMonthlySalaryUahToUsd(person, currentExchangeRates);
        assertEquals(1145.0381679389313, result, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticException() throws ArithmeticException {
        salary.convertMonthlySalaryUahToUsd(person, THE_SAME_VALUE);
    }
}