package edu.vwcc.itp220mod3.model;

/**
 * A bear: slow, heavy, and it walks the OTHER way. Worth the most points
 * because at 60 px/s it is on screen the longest -- and because a bear
 * photographed with the Camera strategy is worth a small fortune.
 *
 * Instructions:
 * Implement move(dt) and getPoints(). The constructor is done for you.
 *
 * move(dt):
 *   1. Bears lumber LEFT: subtract speed * dt from x.
 *   2. Wrap the other direction: if x has gone below OFFSCREEN_LEFT,
 *      set it to WORLD_WIDTH so the bear re-enters from the right.
 *
 * Compare this wrap with Deer's before you write it -- same idea,
 * mirrored. If your bear moonwalks right, you copied the deer too
 * literally.
 *
 * getPoints() returns 50.
 */
public class Bear extends Animal {

    public Bear(double x, double y) {
        super("Bear", x, y, 60); // bears lumber at 60 px/s
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
