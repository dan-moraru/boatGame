package tdm.pml.BoatSubtypes;

import java.util.Random;

import tdm.pml.Boat;

public class HoverCraft extends Boat{

    /**
     * @param maxWeightCapacity
     * @param factoryWeigth
     * @param maxVolume
     * @param price
     */
    public HoverCraft(double maxWeightCapacity, double factoryWeigth, double maxVolume, int price) {
        super(maxWeightCapacity, factoryWeigth, maxVolume, price);
    }
    
    /**
     * Increases the speed of the boat by 1 to 5 units
     */
    public void boostSpeed(){
        Random r = new Random();
        int speedBoost = r.nextInt(5)+1;
        this.getContracts().get(0).setTimeLeft(this.getContracts().get(0).getTimeLeft() - speedBoost);
        this.setSpeed(this.getSpeed() + speedBoost);
    }

    /**
     * Creates a new copy of the current object
     * @return a new copy of the HoverCraft
     */
    public HoverCraft copy() {
        return new HoverCraft(this.getMaxWeightCapacity(), this.getfactoryWeight(), this.getMaxVolume(), this.getPrice());
    }

    public String getName() {
        return "HoverCraft";
    }

    
    /**
     * The task is to increase the movement speed
     */
    @Override
    public void performTask() {
        this.boostSpeed();
    }
}
