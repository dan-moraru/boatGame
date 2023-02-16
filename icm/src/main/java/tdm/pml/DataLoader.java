package tdm.pml;

import java.util.List;

/**
 * Interface that holds all the methods to load the boats, packages, crew members and contracts
 */
public interface DataLoader {
    public List<Boat> loadBoats();
    public List<Package> loadPackages();
    public List<CrewMember> loadCrewMembers();
    public List<Contract> loadContracts();
}
