package tdm.pml;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseValueClass {
    private Random random;
    private List<Boat> boats;
    private List<CrewMember> crew;
    private List<Contract> contracts;
    private List<Package> packages;

    public BaseValueClass() {
        DataLoader csv = new CsvLoader();
        this.boats = csv.loadBoats();
        this.crew = csv.loadCrewMembers();
        this.contracts = csv.loadContracts();
        this.packages = csv.loadPackages();
        this.random = new Random();
    }

    public Boat getBoat(int index) {
        return boats.get(index).copy();
    }

    /**
     * Gets a copy list of all the boats
     * @return the copy of all boats
     */
    public List<Boat> getBoats() {
        List<Boat> l = new ArrayList<>();
        for (int i = 0; i < this.boats.size(); i++) {
            l.add(boats.get(i).copy());
        }
        return l;
    }

    public void setBoats(List<Boat> boats) {
        this.boats = boats;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewMember> crew) {
        this.crew = crew;
    }

    /**
     * Gets a random contract with 3 random packages
     * @return the random contract
     */
    public Contract getContract() {
        Contract copyContract = contracts.get(random.nextInt(contracts.size()));
        Contract contract = new Contract(copyContract);
        for (int i = 0; i < 3; i++){
            contract.addPackage(getPackage());
        }
        contract.setPayment(copyContract.getPayment()*(1 + (1.2 - 0.8) * random.nextDouble()));
        return contract;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * Gets a random package
     * @return the random package
     */
    public Package getPackage() {
        Package copyPackage = packages.get(random.nextInt(packages.size()));
        Package pack = copyPackage.copy();
        pack.setWeight(copyPackage.getWeight()*(3 + (1.2 - 0.8) * random.nextDouble()));
        return pack;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }  
}
