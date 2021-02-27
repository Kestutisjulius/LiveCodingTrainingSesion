package nba;


import java.util.Collections;
import java.util.List;

public class StatsCalculator {


    public void compareTwoTeams(Team teamA, Team teamB) {
        if (teamA.getPpg() > teamB.getPpg()) {
            System.out.println(teamA.getName() + "turi daugiau tasku nei :" + teamB.getName() + " taskais: " + (teamA.getPpg() - teamB.getPpg()));
        } else {
            System.out.println(teamB.getName() + "turi daugiau tasku nei :" + teamA.getName() + " taskais: " + (teamB.getPpg() - teamA.getPpg()));
        }
    }


    public void printStats(List<Team> teams) {
        for (Team team : teams) {
            System.out.println(team);
        }

    }

    public void maxPoints(List<Team> teams) {
        Collections.sort(teams);
        System.out.println(teams);
    }

    public void maxPlayerPoints(List<Team> teams) {

        for (Team team : teams) {
            Player player = Collections.max(team.getPlayers());

            System.out.println(player);
        }
    }

}
        



