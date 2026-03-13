package domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThreatTest {

    // TODO добавить тест где уходим в минус
    // TODO сделать тесты более гранулярными - одно действие

    @Test
    public void rodentsApproachCharacters() {
        Character arthur = new Character("Arthur");
        AirborneRodent rodent = new AirborneRodent(true, 50.0);

        rodent.setInitialDistance(arthur, 100.0);
        rodent.approach(Collections.singletonList(arthur), 30.0);

        assertEquals(70.0, rodent.getDistanceTo(arthur));
    }

    @Test
    public void hypnotizeOnlyWithinRange() {
        Character arthur = new Character("Arthur");
        AirborneRodent rodent = new AirborneRodent(true, 50.0);

        rodent.setInitialDistance(arthur, 100.0);
        rodent.hypnotize(arthur);

        assertNotEquals(MentalState.HYPNOTIZED, arthur.getMentalState());

        rodent.approach(Collections.singletonList(arthur), 60.0);
        rodent.hypnotize(arthur);

        assertEquals(MentalState.HYPNOTIZED, arthur.getMentalState());
        assertEquals(PhysicalState.LIMP, arthur.getPhysicalState());
    }
}

