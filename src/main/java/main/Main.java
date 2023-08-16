package main;

import vehicles.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static int numOfBuses = 5;
    private static int numOfPersonalVehicles = 35;
    private static int numOfTrucks = 10;

    private static Object[] column = new Object[50];
    private static Random rand = new Random();

    private static void initializeColumn() {
        int index;
        int counterBuses = numOfBuses;
        int counterPersonalVehicles = numOfPersonalVehicles;
        int counterTrucks = numOfTrucks;


        while (counterBuses > 0) {
            index = Main.rand.nextInt(50);
            if (Main.column[index] == null) {
                column[index] = new Bus();
                counterBuses--;
            }
        }

        while (counterTrucks > 0) {
            index = Main.rand.nextInt(50);
            if (Main.column[index] == null) {
                column[index] = new Truck();
                counterTrucks--;
            }
        }

        for (int i = 0; i < Main.column.length; i++) {
            if (column[i] == null) {
                column[i] = new PersonalVehicle();
            }
        }
    }
    private static void printColumn() {
        for(Object o : column){
            System.out.println(o);
            System.out.println();
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        Main.initializeColumn();
//        Main.printColumn();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.get(0));
        arrayList.remove(0);
        System.out.println(arrayList.get(0));
    }
}
