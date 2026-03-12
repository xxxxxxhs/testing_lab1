package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SceneIntegrationTest {

    @Test
    public void fullEscapeScenario() {
        Scene scene = new Scene();

        assertEquals(PhysicalState.NORMAL, scene.getArthur().getPhysicalState());
        assertEquals(MentalState.CALM, scene.getArthur().getMentalState());

        scene.attemptEscape();

        assertEquals(MentalState.HYPNOTIZED, scene.getArthur().getMentalState());
        assertEquals(PhysicalState.LIMP, scene.getArthur().getPhysicalState());
        assertEquals(scene.getDoor(), scene.getArthur().getLocation());
        assertEquals(scene.getTrillian(), scene.getArthursHand().getHeldBy());
    }
}

