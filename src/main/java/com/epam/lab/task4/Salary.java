package com.epam.lab.task4;

class Salary {
    private final double COMPARE_THE_SAME = 0.00;
    private int numbersOfDayInMonth = 30;
    private int numbersOfWorkingHoursPerDay = 8;

    double calculateYearlySalary(Person person, int year) {
        return person.getMonthlySalary() * year;
    }

    double convertMonthlySalaryUahToUsd(Person person, double currentExchangeRates) throws ArithmeticException {
        if (currentExchangeRates == COMPARE_THE_SAME) throw new ArithmeticException("Divide by zero is not allowed");
        return person.getMonthlySalary() / currentExchangeRates;
    }

    double calculateHourRate(Person person) {
        return person.getMonthlySalary() / calculateNumbersOfWorkingHoursPerMonth(numbersOfDayInMonth, numbersOfWorkingHoursPerDay);
    }

    private int calculateNumbersOfWorkingHoursPerMonth(int numbersOfDayInMonth, int numbersOfWorkingHoursPerDay) {
        return numbersOfDayInMonth * numbersOfWorkingHoursPerDay;
    }
}