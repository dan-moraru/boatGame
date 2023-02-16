package tdm.pml;

import java.util.ArrayList;
import java.util.List;

/**
 * All the fields and methods are static because it would make sure that all across the program
 * we only have 1 instance of the player class
 */
public class Player {
    private static List<Boat> boats = new ArrayList<>();    
    private static List<Contract> acceptedContracts = new ArrayList<>();
    private static double money = 750;

    public static List<Boat> getBoats() {
        return boats;
    }
    public static List<Contract> getAcceptedContracts() {
        return acceptedContracts;
    }

    /**
     * Adds a boat to the player's boats is he has enough money to buy
     * @param boat
     * @return
     */
    public static boolean addBoat(Boat boat){
        if (hasEnoughMoney(boat.getPrice())){
            boats.add(boat);
            setMoney(money - boat.getPrice());
            return true;
        }
        return false;
    }

    /**
     * Adds a crew members to all of the player's boats if he has enough money to hire
     * @param crewMember
     */
    public static void addCrewMember(CrewMember crewMember){
        if (hasEnoughMoney(crewMember.getPricePerTrip()) && boats.size() > 0){
            for (Boat b : boats){
                b.addCrewMember(crewMember);
            }
            setMoney(money - crewMember.getPricePerTrip());
        }
    }

    public static void addContract(Contract contract){
        acceptedContracts.add(contract);
    }

    public static double getMoney(){
        return Math.round(money*100)/100;
    }

    public static void setMoney(double m){
        if (m >= 0){
            money = m;
        }
        
    }

    /**
     * Checks if the player has enough money
     * @param m
     * @return whether the player has enough money
     */
    public static boolean hasEnoughMoney(double m){
        return money >= m;
    }
}
