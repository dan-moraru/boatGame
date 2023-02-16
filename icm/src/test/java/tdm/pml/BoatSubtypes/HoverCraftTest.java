package tdm.pml.BoatSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class HoverCraftTest {
    @Test
    public void testConstructor() {
        try{
            HoverCraft hc = new HoverCraft(200, 100, 70, 350);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        HoverCraft hc = new HoverCraft(200, 100, 70, 350);
        HoverCraft copyHc = hc.copy();
        assertEquals(350, copyHc.getPrice(), 0.001);
    }
}
