package nba;

public class Player extends Person implements Comparable<Player>{

    private int pintsPerGame;
    private int assistsPerGame;
    private int reboundsPerGame;


    public Player(String name, int age, int salary, int pintsPerGame, int assistsPerGame, int reboundsPerGame) {
        super(name, age, salary);
        this.pintsPerGame = pintsPerGame;
        this.assistsPerGame = assistsPerGame;
        this.reboundsPerGame = reboundsPerGame;
    }

    public int getPintsPerGame() {
        return pintsPerGame;
    }

    public void setPintsPerGame(int pintsPerGame) {
        this.pintsPerGame = pintsPerGame;
    }

    public int getAssistsPerGame() {
        return assistsPerGame;
    }

    public void setAssistsPerGame(int assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public int getReboundsPerGame() {
        return reboundsPerGame;
    }

    public void setReboundsPerGame(int reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pintsPerGame=" + pintsPerGame +
                ", assistsPerGame=" + assistsPerGame +
                ", reboundsPerGame=" + reboundsPerGame +
                "} " + super.toString();
    }

    @Override
    public int compareTo(Player playerToCompare) {
        if (this.pintsPerGame == playerToCompare.getPintsPerGame()) {
            return 0;
        }else {
            return this.pintsPerGame > playerToCompare.getPintsPerGame() ? 1 : -1 ;
        }
    }
}
