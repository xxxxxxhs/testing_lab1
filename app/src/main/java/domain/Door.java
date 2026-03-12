package domain;

public class Door {

    private DoorState state;

    public Door(DoorState initialState) {
        this.state = initialState;
    }

    public DoorState getState() {
        return state;
    }

    public boolean canBeOpened() {
        return state == DoorState.CLOSED;
    }

    public boolean open() {
        if (canBeOpened()) {
            state = DoorState.OPEN;
            return true;
        }
        return false;
    }
}

