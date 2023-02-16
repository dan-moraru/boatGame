package tdm.pml.PackageSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JewelryTest {
    @Test
    public void testConstructor() {
        try{
            Jewelry j = new Jewelry(50, 30, 20, 60);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        Jewelry j = new Jewelry(50, 30, 20, 60);
        Jewelry copyJ = j.copy();
        assertEquals(60, copyJ.getLength(), 0.001);
    }
}
