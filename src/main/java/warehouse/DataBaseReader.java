package warehouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseReader {
    private  final String dbPath;


    public DataBaseReader(String dbPath) {
        this.dbPath = dbPath;
    }

    public ArrayList<Person>getAllPersons(){
        Scanner s = getDbScanner();
        ArrayList<Person>people = new ArrayList<>();
        while (s.hasNextLine()){
            String fullName = s.nextLine();
            String address = s.nextLine();
            String email = s.nextLine();
            String phoneNr = s.nextLine();
            LocalDate dateOfBirth = LocalDate.parse(s.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            s.nextLine();
            people.add(new Person(fullName,address,email,phoneNr,dateOfBirth));
        } return people;
    }

    private Scanner getDbScanner() {
        File file = new File(dbPath);
        Scanner s = null;
        try {
            s = new Scanner(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }return s;
    }




}
