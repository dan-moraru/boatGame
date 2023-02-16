package tdm.pml.PackageSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class VaultTest {
    @Test
    public void testConstructor() {
        try{
            Vault v = new Vault(50, 30, 20, 60);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testCopy() {
        Vault v = new Vault(50, 30, 20, 60);
        Vault copyV = v.copy();
        assertEquals(60, copyV.getLength(), 0.001);
    }
}
