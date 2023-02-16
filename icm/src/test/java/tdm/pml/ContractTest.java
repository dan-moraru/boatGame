package tdm.pml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import tdm.pml.PackageSubtypes.Vault;

public class ContractTest {
    @Test
    public void testConstructor() {
        try{
            Contract c = new Contract(5, 5, 5, "Monday", "short");
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testAddPackage(){
        Contract c = new Contract(5, 5, 5, "Monday", "short");
        Package p = new Vault(5, 5, 5, 5);
        c.addPackage(p);
        assertEquals(1, c.getCargo().size(), 0.001);
    }
}
