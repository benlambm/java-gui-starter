package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Instructions: these go green when Bow's three methods are done. If a
 * test dies with a NullPointerException instead of a tidy "expected but
 * was", shoot() is still returning its null placeholder.
 */
class BowTest {

    @Test
    void bowKnowsItsNameAndSound() {
        Bow bow = new Bow();
        assertEquals("Bow", bow.name());
        assertEquals("Twang!", bow.soundEffect());
    }

    @Test
    void bowHarvestsForFullPoints() {
        Bow bow = new Bow();
        ShotResult result = bow.shoot(new Deer(0, 0));
        assertEquals(10, result.points());
        assertTrue(result.animalRemoved());
    }

    @Test
    void bowMessageTellsTheStory() {
        Bow bow = new Bow();
        // Two species on purpose: the message must be BUILT, not typed.
        assertEquals("Twang! Deer harvested for 10 points.",
                bow.shoot(new Deer(0, 0)).message());
        assertEquals("Twang! Bear harvested for 50 points.",
                bow.shoot(new Bear(0, 0)).message());
    }
}
