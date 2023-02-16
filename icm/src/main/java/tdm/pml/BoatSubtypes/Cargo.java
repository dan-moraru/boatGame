package tdm.pml.BoatSubtypes;

import java.util.Random;

import tdm.pml.BaseValueClass;
import tdm.pml.Boat;
import tdm.pml.Contract;

public class Cargo extends Boat {

    /**
     * @param maxWeightCapacity
     * @param factoryWeigth
     * @param maxVolume
     * @param price
     */
    public Cargo(double maxWeightCapacity, double factoryWeigth, double maxVolume, int price) {
        super(maxWeightCapacity, factoryWeigth, maxVolume, price);
    }

    /**
     * Adds a random contract to the boat with a 30% chance
     */
    public void randomContractBonus(){
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;
        if (randNum < 30){
            BaseValueClass bvc = new BaseValueClass();
            Contract bonusC = bvc.getContract();
            this.addContractIgnoreConditions(bonusC);
        }   
    }

    /**
     * Returns a new copy of the current object
     */
    public Cargo copy() {
        return new Cargo(this.getMaxWeightCapacity(), this.getfactoryWeight(), this.getMaxVolume(), this.getPrice());
    }

    public String getName() {
        return "Cargo";
    }  

    /**
     * The task is to add a random contract
     */
    @Override
    public void performTask() {
        this.randomContractBonus();
    }
    
}