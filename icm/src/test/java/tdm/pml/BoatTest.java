package tdm.pml;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import tdm.pml.BoatSubtypes.Cargo;

public class BoatTest {
    private final float EPSILON = 0.001f;
    @Test
    public void testConstructor() {
        try{
            Boat boat = new Cargo(100, 50, 70, 200);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testAddCrewMember() {
        Boat boat = new Cargo(100, 50, 70, 200);
        CrewMemberType crewMemberType = CrewMemberType.CAPTAIN;
        CrewMember crewMember = new CrewMember(crewMemberType, "Bob", 80, 4, 20);
        boat.addCrewMember(crewMember);
        boat.getCrew();
        assertEquals(1, boat.getCrew().size(), EPSILON);
    }
}
