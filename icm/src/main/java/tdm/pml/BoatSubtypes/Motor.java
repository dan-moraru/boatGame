package tdm.pml.BoatSubtypes;

import java.util.Random;

import tdm.pml.Boat;
import tdm.pml.CrewMember;
import tdm.pml.CrewMemberType;

public class Motor extends Boat{

    /**
     * @param maxWeightCapacity
     * @param factoryWeigth
     * @param maxVolume
     * @param price
     */
    public Motor(double maxWeightCapacity, double factoryWeigth, double maxVolume, int price) {
        super(maxWeightCapacity, factoryWeigth, maxVolume, price);
    }
    public void addRandomCrewMember(){
        Random r = new Random();
        CrewMemberType type = CrewMemberType.CAPTAIN;
        int randType = r.nextInt(4) + 1;
        switch(randType){
            case 2:
                type = CrewMemberType.STEVEDORE;
                break;
            case 3:
                type = CrewMemberType.ENGINEER;
                break;
            case 4:
                type = CrewMemberType.GUARD;
                break;
        }
        int randWeight = r.nextInt(30) + 60;
        int randYearsOfExp = r.nextInt(6) + 1;
        int randPricePerTrip = r.nextInt(40) + 30;
        CrewMember c = new CrewMember(type, "Dave", randWeight, randYearsOfExp, randPricePerTrip);
        this.addCrewMember(c);
    }

    public Motor copy() {
        return new Motor(this.getMaxWeightCapacity(), this.getfactoryWeight(), this.getMaxVolume(), this.getPrice());
    }

    public String getName() {
        return "Motor";
    }

    @Override
    public void performTask() {
        this.addRandomCrewMember();
    }

}
