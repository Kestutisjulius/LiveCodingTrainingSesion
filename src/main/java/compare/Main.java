package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("HP", 15, 256));
        laptops.add(new Laptop("Acer", 10, 256));
        laptops.add(new Laptop("Mac", 100, 256));
        laptops.add(new Laptop("Lenovo", 25, 256));

//        Collections.sort(laptops);
//        Collections.max(laptops);
//        Collections.min(laptops);  //su streams veikia puikiai.. coollections streams
        Collections.sort(laptops);
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        System.out.println("brangiausias " + Collections.max(laptops));
        //galima iteruot su streamu.




    }
}
