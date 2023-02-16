package tdm.pml;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import javafx.scene.shape.Box;
import tdm.pml.PackageSubtypes.Vault;

public class PackageTest {
    @Test
    public void testConstructor() {
        try{
            Package p = new Vault(5, 5, 5, 5);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }
}
