package domain;

import java.util.Arrays;
import java.util.List;

public class Scene {

    private final Character trillian;
    private final Character arthur;
    private final Character ford;
    private final Character zaphod;
    private final Door door;
    private final AirborneRodent threat;
    private final BodyPart arthursHand;

    public Scene() {
        this.trillian = new Character("Trillian");
        this.arthur = new Character("Arthur");
        this.ford = new Character("Ford");
        this.zaphod = new Character("Zaphod");

        this.door = new Door(DoorState.CLOSED);
        this.threat = new AirborneRodent(true, 50.0);

        this.arthursHand = new BodyPart(BodyPartType.HAND, arthur);
        arthur.addBodyPart(arthursHand);

        threat.setInitialDistance(arthur, 100.0);
    }

    public Character getTrillian() {
        return trillian;
    }

    public Character getArthur() {
        return arthur;
    }

    public Character getFord() {
        return ford;
    }

    public Character getZaphod() {
        return zaphod;
    }

    public Door getDoor() {
        return door;
    }

    public AirborneRodent getThreat() {
        return threat;
    }

    public BodyPart getArthursHand() {
        return arthursHand;
    }

    public void attemptEscape() {
        trillian.setMentalState(MentalState.DESPERATE);

        List<Character> targets = Arrays.asList(arthur, trillian, ford, zaphod);
        threat.approach(targets, 60.0);
        threat.hypnotize(arthur);

        trillian.grab(arthur, arthursHand);
        trillian.pull(arthur, door);

        ford.tryOpen(door);
        zaphod.tryOpen(door);
    }
}

