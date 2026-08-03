package edu.vwcc.itp220mod3.model;

/**
 * A duck: fast, small, and it BOBS -- its y position rides a sine wave
 * while it flies right, so it is genuinely harder to click than a deer.
 * Worth 25 points for exactly that reason.
 *
 * Instructions:
 * Implement move(dt) and getPoints(). The constructor is done for you --
 * note how it remembers spawnY, the altitude the duck bobs around.
 *
 * move(dt), in exactly this order:
 *   1. Advance x by speed * dt (same as Deer -- ducks fly right).
 *   2. Wrap: if x is past WORLD_WIDTH, set it to OFFSCREEN_LEFT.
 *   3. Recompute y from the FINAL x:
 *
 *        y = spawnY + BOB_HEIGHT * Math.sin(x / BOB_LENGTH)
 *
 * Step 3 is why the duck bobs: y is not "pushed" each frame, it is
 * CALCULATED from how far the duck has flown. Same input, same output --
 * which is exactly what makes it easy to unit test.
 *
 * getPoints() returns 25.
 */
public class Duck extends Animal {

    /** How far above/below spawnY the duck bobs, in pixels. */
    public static final double BOB_HEIGHT = 40;
    /** How stretched the wave is: bigger = lazier bobbing. */
    public static final double BOB_LENGTH = 50;

    private final double spawnY;

    public Duck(double x, double y) {
        super("Duck", x, y, 180); // ducks fly at 180 px/s
        this.spawnY = y;
    }

    @Override
    public void move(double dt) {
        // TODO: your code goes here
    }

    @Override
    public int getPoints() {
        // TODO: your code goes here
        return 0;
    }
}
