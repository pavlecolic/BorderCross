package vehicles;
import passenger.Passenger;
import java.util.*;
import myutils.*;

public abstract class Vehicle implements Runnable {

    private String vehicleID = "";
    private String vehicleType = "Unknown";
    private final int passengerCapacity;
    private int passengerCount;
    List<Passenger> passengerList;
    private static int counter = 0;

    public Vehicle(int passengerCapacity, String vehicleType) {
        this.passengerCapacity = passengerCapacity;
        this.vehicleType = vehicleType;
        this.vehicleID = vehicleType + counter;
        this.passengerCount = (new Random()).nextInt(passengerCapacity) + 1;
        passengerList = initializePassengers();
        ++counter;
    }

    public Vehicle(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        this.vehicleID = vehicleType + counter;
        this.passengerCount = (new Random()).nextInt(passengerCapacity) + 1;
        passengerList = initializePassengers();
        ++counter;
    }

    private List<Passenger> initializePassengers() {
        passengerList = new ArrayList<>();
        for(int i = 0; i < passengerCount; i++) {
            // osigurati jedinstvenost ID
            passengerList.add(new Passenger(Utils.generatePersonId()));
        }
        return passengerList;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public String toString() {
        return "Vehicle " + vehicleID + " of capacity: " + passengerCapacity + " has " + passengerCount + " passengers: " + formatPassengerList();
    }

    public String formatPassengerList() {
        String formatted = "";
        for(Passenger p  : passengerList){
            formatted +=  "\n" + p.toString();
        }
        return formatted;
    }

    @Override
    public void run() {
        System.out.println("RUNNING");
    }
}
