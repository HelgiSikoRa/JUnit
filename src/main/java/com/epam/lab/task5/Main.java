package com.epam.lab.task5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double currentExchangeRates = 26.2;
        final int NUMBER_OF_MONTH_IN_YEAR = 12;

        Person person = new Person("Sarah", "Connor", 30000.00);
        Person person2 = new Person("Jason", "Born", 29000.00);
        Person person3 = new Person("Piter", "Parker", 30000.00);
        Salary salary = new Salary();
        PersonList personList = new PersonList();
        List<Person> list = new ArrayList<>();
        List<Person> deserializedList = new ArrayList<>();

        double yearlySalary = salary.calculateYearlySalary(person, NUMBER_OF_MONTH_IN_YEAR);
        LOG.info(yearlySalary);

        double usdMonthlySalary = salary.convertMonthlySalaryUahToUsd(person, currentExchangeRates);
        LOG.info(usdMonthlySalary);

        double hourRate = salary.calculateHourRate(person);
        LOG.info(hourRate);

        personList.addPersonToList(list, person);
        personList.addPersonToList(list, person2);
        personList.addPersonToList(list, person3);

        personList.writeObject(list);
        personList.readObject(deserializedList);
    }
}