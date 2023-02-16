package tdm.pml.BoatSubtypes;

import java.util.Random;

import tdm.pml.Boat;

public class Sail extends Boat{

    /**
     * @param maxWeightCapacity
     * @param factoryWeight
     * @param maxVolume
     * @param price
     */
    public Sail(double maxWeightCapacity, double factoryWeight, double maxVolume, int price) {
        super(maxWeightCapacity, factoryWeight, maxVolume, price);
    }
    
    /**
     * Catches a random number of fish and adds that amount to the total payment
     */
    public void catchFish(){
        Random r = new Random();
        double numOfFish = r.nextDouble()+5;
        this.getContracts().get(0).setPayment(this.getContracts().get(0).getPayment() + numOfFish);
    }
    
    /**
     * Creates a new copy of the current object
     * @return copy of Sail
     */
    public Sail copy() {
        return new Sail(this.getMaxWeightCapacity(), this.getfactoryWeight(), this.getMaxVolume(), this.getPrice());
    }

    public String getName() {
        return "Sail";
    }

    /**
     * The task is to catch fish
     */
    @Override
    public void performTask() {
        this.catchFish();
    }
}
