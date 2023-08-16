package passenger;

import java.util.Random;
import exceptions.InvalidIDException;


public class Passenger {

    private String id;
    // alternativno, uvesti klasu Suitcase ??
    private boolean hasSuitcase;
    private boolean hasIllegalBaggage;


    public Passenger(String id) {
        try {
            if(id.length() == 13)
                this.id = id;
            else
                throw new InvalidIDException("BAD ID.");

        } catch (InvalidIDException e){
            e.printStackTrace();
        }

        Random rand = new Random();
        this.hasSuitcase = rand.nextDouble() < 0.7;
        if(this.hasSuitcase) {
            this.hasIllegalBaggage = rand.nextDouble() < 0.1;
        }
    }

    public String getId() {
        return id;
    }

    public boolean getHasSuticase() {
        return hasSuitcase;
    }

    public boolean getHasIllegalBaggage() {
        return hasIllegalBaggage;
    }

    @Override
    public String toString() {
        return "Passanger: " + id + " has suitcase? " + hasSuitcase + " baggage illegal? " + hasIllegalBaggage;
    }
}