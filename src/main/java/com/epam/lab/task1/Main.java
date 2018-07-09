package com.epam.lab.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        double currentExchangeRates = 26.2;
        final int NUMBER_OF_MONTH_IN_YEAR = 12;

        Person person = new Person("Sarah", "Connor", 30000.00);
        Salary salary = new Salary();

        double yearlySalary = salary.calculateYearlySalary(person, NUMBER_OF_MONTH_IN_YEAR);
        LOG.info(yearlySalary);

        double usdMonthlySalary = salary.convertMonthlySalaryUahToUsd(person, currentExchangeRates);
        LOG.info(usdMonthlySalary);
    }
}