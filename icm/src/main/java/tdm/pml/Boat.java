package tdm.pml;

import java.util.ArrayList;
import java.util.List;

public abstract class Boat implements TaskPerformer{
    private double maxWeightCapacity;
    private List<CrewMember> crew;
    private double factoryWeight;
    private List<Package> cargo;
    private double maxVolume;
    private double speed;
    private List<Contract> contracts;
    private int price;
    private TimeManager timeManager;
    
    /**
     * @param maxWeightCapacity
     * @param factoryWeight
     * @param maxVolume
     * @param price
     */
    public Boat(double maxWeightCapacity, double factoryWeight, double maxVolume, int price) {
        this.maxWeightCapacity = maxWeightCapacity;
        this.factoryWeight = factoryWeight;
        this.maxVolume = maxVolume;
        crew = new ArrayList<>();
        cargo = new ArrayList<>();
        contracts = new ArrayList<>();
        this.price = price;
        this.timeManager = null;
    }

    public double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }
    public void setMaxWeightCapacity(double maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }
    public List<CrewMember> getCrew() {
        return crew;
    }
    public void setCrew(List<CrewMember> crew) {
        this.crew = crew;
    }
    public void addCrewMember(CrewMember crewMember){
        this.crew.add(crewMember);
    }
    /**
     * Calculates and gets the total weigth of the boat
     * @return total weight of boat
     */
    public double getTotalWeight(){
        double totalWeight = 0;
        for (Package p : this.cargo){
            totalWeight += p.getWeight();
        }
        for (CrewMember cm : this.crew){
            totalWeight += cm.getWeight();
        }
        return totalWeight + this.factoryWeight;
    }
    public double getfactoryWeight() {
        return factoryWeight;
    }
    public void setfactoryWeight(double factoryWeight) {
        this.factoryWeight = factoryWeight;
    }
    public List<Package> getCargo() {
        return cargo;
    }
    public void setCargo(List<Package> cargo) {
        this.cargo = cargo;
    }
    public double getMaxVolume() {
        return maxVolume;
    }
    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public List<Contract> getContracts() {
        return contracts;
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }

    /**
     * Accepts and adds the contract to the boat if it has each crew member
     * @param contracts
     * @return whether the contract was added
     */
    public boolean setContract(Contract contracts) {
        if (hasAllCrewMembers()){
            this.contracts.add(contracts);
            contracts.acceptContract(this);
            timeManager = new TimeManager(this, 10*1000);
            timeManager.startTimer();
            return true;
        }
        return false;
    }

    /**
     * Adds a contract without any validation (only for the random contract bonus method)
     * @param contract
     */
    public void addContractIgnoreConditions(Contract contract){
        this.contracts.add(contract);
        contract.acceptContract(this);
    }

    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Checks if the boat has crew members of each type
     * @return whether the boat has crew members of each type
     */
    public boolean hasAllCrewMembers(){
        return hasCrewMember(CrewMemberType.CAPTAIN) &&
               hasCrewMember(CrewMemberType.ENGINEER) &&
               hasCrewMember(CrewMemberType.GUARD) &&
               hasCrewMember(CrewMemberType.STEVEDORE);
    }

    /**
     * Checks if the boat has crew members of the input type
     * @param type
     * @return whether the boat has crew members of the input type
     */
    public boolean hasCrewMember(CrewMemberType type){
        for (CrewMember c : this.crew){
            if (c.getType() == type){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Boat [cargo=" + cargo + ", contracts=" + contracts + ", crew=" + crew + ", factoryWeight="
                + factoryWeight + ", maxVolume=" + maxVolume + ", maxWeightCapacity=" + maxWeightCapacity + ", price="
                + price + ", speed=" + speed + "]";
    }

    public abstract Boat copy();

    public abstract String getName();

    public abstract void performTask();
    
}
