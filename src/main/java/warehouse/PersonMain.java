package warehouse;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Asmeninė informacija
 * a. Sukurkite failą, kuriame būtų visi asmens duomenys (vardas, pavardė, telefono numeris). Atskirų asmenų duomenys turėtų būti pateikiami šiose eilutėse.
 * b. Skaitykite duomenis iš failo ir pagal juos sukurkite žmonių objektus (bet kokiu būdu - „Regex“, „String.split“ ir kt.).
 * c. Įveskite sukurtus objektus į „ArrayList“ arba „Map: kiss_smiling_face:).
 * d. Pateikite gautus duomenis.
 */


public class PersonMain {

    private static final String fileLocation = "src/main/java/warehouse/data.txt";

    public static void main(String[] args) throws DbReaderException {
        DataBaseReader dataBaseReader = new DataBaseReader(fileLocation);
        DataBaseWriter dataBaseWriter = new DataBaseWriter(fileLocation);


        runMe(dataBaseReader, dataBaseWriter);
//            writeToFile();

    }

    private static void runMe(DataBaseReader dataBaseReader, DataBaseWriter dataBaseWriter) throws DbReaderException {
        System.out.println("chose from menu: ");
        Scanner s = getScanner();
        String chose = "";
        while (!chose.equalsIgnoreCase("x")){
            menu();
            chose = s.nextLine();
            switch (chose) {
                case "1" :
                    dataBaseWriter.inputPerson(makePerson());
                break;
                case "2" :
                    printAllPersons(dataBaseReader.getAllPersons());
                break;
                case "3" :
                    System.out.println("input email for Person DELETION");
                    String emailToPersonDelete = s.nextLine();
                    dataBaseWriter.deletePerson(emailToPersonDelete);
                break;
                default:
                    System.out.println("wrong chose - try again");
                break;

            }
        }
    }

    private static void menu() {
        System.out.println("[1]- input NEW Person");
        System.out.println("[2]- show All Persons");
        System.out.println("[3]- DELETE Person");
        System.out.println("[x]- Exit");
    }

    private static void writeToFile() {
        Person penny = new Person("Penny Hofstadter", "Jelly Ave. 13", "penny@gmail.com", "555 0012", "02/12/1985");
        Person sheldon = new Person("Sheldon Lee Cooper", "London St. 23", "sheldon@gmail.com", "555 0013", "09/11/1980");
        Person howard = new Person("Howard Joel Wolowitz", "Fish St. 8", "howard@gmail.com", "555 0014", "03/07/1979");
        Person raj = new Person("Rajesh Ramayan Koothrappali", "Snow St. 33", "raj@gmail.com", "555 0015", "04/05/1981");
        Person bernadette = new Person("Bernadette Rostenkowski-Wolowitz", "Uncle Ave. 45", "bernadette@gmail.com", "555 0016", "01/03/1993");
        Person amy = new Person("Amy Farrah Fowler", "Italy St. 11", "amy@gmail.com", "555 0016", "08/08/1977");
        Person leonard = new Person("Leonard Hofstadter", "Mars canyon St. 995", "leonard@gmail.com", "555 0017", "21/06/2001");


        File file = new File(fileLocation);

        List<Person> personList = new ArrayList<>();
        personList.add(penny);
        personList.add(sheldon);
        personList.add(howard);
        personList.add(raj);
        personList.add(bernadette);
        personList.add(amy);
        personList.add(leonard);

        System.out.println("Write to file ... ");
        for (Person person : personList) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

                String fileLine = "\nAdded new line!";
                bufferedWriter.write(person.getFullName() + "\n");
                bufferedWriter.write(person.getAddress() + "\n");
                bufferedWriter.write(person.getEmail() + "\n");
                bufferedWriter.write(person.getPhoneNr() + "\n");
                bufferedWriter.write(person.getDateOfBirth() + "\n");
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFile() {
        File file = new File(fileLocation);


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String fileLine;
            System.out.println("Printing out file contents below: ");
            while ((fileLine = bufferedReader.readLine()) != null) {
                System.out.println(fileLine);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person makePerson(){
        Scanner scanner = getScanner();
        System.out.println(" Write full name: ");
        String fullName = scanner.nextLine();
        System.out.println(" please address input... ");
        String address = scanner.nextLine();
        System.out.println(" e-mail please.. ");
        String email = scanner.nextLine();
        System.out.println(" and PHONE Nr.: ");
        String phoneNr = scanner.nextLine();
        System.out.println(" also Date OF Birth ex. 'yyyy-MM-dd': ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new Person(fullName,address,email,phoneNr,dateOfBirth);

    }
    public static Scanner getScanner (){
        return new Scanner(System.in);
    }

    private static void printAllPersons(ArrayList<Person>people){
        for (Person person : people) {
            printOnePerson(person);

        }
    }
    private static void printOnePerson(Person person){
        System.out.println("**********************************************");
        System.out.println("Full name: " + person.getFullName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("E-mail: " + person.getEmail());
        System.out.println("Phone Nr.: " + person.getPhoneNr());
        System.out.println("Age: " + person.getAge());
        System.out.println("**********************************************");
    }


}


