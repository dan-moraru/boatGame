package tdm.pml;

public abstract class Package implements TaskPerformer{
    private double weight;
    private double height;
    private double width;
    private double length;
    private Contract contract;
    private TimeManager timeManager;
    
    /**
     * 
     * @param weight
     * @param height
     * @param width
     * @param length
     */
    public Package(double weight, double height, double width, double length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.timeManager = null;
    }

    /**
     * Copy contrustor
     * @param p
     */
    public Package(Package p) {
        this(p.getWeight(), p.getHeight(), p.getWidth(), p.getLength());
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getVolume() {
        return this.length*this.height*this.width;
    }

    public abstract Package copy();

    public abstract void performTask();

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    /**
     * Starts the timer
     */
    public void startTimer(){
        timeManager = new TimeManager(this, 10*1000);
        timeManager.startTimer();
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }

    public void stopTimer(){
        this.timeManager.stopTimer();
    }
    
}
