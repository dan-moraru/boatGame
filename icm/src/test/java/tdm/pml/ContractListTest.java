package tdm.pml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ContractListTest {
    @Test
    public void testAddContract() {
        Contract c = new Contract(5, 5, 5, "Monday", "short");
        ContractList cl = new ContractList();
        cl.addContract(c);
        assertEquals(1, cl.getAvailableContracts().size(), 0.001);
    }

    @Test
    public void testGenerateRandomContract() {
        Contract c = new Contract(5, 5, 5, "Monday", "short");
        ContractList cl = new ContractList();
        BaseValueClass bvc = new BaseValueClass();
        cl.generateRandomContract();
        assertEquals(1, cl.getAvailableContracts().size(), 0.001);
    }

    @Test
    public void testPerformTask() {
        Contract c = new Contract(5, 5, 5, "Monday", "short");
        ContractList cl = new ContractList();
        BaseValueClass bvc = new BaseValueClass();
        cl.performTask();
        assertEquals(1, cl.getAvailableContracts().size(), 0.001);
    }

    @Test
    public void testRemoveLeastRecentContract() {
        try{
            ContractList cl = new ContractList();
            cl.removeLeastRecentContract();
            fail("Can't remove empty array");
        }
        catch (IndexOutOfBoundsException e){

        }
    }
}
