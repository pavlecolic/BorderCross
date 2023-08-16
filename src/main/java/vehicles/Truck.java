package vehicles;

import java.util.Random;

public class Truck extends Vehicle{

    private boolean hasCustomsDeclaration;
    private final int declaredMass;
    private int realMass;
    private boolean hasLargerRealMass;

    public Truck() {
        super(3, "Truck");
        Random rand = new Random();
        this.hasCustomsDeclaration = rand.nextBoolean();
        this.declaredMass = rand.nextInt(6500);
        this.realMass = initializeRealMass();
    }

    private int initializeRealMass() {
        Random rand = new Random();
        boolean result = rand.nextDouble() < 0.2;
        if(result) {
            this.hasLargerRealMass = true;
            int maxValueIncrease = (int) (this.declaredMass * 0.3);
            int increase = (int)(Math.random() * (maxValueIncrease + 1));
            realMass = this.declaredMass + increase;
            return realMass;
        }
        return this.declaredMass;
    }

    public boolean isHasLargerRealMass() {
        return hasLargerRealMass;
    }

    public void setHasLargerRealMass(boolean hasLargerRealMass) {
        this.hasLargerRealMass = hasLargerRealMass;
    }

    public int getRealMass() {
        return realMass;
    }

    public void setRealMass(int realMass) {
        this.realMass = realMass;
    }

    public int getDeclaredMass() {
        return declaredMass;
    }

    public boolean isHasCustomsDeclaration() {
        return hasCustomsDeclaration;
    }

    public void setHasCustomsDeclaration(boolean hasCustomsDeclaration) {
        this.hasCustomsDeclaration = hasCustomsDeclaration;
    }
}
