package tdm.pml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tdm.pml.BoatSubtypes.Cargo;

public class PlayerTest {
    @Test
    public void testAddBoat() {
        Boat b = new Cargo(5, 5, 5, 5);
        Player p = new Player();
        p.addBoat(b);
        assertEquals(1, p.getBoats().size(), 0.001);
    }

    @Test
    public void testAddContract() {
        Contract c = new Contract(5, 5, 5, "Monday", "short");
        Player p = new Player();
        p.addContract(c);
        assertEquals(1, p.getAcceptedContracts().size(), 0.001);
    }
}
