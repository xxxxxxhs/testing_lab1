package domain;

import java.util.Objects;

public class BodyPart {

    private final BodyPartType type;
    private final Character owner;
    private Character heldBy;

    public BodyPart(BodyPartType type, Character owner) {
        this.type = Objects.requireNonNull(type);
        this.owner = Objects.requireNonNull(owner);
    }

    public BodyPartType getType() {
        return type;
    }

    public Character getOwner() {
        return owner;
    }

    public Character getHeldBy() {
        return heldBy;
    }

    void setHeldBy(Character heldBy) {
        this.heldBy = heldBy;
    }
}

