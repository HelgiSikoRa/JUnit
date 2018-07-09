package com.epam.lab.task3;

class Salary {
    private final double COMPARE_THE_SAME = 0.00;

    double calculateYearlySalary(Person person, int year) {
        return person.getMonthlySalary() / year;
    }

    double convertMonthlySalaryUahToUsd(Person person, double currentExchangeRates) throws ArithmeticException {
        if (currentExchangeRates == COMPARE_THE_SAME) throw new ArithmeticException("Divide by zero is not allowed");
        return person.getMonthlySalary() / currentExchangeRates;
    }
}