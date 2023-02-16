package tdm.pml;

public class CrewMember {
    private CrewMemberType type;
    private String name;
    private double weight;
    private int yearsOfExp;
    private int pricePerTrip;

    /**
     * 
     * @param type
     * @param name
     * @param weight
     * @param yearsOfExp
     * @param pricePerTrip
     */
    public CrewMember(CrewMemberType type, String name, double weight, int yearsOfExp,int pricePerTrip) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.yearsOfExp = yearsOfExp;
        this.pricePerTrip = pricePerTrip;
    }
    public CrewMemberType getType() {
        return type;
    }
    public void setType(CrewMemberType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getYearsOfExp() {
        return yearsOfExp;
    }
    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }
    public int getPricePerTrip() {
        return pricePerTrip;
    }
    public void setPricePerTrip(int pricePerTrip) {
        this.pricePerTrip = pricePerTrip;
    }
    @Override
    public String toString() {
        return "CrewMember [name=" + name + ", pricePerTrip=" + pricePerTrip + ", type=" + type + ", weight=" + weight
                + ", yearsOfExp=" + yearsOfExp + "]";
    }
}
