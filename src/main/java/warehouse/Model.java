package warehouse;

public enum Model {
    JEEP(5,5,false),
    HONDA(6,6,false),
    JMC(4,4,false),
    DAEWOO(2,4,true),
    ACURA(2,2,true),
    VOLVO(5,12,false),
    AUDI(6,8,false),
    ASTON_MARTIN(4,9,false),
    BMW(4,10,false),
    BENTLEY(2,6.0,true),
    ANTS11(27, 9,10),
    FAB333(26,8,9),
    BAR8(25,7,8),
    T4(24,6,4),
    AIRBORNE(23,4,6);
 Model ( double wheelsInch, double weight, double maxPressure){
     this.inch = wheelsInch;
     this.weight = weight;
     this.pressure = maxPressure;
 }
 Model (int seats, double trunkVolume, boolean isCabriolet){
     this.seats = seats;
     this.volume = trunkVolume;
     this.isCabriolet = isCabriolet;
 }
    double inch;
    public double getInch(){return inch;}
    double weight;
    public double getWeight(){return weight;}
    double pressure;
    public double getPressure(){return pressure;}
    int seats;
    public  int getSeats(){return seats;}
    double volume;
    public double getVolume(){return volume;}
    boolean isCabriolet;
    public boolean isCabriolet (){return isCabriolet;}

}
