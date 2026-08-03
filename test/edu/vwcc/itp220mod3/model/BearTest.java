package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: these three go green when Bear.move and Bear.getPoints
 * are implemented. Direction matters -- a bear that gains x is a deer
 * in a bear suit, and the first test will say so.
 */
class BearTest {

    @Test
    void bearLumbersLeft() {
        Bear bear = new Bear(700, 320);
        bear.move(1.0); // one full second at 60 px/s, leftward
        assertEquals(640, bear.getX(), 1e-9);
    }

    @Test
    void bearWrapsToTheRightSide() {
        Bear bear = new Bear(-50, 320);
        bear.move(1.0); // -50 - 60 = -110, past OFFSCREEN_LEFT at -60
        assertEquals(Animal.WORLD_WIDTH, bear.getX(), 1e-9);
    }

    @Test
    void bearIsWorthFiftyPoints() {
        assertEquals(50, new Bear(0, 0).getPoints());
    }
}
