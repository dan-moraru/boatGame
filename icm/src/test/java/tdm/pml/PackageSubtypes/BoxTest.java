package tdm.pml.PackageSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BoxTest {
    @Test
    public void testConstructor() {
        try{
            Box box = new Box(50, 30, 20, 60);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        Box box = new Box(50, 30, 20, 60);
        Box copyBox = box.copy();
        assertEquals(60, copyBox.getLength(), 0.001);
    }
}
