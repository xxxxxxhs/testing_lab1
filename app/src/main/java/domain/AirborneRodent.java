package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirborneRodent {

    private final boolean canHypnotize;
    private final double hypnosisRange;
    private final Map<Character, Double> distanceToCharacters = new HashMap<>();

    public AirborneRodent(boolean canHypnotize, double hypnosisRange) {
        this.canHypnotize = canHypnotize;
        this.hypnosisRange = hypnosisRange;
    }

    public void setInitialDistance(Character character, double distance) {
        distanceToCharacters.put(character, distance);
    }

    public double getDistanceTo(Character character) {
        return distanceToCharacters.getOrDefault(character, Double.POSITIVE_INFINITY);
    }

    public void approach(List<Character> targets, double step) {
        for (Character target : targets) {
            distanceToCharacters.computeIfPresent(target, (c, d) -> Math.max(0, d - step));
        }
    }

    public void hypnotize(Character target) {
        if (!canHypnotize) {
            return;
        }
        double distance = getDistanceTo(target);
        if (distance <= hypnosisRange) {
            target.setMentalState(MentalState.HYPNOTIZED);
            target.setPhysicalState(PhysicalState.LIMP);
        }
    }
}

