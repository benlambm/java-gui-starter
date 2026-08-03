package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Instructions: these go green when Hunter's three methods are done.
 * The middle test IS the strategy pattern: same hunter, same method
 * call, different behavior after the swap.
 */
class HunterTest {

    @Test
    void hunterStartsWithABow() {
        assertEquals("Bow", new Hunter().getBehaviorName());
    }

    @Test
    void swappingTheStrategyAtRuntimeChangesTheHunter() {
        Hunter hunter = new Hunter();
        hunter.setShootBehavior(new Camera());
        assertEquals("Camera", hunter.getBehaviorName());
    }

    @Test
    void hunterDelegatesTheShotToItsBehavior() {
        Hunter hunter = new Hunter(); // still carrying the default Bow
        ShotResult result = hunter.shootAt(new Deer(0, 0));
        assertEquals(10, result.points());
        assertTrue(result.animalRemoved());
    }
}
