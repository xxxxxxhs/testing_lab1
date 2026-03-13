package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {

    // TODO проверить когда OPEN

    @Test
    public void closedDoorCanBeOpened() {
        Door door = new Door(DoorState.CLOSED);
        assertTrue(door.canBeOpened());
        assertTrue(door.open());
        assertEquals(DoorState.OPEN, door.getState());
    }

    @Test
    public void lockedDoorCannotBeOpened() {
        Door door = new Door(DoorState.LOCKED);
        assertFalse(door.canBeOpened());
        assertFalse(door.open());
        assertEquals(DoorState.LOCKED, door.getState());
    }

    @Test
    public void arthurCannotOpenDoorWhenLimp() {
        Character arthur = new Character("Arthur");
        Door door = new Door(DoorState.CLOSED);

        arthur.setPhysicalState(PhysicalState.LIMP);
        boolean result = arthur.tryOpen(door);

        assertFalse(result);
        assertEquals(DoorState.CLOSED, door.getState());
    }
}

