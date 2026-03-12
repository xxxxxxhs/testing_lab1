package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InteractionTest {

    @Test
    public void trillianGrabsArthursHand() {
        Scene scene = new Scene();

        Character trillian = scene.getTrillian();
        Character arthur = scene.getArthur();
        BodyPart hand = scene.getArthursHand();

        trillian.grab(arthur, hand);

        assertEquals(trillian, hand.getHeldBy());
    }

    @Test
    public void trillianPullsArthurToDoor() {
        Scene scene = new Scene();

        Character trillian = scene.getTrillian();
        Character arthur = scene.getArthur();
        Door door = scene.getDoor();

        trillian.pull(arthur, door);

        assertEquals(door, arthur.getLocation());
    }
}

