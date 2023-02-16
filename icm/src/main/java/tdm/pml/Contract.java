package tdm.pml;

import java.util.*;

public class Contract implements TaskPerformer{
    private List<Package> cargo;
    private double payment;
    private double duration;
    private double timeLeft;
    private String expiry;
    private String type;
    private TimeManager timeManager;
    private Boat boat;
    
    /**
     * 
     * @param payment
     * @param duration
     * @param timeLeft
     * @param expiry
     * @param type
     */
    public Contract(double payment, double duration, double timeLeft, String expiry, String type) {
        this.payment = payment;
        this.duration = duration;
        this.timeLeft = timeLeft;
        this.expiry = expiry;
        this.type = type;
        this.timeManager = new TimeManager(this, 1000);
        cargo = new ArrayList<>();
    }
    /**
     * Copy contructor
     * @param contract
     */
    public Contract(Contract contract) {
        this(contract.getPayment(), contract.getDuration(), contract.getTimeLeft(), contract.getExpiry(), contract.getType());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Accepts a contract and starts the time for each package
     * @param b
     */
    public void acceptContract(Boat b){
        this.timeManager.startTimer();
        for (Package p : this.getCargo()){
            p.startTimer();
        }
        this.boat = b;
    }

    public List<Package> getCargo(){
        return this.cargo;
    }

    /**
     * Adds a package to the cargo and sets the contract of the package to this object
     * @param p
     */
    public void addPackage(Package p) {
        this.cargo.add(p);
        p.setContract(this);
    }

    /**
     * Gets the total weight of the packages that the contract has
     * @return the total weigth
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        if (this.cargo != null) {
            for (Package p : this.cargo) {
                totalWeight += p.getWeight();
            }
        }
        return totalWeight;
    } 

    public double getPayment() {
        return this.payment;
    }

    public double getDuration() {
        return this.duration;
    }

    public double getTimeLeft() {
        return this.timeLeft;
    }

    public String getExpiry() {
        return this.expiry;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setTimeLeft(double timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "Contract [cargo=" + cargo + ", payment=" + payment + ", duration=" + duration + ", timeLeft=" + timeLeft
                + ", expiry=" + expiry + "]";
    }

    /**
     * Reduces the time left and checks the completion of the contract
     * When the contract completes, the payment is added to his balance and all timers are stopped 
     */
    @Override
    public void performTask() {
        this.timeLeft -= 1;
        if (this.timeLeft <= 0) {
            Player.setMoney(Player.getMoney() + this.payment);
            this.boat.getContracts().remove(this);
            this.timeManager.stopTimer();
            for (Package p : this.getCargo()){
                p.stopTimer();
            }
            if (this.timeManager != null) {
                this.boat.getTimeManager().stopTimer();
                this.timeManager = null;
            }
            this.boat = null;

        }
    }
}
