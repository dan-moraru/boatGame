package tdm.pml.BoatSubtypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import tdm.pml.CrewMember;
import tdm.pml.CrewMemberType;

public class MotorTest {
    @Test
    public void testConstructor() {
        try{
            Motor motor = new Motor(200, 100, 70, 350);
        }
        catch (IllegalArgumentException e){
            fail("Constructor failed");
        }
        assertTrue(true);
    }

    @Test
    public void testAddRandomCrewMember() {
        Motor motor = new Motor(200, 100, 70, 350);
        CrewMember c = new CrewMember(CrewMemberType.STEVEDORE, "Dave", 90, 2, 20);
        motor.addCrewMember(c);
        assertEquals(1, motor.getCrew().size(), 0.001);
    }

    @Test
    public void testCopy() {
        Motor motor = new Motor(200, 100, 70, 350);
        Motor copyMotor = motor.copy();
        assertEquals(350, copyMotor.getPrice(), 0.001);
    }
}
