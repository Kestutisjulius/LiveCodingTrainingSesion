package warehouse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataBaseWriter {
    private final String dbPath;



public void inputPerson (Person person) throws DbReaderException {
    DataBaseReader dataBaseReader = new DataBaseReader(dbPath);
    ArrayList<Person> people = dataBaseReader.getAllPersons();
    for (Person personFromDb : people) {
        if (person.getEmail().equals(personFromDb.getEmail())) {
            throw new DbReaderException(" This email exist... " + person.getEmail());
        }
    } writePersonToFile(person);
}

    public DataBaseWriter(String dbPath) {
        this.dbPath = dbPath;
    }

    private void writePersonToFile(Person p) {
        PrintWriter printWriter = getDbWriter(true);
        printWriter.println(p.getFullName());
        printWriter.println(p.getAddress());
        printWriter.println(p.getEmail());
        printWriter.println(p.getPhoneNr());
        printWriter.println(p.getDateOfBirth());
        printWriter.println();
        printWriter.close();

    }

    private void renewPersonDB (ArrayList<Person> people) {
        PrintWriter printWriter = getDbWriter(false);
        printWriter.close();
        for (Person person : people) {
            writePersonToFile(person);
        }
    }

    private PrintWriter getDbWriter(boolean append) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(dbPath,append);

        } catch (IOException e) {
            e.printStackTrace();
        }return new PrintWriter(fw);
    }

    public void deletePerson(String email) throws DbReaderException{
    DataBaseReader dataBaseReader = new DataBaseReader(dbPath);
        ArrayList<Person>people = dataBaseReader.getAllPersons();
        boolean isRemoved = false;
        Person deletedPerson = null;
        for (Person person : people) {
            if (person.getEmail().equals(email)){
                deletedPerson = person;
                isRemoved = true;
            }
        } people.remove(deletedPerson);
            if (!isRemoved) {
                throw new DbReaderException("this Email not found");
            } renewPersonDB(people);

    }
}
