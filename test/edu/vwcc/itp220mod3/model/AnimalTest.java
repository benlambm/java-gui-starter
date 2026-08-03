package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Instructions: nothing to do here -- isHit is provided in Animal, so
 * these are GREEN on a fresh clone. They exist as your compass: this is
 * what a passing test looks like, and this is the hit circle the whole
 * game runs on.
 */
class AnimalTest {

    @Test
    void aClickInsideTheRadiusHits() {
        Deer deer = new Deer(400, 300);
        assertTrue(deer.isHit(410, 310, 40));
    }

    @Test
    void aClickOutsideTheRadiusMisses() {
        Deer deer = new Deer(400, 300);
        assertFalse(deer.isHit(500, 300, 40));
    }

    @Test
    void aClickExactlyOnTheEdgeStillHits() {
        Deer deer = new Deer(400, 300);
        // 40 pixels straight right: distance == radius, and <= says yes.
        assertTrue(deer.isHit(440, 300, 40));
    }
}
