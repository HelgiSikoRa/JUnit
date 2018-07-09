package com.epam.lab.task5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.epam.lab.task5.PersonList.USER_DIR;
import static com.epam.lab.task5.PersonList.FILE_PATH;
import static org.junit.Assert.*;

public class PersonListTest {
    public static List<Person> list;
    private static PersonList personList;
    public static Person person;
    private static Person person1;
    private static Person person2;
    private static Person person3;
    private static Path path;
    private static ArrayList<Person> listSerializeble;
    private static ArrayList<Person> listDeserialized;

    @BeforeClass
    public static void initList() {
        person = new Person("Sarah", "Connor", 30000.00);
        person1 = new Person("Pitter", "Parker", 27000.00);
        person2 = new Person("Tony", "Stark", 32000.00);
        person3 = new Person("Tom", "Hardy", 31000.00);
        personList = new PersonList();
        list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);
        listSerializeble = new ArrayList<>();
        listSerializeble.add(person);
        listSerializeble.add(person1);
        listSerializeble.add(person3);
        listDeserialized = new ArrayList<>();
        path = Paths.get(System.getProperty(USER_DIR) + (FILE_PATH));
    }

    @Test
    public void shouldReturnSizeOfInitializedList() {
        int listSizeAfterInitialize = personList.size(list);
        assertEquals("List shouldReturnSizeOfInitializedList after initialize", 3, listSizeAfterInitialize);
    }

    //Test void method by checking the size of initialized list before and after adding one element
    @Test
    public void shouldAddPersonToList() {
        personList.addPersonToList(list, person3);
        assertEquals("List shouldReturnSizeOfInitializedList after add", 4, list.size());
    }

    //Test void method by creating new file, serializing list of object to file and check path by assertTrue
    @Test
    public void shouldCreateFileAndSerializableListOfObject() {
        personList.writeObject(listSerializeble);
        assertTrue(path.toFile().exists());
    }

    //Test deserialization process. Object in list before serialization equals after once
    @Test
    public void shouldDeserializeStreamToObject() throws IOException, ClassNotFoundException {
        if (!Files.exists(path)) shouldCreateFileAndSerializableListOfObject();
        List<Person> resultlist = personList.readObject(listDeserialized);
        assertEquals("Deserialized list", resultlist.toString(), listSerializeble.toString());
    }

    @AfterClass
    public static void shouldRemoveAll() {
        personList.removeAll(list);
    }
}