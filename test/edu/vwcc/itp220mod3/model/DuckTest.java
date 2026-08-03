package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: these four go green when Duck.move and Duck.getPoints
 * are implemented. The bob test computes its expected value with the
 * same formula your code must use -- if your y disagrees, re-read the
 * order of steps in Duck's Instructions.
 */
class DuckTest {

    @Test
    void duckFliesRightAtItsSpeed() {
        Duck duck = new Duck(100, 200);
        duck.move(1.0); // one full second at 180 px/s
        assertEquals(280, duck.getX(), 1e-9);
    }

    @Test
    void duckBobsOnASineWave() {
        Duck duck = new Duck(100, 200);
        duck.move(1.0); // x is now 280; y must be computed from it
        double expectedY = 200 + Duck.BOB_HEIGHT * Math.sin(280.0 / Duck.BOB_LENGTH);
        assertEquals(expectedY, duck.getY(), 1e-9);
    }

    @Test
    void duckWrapsAroundTheWorld() {
        Duck duck = new Duck(850, 200);
        duck.move(1.0); // 850 + 180 = 1030, way past the edge
        assertEquals(Animal.OFFSCREEN_LEFT, duck.getX(), 1e-9);
    }

    @Test
    void duckIsWorthTwentyFivePoints() {
        assertEquals(25, new Duck(0, 0).getPoints());
    }
}
