package compare;

public class Laptop implements Comparable<Laptop>{
    private String brand;
    private int price;
    private int ram;

    public Laptop(String brand, int price, int ram) {
        this.brand = brand;
        this.price = price;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }

    @Override
    public int compareTo(Laptop laptopToCompare) {
        //Jei pirmo objekto reiksme > antro - grazinam 1.
        //Jei < uz antro - grazinam minus 1.
        // Jei pirmas objekto fieldo reiksme == fieldo reiksmei - grazinam 0.
        if (this.price == laptopToCompare.getPrice()){
            return 0;
        } else {
            return this.price> laptopToCompare.getPrice() ? 1 : -1 ;
        }

    }
}
