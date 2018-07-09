package com.epam.lab.task5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PersonList {
    private final static Logger LOG = LogManager.getLogger(PersonList.class);
    static final String USER_DIR = "user.dir";
    static final String FILE_PATH = "\\src\\main\\resources\\Serializable.txt";
    public static Path path;

    void addPersonToList(List<Person> list, Person person) {
        list.add(person);
    }

    int size(List<Person> list) {
        return list.size();
    }

    void removeAll(List<Person> list) {
        list.clear();
    }

    void writeObject(List<Person> list) {
        try {
            path = Paths.get(System.getProperty(USER_DIR) + (FILE_PATH));
            Files.createDirectories(path.getParent());
            try {
                Files.createFile(path);
                LOG.info("Created file");
            } catch (FileAlreadyExistsException e) {
                LOG.info("File already exists: " + e.getMessage());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty(USER_DIR) + (FILE_PATH));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Object o : list) {
                objectOutputStream.writeObject(o);
            }
            objectOutputStream.close();
        } catch (IOException e) {
            LOG.info(e.getMessage());
        }
    }

    public List<Person> readObject(List<Person> list) throws ClassNotFoundException, IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty(USER_DIR) + (FILE_PATH));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            while (fileInputStream.available() != -1) {
                Person person = (Person) objectInputStream.readObject();
                LOG.info(person.toString());
                list.add(person);
            }
        } catch (EOFException e) {
            LOG.info(e.getMessage());
        }
        return list;
    }
}