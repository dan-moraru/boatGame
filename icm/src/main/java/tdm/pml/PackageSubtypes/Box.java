package tdm.pml.PackageSubtypes;

import tdm.pml.Package;
import java.util.Random;

public class Box extends Package {
    /**
     * @param weight
     * @param height
     * @param width
     * @param length
     */
    public Box(double weight, double height, double width, double length) {
        super(weight, height, width, length);
    }

    /**
     * Destroys this package with a certain chance and reduces the payment if destroyed
     */
    public void destroyPackage(){
        Random r = new Random();
        int randNum = r.nextInt(100)+1;
        this.getContract().setPayment(this.getContract().getPayment() - (this.getContract().getPayment() * randNum*0.01));
    }

    /**
     * Creates a new copy of the current object
     * @return a new copy of Box
     */
    public Box copy(){
        return new Box(this.getWeight(), this.getHeight(), this.getWidth(), this.getLength());
    }

    public String getName() {
        return "Box";
    }

    /**
     * The task is to destroy the package
     */
    @Override
    public void performTask() {
        this.destroyPackage();
    }
}