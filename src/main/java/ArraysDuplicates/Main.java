package ArraysDuplicates;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        palyginimasArraysMax();
//        antraUzduotis();


        artimiausias(0,20,13);
        artimiausias(-10,2,13);
        artimiausias(8,15,13);
    }

    private static void antraUzduotis() {
        System.out.println("**************Antra uzduotis************");
        System.out.println("iveskite kiek skaiciu ivesite:");
        Scanner scanner = new Scanner(System.in);
        int skaicius = scanner.nextInt();
        int [] naujasMasyvas = new int[skaicius];
        for ( int i = 0; i < skaicius; i++) {
            int sk = 0;
            System.out.println("iveskite skaiciu :" );
            sk = scanner.nextInt();
            naujasMasyvas[i]=sk;
        }
        for (int naujasMasyva : naujasMasyvas) {
            System.out.println(naujasMasyva);
        }
        System.out.println("Max value of naujasMasyvas = " +  Arrays.stream(naujasMasyvas).max());

        System.out.println("********trecia uzduotis ***********");
    }

    private static void palyginimasArraysMax() {
        System.out.println("**************Pirma uzduotis************");
        int [] firstArray = {8,5,6,4,7,9};
        int [] secondArray = {3,5,7,1,4,2};
        for (int i = 0; i < firstArray.length; i++) {
            for (int x = 0; x < secondArray.length; x++) {

                if (secondArray[x] == firstArray[i]) {
                    System.out.println("yra: " + secondArray[x]);
                }
            }
        }
        System.out.println("max: " + Arrays.stream(secondArray).max());
    }

    public static void artimiausias (int firstNumber, int secondNumber, int nearNumber){


        if (Math.abs(nearNumber-firstNumber) < Math.abs(nearNumber-secondNumber)) {
            System.out.println("arciausiai " + nearNumber + " yra: " + firstNumber);
        }else {
            System.out.println("arciausiai " + nearNumber + " yra: " + secondNumber);

        }

    }
}
