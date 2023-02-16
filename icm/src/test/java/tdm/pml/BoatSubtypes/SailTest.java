package tdm.pml.BoatSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SailTest {
    @Test
    public void testConstructor() {
        try{
            Sail sail = new Sail(200, 100, 70, 350);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        Sail sail = new Sail(200, 100, 70, 350);
        Sail copySail = sail.copy();
        assertEquals(350, copySail.getPrice(), 0.001);
    }
}
