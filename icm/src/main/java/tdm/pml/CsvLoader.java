package tdm.pml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import tdm.pml.BoatSubtypes.Cargo;
import tdm.pml.BoatSubtypes.HoverCraft;
import tdm.pml.BoatSubtypes.Motor;
import tdm.pml.BoatSubtypes.Sail;
import tdm.pml.PackageSubtypes.Box;
import tdm.pml.PackageSubtypes.GasTank;
import tdm.pml.PackageSubtypes.Jewelry;
import tdm.pml.PackageSubtypes.Vault;

public class CsvLoader implements DataLoader{

    /**
     * Reads the boats.csv file and creates 4 boat objects from the values
     * @return list of created boats
     */
    @Override
    public List<Boat> loadBoats() {
        try{
            Path p = Paths.get("dataCSV\\boats.csv");
            List<Boat> boats = new ArrayList<>();
            List<String> lines = Files.readAllLines(p);
            for (String line : lines){
                convertLineToBoat(boats, line);
            }
            return boats;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method that creates 4 objects from a line
     * @param boats
     * @param line
     */
    public void convertLineToBoat(List<Boat> boats, String line){
        String[] values = line.split(",");
        if (values[0].equals("Sail")){
            Boat boat = new Sail(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]));
            boats.add(boat);
        } else if (values[0].equals("Motor")){
            Boat boat = new Motor(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]));
            boats.add(boat);
        } else if (values[0].equals("Cargo")){
            Boat boat = new Cargo(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]));
            boats.add(boat);
        } else if (values[0].equals("Hovercraft")){
            Boat boat = new HoverCraft(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]));
            boats.add(boat);
        } else {
            System.out.println("Wrong boat subtype");
        }
    }
    /**
     * Reads the packages.csv file and creates 4 package objects from the values
     * @return list of created packages
     */
    @Override
    public List<Package> loadPackages() {
        try{
            Path p = Paths.get("dataCSV\\packages.csv");
            List<Package> packages = new ArrayList<>();
            List<String> lines = Files.readAllLines(p);
            for (String line : lines){
                converteLineToPackage(packages, line);
            }
            return packages;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method that creates 4 objects from a line
     * @param packages
     * @param line
     */
    public void converteLineToPackage(List<Package> packages, String line){
        String[] values = line.split(",");
        if (values[0].equals("Jewelry")){
            Package package1 = new Jewelry(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
            packages.add(package1);
        } else if (values[0].equals("Box")){
            Package package1 = new Box(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
            packages.add(package1);
        } else if (values[0].equals("Vault")){
            Package package1 = new Vault(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
            packages.add(package1);
        } else if (values[0].equals("Gas Tank")){
            Package package1 = new GasTank(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
            packages.add(package1);
        } else {
            System.out.println("Wrong package subtype");
        }
    }

    /**
     * Reads the crewMembers.csv file and creates 4 crew member objects from the values
     * @return list of created crew members
     */
    @Override
    public List<CrewMember> loadCrewMembers() {
        try{
            Path p = Paths.get("dataCSV\\crewMembers.csv");
            List<CrewMember> crew = new ArrayList<>();
            List<String> lines = Files.readAllLines(p);
            for (String line : lines){
                converteLineToCrewMember(crew, line);
            }
            return crew;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method that creates 4 objects from a line
     * @param crew
     * @param line
     */
    public void converteLineToCrewMember(List<CrewMember> crew, String line){
        String[] values = line.split(",");
        if (values[0].equals("Captain")){
            //make yofexp random
            CrewMember crewMember = new CrewMember(CrewMemberType.CAPTAIN, "Marko", Double.parseDouble(values[1]), 6, Integer.parseInt(values[3]));
            crew.add(crewMember);
        } else if (values[0].equals("Engineer")){
            CrewMember crewMember = new CrewMember(CrewMemberType.ENGINEER, "Bobby", Double.parseDouble(values[1]), 5, Integer.parseInt(values[3]));
            crew.add(crewMember);
        } else if (values[0].equals("Guard")){
            CrewMember crewMember = new CrewMember(CrewMemberType.GUARD, "Dan", Double.parseDouble(values[1]), 4, Integer.parseInt(values[3]));
            crew.add(crewMember);
        } else if (values[0].equals("Stevedore")){
            CrewMember crewMember = new CrewMember(CrewMemberType.STEVEDORE, "Thomas", Double.parseDouble(values[1]), 4, Integer.parseInt(values[3]));
            crew.add(crewMember);
        } else {
            System.out.println("Wrong crew member subtype");
        }
    }

    /**
     * Reads the contracts.csv file and creates 4 contract objects from the values
     * @return list of created contracts
     */
    @Override
    public List<Contract> loadContracts() {
        try{
            Path c= Paths.get("dataCSV\\contracts.csv");
            List<Contract> contracts = new ArrayList<>();
            List<String> lines = Files.readAllLines(c);
            for (String line : lines){
                converteLineToContract(contracts, line);
            }
            return contracts;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    } 

    /**
     * Helper method that creates 4 objects from a line
     * @param contracts
     * @param line
     */
    public void converteLineToContract(List<Contract> contracts, String line){
        String[] values = line.split(",");
        if (values[0].equals("Short Term")){
            //make yofexp random
            Contract contract = new Contract(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[2]), "10", "short");
            contracts.add(contract);
        } else if (values[0].equals("Long Term")){
            Contract contract = new Contract(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[2]), "20", "long");
            contracts.add(contract);
        } else if (values[0].equals("Special")){
            Contract contract = new Contract(Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[2]), "30", "special");
            contracts.add(contract);
        } else {
            System.out.println("Wrong contract subtype");
        }
    }
}
