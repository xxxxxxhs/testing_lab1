package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {

    private final String name;
    private PhysicalState physicalState = PhysicalState.NORMAL;
    private MentalState mentalState = MentalState.CALM;
    private final List<BodyPart> bodyParts = new ArrayList<>();
    private Object location;

    public Character(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public PhysicalState getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(PhysicalState physicalState) {
        this.physicalState = physicalState;
    }

    public MentalState getMentalState() {
        return mentalState;
    }

    public void setMentalState(MentalState mentalState) {
        this.mentalState = mentalState;
    }

    public boolean isAbleToMove() {
        return physicalState == PhysicalState.NORMAL;
    }

    public void addBodyPart(BodyPart bodyPart) {
        bodyParts.add(bodyPart);
    }

    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public void grab(Character other, BodyPart bodyPart) {
        if (!bodyPart.getOwner().equals(other)) {
            throw new IllegalArgumentException("Body part does not belong to target character");
        }
        bodyPart.setHeldBy(this);
    }

    public void pull(Character target, Object to) {
        target.location = to;
    }

    public boolean tryOpen(Door door) {
        if (!isAbleToMove()) {
            return false;
        }
        return door.open();
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }
}

