package warehouse;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String fullName;
    private String address;
    private String email;
    private String phoneNr;
    private LocalDate dateOfBirth;

    public Person(String fullName, String address, String email, String phoneNr, String dateOfBirth) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNr = phoneNr;
        this.setDateOfBirth(dateOfBirth);
    }

    public Person(String fullName, String address, String email, String phoneNr, LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNr = phoneNr;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getAge(){
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, today);
        return period.getYears();
    }

    @Override
    public String toString() {
        return "\nPerson:\n" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", \nemail='" + email + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ",\ndateOfBirth= " + dateOfBirth +
                "\n*******************************";
    }
}
