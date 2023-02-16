package tdm.pml.BoatSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CargoTest {
    @Test
    public void testConstructor() {
        try{
            Cargo c = new Cargo(200, 100, 70, 350);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        Cargo cargo = new Cargo(200, 100, 70, 350);
        Cargo copyCargo = cargo.copy();
        assertEquals(350, copyCargo.getPrice(), 0.001);
    }

    @Test
    public void testRandomContractBonus() {
        Cargo c = new Cargo(200, 100, 70, 350);
        c.randomContractBonus();
        assertEquals(1, c.getContracts().size(), 0.001);
    }
}
