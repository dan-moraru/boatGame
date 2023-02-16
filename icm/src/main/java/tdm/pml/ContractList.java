package tdm.pml;

import java.util.ArrayList;
import java.util.List;

public class ContractList implements TaskPerformer{
    private List<Contract> availableContracts;
    private TimeManager timeManager;
    private BaseValueClass bvc;
    
    public ContractList(){
        this.bvc = new BaseValueClass();
        availableContracts = new ArrayList<>();
        bvc = new BaseValueClass();
        timeManager = new TimeManager(this, 10*1000);
        timeManager.startTimer();
    }

    /**
     * Adds a new contract to the list and removes the least recent contract if the amount of contracts exceed 6
     * @param contract
     */
    public void addContract(Contract contract){
        this.availableContracts.add(contract);
        if (availableContracts.size() > 6){
            removeLeastRecentContract();
        }
    }

    /**
     * Adds a random contract to the list
     */
    public void generateRandomContract(){
       addContract(bvc.getContract()); 
    }

    /**
     * The task is to add the random contract
     */
    @Override
    public void performTask() {
        generateRandomContract();
    }

    /**
     * Removes the least recent contract from the list
     */
    public void removeLeastRecentContract(){
        this.availableContracts.remove(0);
    }

    public List<Contract> getAvailableContracts(){
        return this.availableContracts;
    }
}
