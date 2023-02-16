package tdm.pml.PackageSubtypes;

import java.util.Random;

import tdm.pml.Contract;
import tdm.pml.Package;

public class Jewelry extends Package{
    public Jewelry(double weight, double height, double width, double length) {
        super(weight, height, width, length);
    }

    public void getStolen(){
        Random r = new Random();
        int randNum = r.nextInt(100)+1;
        if (randNum < 30){
            this.getContract().getCargo().remove(this);
        }
    }
    
    //@Override
    public Jewelry copy(){
        return new Jewelry(this.getWeight(), this.getHeight(), this.getWidth(), this.getLength());
    }

    public String getName() {
        return "Jewelry";
    }

    @Override
    public void performTask() {
        this.getStolen();
    }
    
}
