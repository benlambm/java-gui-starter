package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: nothing to do here either -- Deer is the worked example,
 * finished in src/. These are green on a fresh clone. When you write
 * Duck and Bear, this file shows you what their tests expect of yours.
 */
class DeerTest {

    @Test
    void deerTrotsRightAtItsSpeed() {
        Deer deer = new Deer(100, 300);
        deer.move(1.0); // one full second at 120 px/s
        assertEquals(220, deer.getX(), 1e-9);
        assertEquals(300, deer.getY(), 1e-9); // deer don't bob
    }

    @Test
    void deerWrapsAroundTheWorld() {
        Deer deer = new Deer(850, 300);
        deer.move(1.0); // 850 + 120 = 970, past the edge at 860
        assertEquals(Animal.OFFSCREEN_LEFT, deer.getX(), 1e-9);
    }

    @Test
    void deerIsWorthTenPoints() {
        assertEquals(10, new Deer(0, 0).getPoints());
    }
}
