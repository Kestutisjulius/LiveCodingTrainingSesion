package nba;

public class Coach extends Person{

    private int yearsOfExperience;

    public Coach(String name, int age, int salary, int yearsOfExperience) {
        super(name, age, salary);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "yearsOfExperience=" + yearsOfExperience +
                "} " + super.toString();
    }
}
