package tdm.pml.PackageSubtypes;

import tdm.pml.Package;
import java.util.Random;

public class Vault extends Package{
    /**
     * @param weight
     * @param height
     * @param width
     * @param length
     */
    public Vault(double weight, double height, double width, double length) {
        super(weight, height, width, length);
    }

    /**
     * Has a 30% chance of getting stolen, which removes the package from the boat
     * @param contract
     */
    public void getStolen(){
        Random r = new Random();
        int randNum = r.nextInt(100)+1;
        this.getContract().setPayment(this.getContract().getPayment() - (this.getContract().getPayment() * randNum*0.01));
    }

    /**
     * Creates a new copy of the current object
     * @return a new copy of Vault
     */
    public Vault copy() {
        return new Vault(this.getWeight(), this.getHeight(), this.getWidth(), this.getLength());
    }

    public String getName() {
        return "Vault";
    }


    /**
     * The task is to get stolen
     */
    @Override
    public void performTask() {
        this.getStolen();
    }
}