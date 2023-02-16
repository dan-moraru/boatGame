package tdm.pml.PackageSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GasTankTest {
    @Test
    public void testConstructor() {
        try{
            GasTank gt = new GasTank(50, 30, 20, 350);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        GasTank gt = new GasTank(50, 30, 20, 350);
        GasTank copyGt = gt.copy();
        assertEquals(350, copyGt.getLength(), 0.001);
    }
}
