package com.epam.lab.task1;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class PersonTest {
    private static Person person;

    @BeforeClass
    public static void initPerson() {
        person = new Person();
    }

    @Test
    public void shouldGetFirstName() throws NoSuchFieldException, IllegalAccessException {
        final Field field = person.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(person, "Sarah");
        final String result = person.getFirstName();
        assertEquals("Field wasn't retrieved properly.", "Sarah", result);
    }

    @Test
    public void shouldSetFirstName() throws NoSuchFieldException, IllegalAccessException {
        person.setFirstName("Sarah");
        final Field field = person.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("Fields didn't match.", "Sarah", field.get(person));
    }

    @Test
    public void shouldGetLastName() throws NoSuchFieldException, IllegalAccessException {
        final Field field = person.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(person, "Connor");
        final String result = person.getLastName();
        assertEquals("Field wasn't retrieved properly.", "Connor", result);
    }

    @Test
    public void shouldSetLastName() throws NoSuchFieldException, IllegalAccessException {
        person.setLastName("Connor");
        final Field field = person.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Fields didn't match.", "Connor", field.get(person));
    }

    @Test
    public void shouldGetMonthlySalary() throws NoSuchFieldException, IllegalAccessException {
        final Field field = person.getClass().getDeclaredField("monthlySalary");
        field.setAccessible(true);
        field.set(person, 30000.00);
        final double result = person.getMonthlySalary();
        assertEquals("Field wasn't retrieved properly.", 30000.00, result, 0.0);
    }

    @Test
    public void shouldSetMonthlySalary() throws NoSuchFieldException, IllegalAccessException {
        person.setMonthlySalary(30000.00);
        final Field field = person.getClass().getDeclaredField("monthlySalary");
        field.setAccessible(true);
        assertEquals("Fields didn't match.", 30000.00, field.get(person));
    }
}