package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CharacterStateTest {

    @Test
    public void arthurBecomesLimpAndHypnotized() {
        Character arthur = new Character("Arthur");
        AirborneRodent rodent = new AirborneRodent(true, 50.0);

        rodent.setInitialDistance(arthur, 10.0);
        rodent.hypnotize(arthur);

        assertEquals(MentalState.HYPNOTIZED, arthur.getMentalState());
        assertEquals(PhysicalState.LIMP, arthur.getPhysicalState());
        assertFalse(arthur.isAbleToMove());
    }

    @Test
    public void trillianBecomesDesperateInScene() {
        Scene scene = new Scene();

        assertEquals(MentalState.CALM, scene.getTrillian().getMentalState());
        scene.attemptEscape();
        assertEquals(MentalState.DESPERATE, scene.getTrillian().getMentalState());
    }
}

