package nba;

import java.util.Arrays;
import java.util.List;

public class Team implements Comparable<Team> {
    private String name;
    private Coach coach;
    private List<Player> players;
    private double ppg;
    private double apg;
    private double rpg;
    private int wins;
    private int loses;

    public Team(String name, Coach coach, List<Player> players, double ppg, double apg, double rpg, int wins, int loses) {
        this.name = name;
        this.coach = coach;
        this.players = players;
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
        this.wins = wins;
        this.loses = loses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public double getApg() {
        return apg;
    }

    public void setApg(double apg) {
        this.apg = apg;
    }

    public double getRpg() {
        return rpg;
    }

    public void setRpg(double rpg) {
        this.rpg = rpg;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    @Override
    public String toString() {
        return "\nTeam{" +
                "name='" + name + '\'' +
                ", coach=" + coach +
                ", players=" + players +
                ", ppg=" + ppg +
                ", apg=" + apg +
                ", rpg=" + rpg +
                ", wins=" + wins +
                ", loses=" + loses +
                '}';
    }

    @Override
    public int compareTo(Team teamToCompare) {
        if (this.ppg == teamToCompare.getPpg() ) {
            return 0;
        } else {
            return this.ppg > teamToCompare.getPpg() ? 1 : -1;

        }


    }
}