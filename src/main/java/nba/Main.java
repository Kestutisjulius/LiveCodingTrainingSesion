package nba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Coach coachA = new Coach("Jonas", 30, 2300, 5);
        Player playerA1 = new Player("Gytis", 27, 1500, 11, 8, 4);
        Player playerA2 = new Player("Dovydas", 32, 1400, 10, 7, 5);
        Player playerA3 = new Player("Rokas", 30, 1300, 6, 9, 6);
        List<Player>playersA = new ArrayList<>();
        playersA.add(playerA1);
        playersA.add(playerA2);
        playersA.add(playerA3);


        Coach coachB = new Coach("Tomas", 28, 2600, 6);
        Player playerB1 = new Player("Lukas", 26, 2435, 13, 7, 3);
        Player playerB2 = new Player("Antonas", 30, 2104, 16, 9, 7);
        Player playerB3 = new Player("Petras", 24, 2315, 9, 12, 12);
        List<Player>playersB = new ArrayList<>();
        playersA.add(playerB1);
        playersA.add(playerB2);
        playersA.add(playerB3);

        Coach coachC = new Coach("A", 29, 2345, 7);
        Player playerC1 = new Player("S", 25, 2435, 14, 8, 5);
        Player playerC2 = new Player("F", 30, 2104, 16, 9, 7);
        Player playerC3 = new Player("G", 24, 2315, 9, 12, 12);
        List<Player>playersC = new ArrayList<>();
        playersA.add(playerC1);
        playersA.add(playerC2);
        playersA.add(playerC3);

        Coach coachD = new Coach("Q", 21, 1245, 8);
        Player playerD1 = new Player("R", 19, 2431, 13, 7, 5);
        Player playerD2 = new Player("T", 22, 2524, 9, 6, 7);
        Player playerD3 = new Player("U", 23, 2126, 6, 11, 12);
        List<Player>playersD = new ArrayList<>();
        playersA.add(playerD1);
        playersA.add(playerD2);
        playersA.add(playerD3);

        Team teamA = new Team("Zalgiris", coachA, playersA, 120.2, 7.7, 16.3, 20, 14);
        Team teamB = new Team("Rytas", coachB, playersB, 111.3, 6.3, 15.6, 16, 4);
        Team teamC = new Team("Lietkabelis", coachC, playersC, 113.3, 6.5, 14.2, 2, 5);
        Team teamD = new Team("Neptunas", coachD, playersD, 152.2, 6.7, 17.6, 15, 2);

        List<Team> teams = new ArrayList<>();
        teams.add(teamA);
        teams.add(teamB);
        teams.add(teamC);
        teams.add(teamD);

        StatsCalculator statsCalculator = new StatsCalculator();
        statsCalculator.compareTwoTeams(teamA,teamB);

//        statsCalculator.printStats(teams);
        statsCalculator.maxPoints(teams);
        statsCalculator.maxPlayerPoints(teams);



    }

}
