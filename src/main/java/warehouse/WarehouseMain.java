package warehouse;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Warehouse
 * a. User should be able to: add, display all of the details, update, delete an item
 * b. Use composition and collections (The warehouse has products/items)
 * c. Add possibility to display summaries, like sum of all of the products, their prices.
 * d. *Add possibility to update number of items in a specific way, e.g.: “pliers:30” “scissors:+4”
 * Personal information
 * a. Create a file containing any personal data (name, surname, phone number). Data of individual persons should be in the following lines.
 * b. Read data from a file and create objects of people based on them (in any way - Regex, String.split,etc).
 * c. Enter the created objects into ArrayList or Map :slightly_smiling_face: ).
 * d. Present the obtained data.
 * Let’s buy a vehicle
 * a. Create class Person
 * b. Create class Parser
 * c. Create interface or an abstract class Vehicle
 * d. Create classes Car and Bike, that will implement/inherit Vehicle.
 * e. User will provide all of the details about the Person (buyer) using scanner (e.g. “John Smith born 3/24/1984”. Provided information will be parsed using Regex (google or use regular approach with string split) within Parser class. Parser class should receive char sequence and return an object of type Person or Null if provided details will not have required information.
 * f. Created person will then buy a bike and car. Information about what and when was bought should be displayed.
 * g. Brand and model of car/bike should be stored using variable of type Enum.

 Sandėlis
 a. Vartotojas turėtų galėti: pridėti, rodyti visą informaciją, atnaujinti, ištrinti elementą
 b. Naudokite kompoziciją ir kolekcijas (sandėlyje yra produktų / daiktų)
 c. Pridėkite galimybę pateikti santraukas, pvz., Visų produktų sumą, jų kainas.
 d. * Pridėti galimybę atnaujinti elementų skaičių konkrečiu būdu, pvz .: „replės: 30“ „žirklės: +4“
 Asmeninė informacija
 a. Sukurkite failą, kuriame būtų visi asmens duomenys (vardas, pavardė, telefono numeris). Atskirų asmenų duomenys turėtų būti pateikiami šiose eilutėse.
 b. Skaitykite duomenis iš failo ir pagal juos sukurkite žmonių objektus (bet kokiu būdu - „Regex“, „String.split“ ir kt.).
 c. Įveskite sukurtus objektus į „ArrayList“ arba „Map: kiss_smiling_face:).
 d. Pateikite gautus duomenis.
 Nusipirkime transporto priemonę
 a. Sukurti klasės asmenį
 b. Sukurkite klasės analizatorių
 c. Sukurkite sąsają arba abstrakčią klasės transporto priemonę
 d. Sukurkite „Automobilis ir dviratis“ klases, kurios įgyvendins / paveldės transporto priemonę.
 e. Vartotojas pateiks visą išsamią informaciją apie asmenį (pirkėją), naudodamas skaitytuvą (pvz., „John Smith gimė 1984 m. Kovo 24 d.“. Pateikta informacija bus analizuojama naudojant „Regex“ („Google“ arba naudokite įprastą metodą su eilutės padalijimu) „Parser“ klasėje. klasė turėtų gauti char seką ir grąžinti objektą, kurio tipas yra „Person“ arba „Null“, jei pateikta informacija neturės reikiamos informacijos.
 f. Tada sukurtas asmuo pirks dviratį ir automobilį. Reikėtų pateikti informaciją apie tai, kas ir kada buvo nupirkta.
 g. Automobilio / dviračio prekės ženklas ir modelis turėtų būti saugomi naudojant „Enum“ tipo kintamąjį.


 */

public class WarehouseMain extends JFrame {

    private static final String fileLocation = "src/main/java/warehouse/data.txt";

    private JPanel panelTop;
    private JList listPeople;
    private JTextField fullNameField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton saveNew;
    private JButton saveExisting;
    private JTextField birthField;
    private JLabel labelAge;
    private ArrayList<Person>people;
    private DefaultListModel listPeopleModel;

    WarehouseMain(){
        super("This is Person INFO");
        this.setContentPane(this.panelTop);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        people = new ArrayList<Person>();
        listPeopleModel = new DefaultListModel();
        listPeople.setModel(listPeopleModel);
        saveNew.setEnabled(false);
        saveExisting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNewClick(e);
            }
        });
        saveNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSaveClick(e);
            }
        });
        listPeople.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                listPeopleSelection(e);
            }
        });



    }

    public void listPeopleSelection(ListSelectionEvent e) {
        int personNumber = listPeople.getSelectedIndex();
        if (personNumber >= 0){
            Person p = people.get(personNumber);
            fullNameField.setText(p.getFullName());
            addressField.setText(p.getAddress());
            emailField.setText(p.getEmail());
            phoneField.setText(p.getPhoneNr());
            birthField.setText(p.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            labelAge.setText(Integer.toString(p.getAge()) + " years");
            saveExisting.setEnabled(true);
        } else {
            saveExisting.setEnabled(false);
        }
    }

    public void buttonNewClick(ActionEvent e) {
        Person p = new Person(
                fullNameField.getText(),
                addressField.getText(),
                emailField.getText(),
                phoneField.getText(),
                birthField.getText()
        );
        people.add(p);
        refreshPeopleList();
    }

    public void buttonSaveClick(ActionEvent e){
        int personNumber = listPeople.getSelectedIndex();
        if (personNumber >= 0){
            Person p = people.get(personNumber);
            p.setFullName(fullNameField.getText());
            p.setAddress(addressField.getText());
            p.setEmail(emailField.getText());
            p.setPhoneNr(phoneField.getText());
            p.setDateOfBirth(birthField.getText());
            refreshPeopleList();
        }
    }

    public void refreshPeopleList() {
        listPeopleModel.removeAllElements();
        System.out.println("Removing all people from list");
        for (Person p : people) {
            System.out.println("Adding person to list " + p.getFullName());
            listPeopleModel.addElement(p.getFullName());

        }
    }

    public void addPerson (Person p){
            people.add(p);
            refreshPeopleList();
    }


    public static void main(String[] args) {
        WarehouseMain warehouse = new WarehouseMain();
        DataBaseReader dbR = new DataBaseReader(fileLocation);
        warehouse.setVisible(true);

        for (Person allPerson : dbR.getAllPersons()) {
            warehouse.addPerson(allPerson);
        }


    }
}
