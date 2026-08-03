package edu.vwcc.itp220mod3.model;

/**
 * WORKED EXAMPLE -- this class is finished, and its tests are already
 * green on a fresh clone. Study it before you touch Duck or Bear.
 *
 * Notice how little code a subclass needs: the constructor passes fixed
 * choices up to super(...), and the two abstract methods get real bodies.
 * Duck and Bear follow this exact pattern -- but they must MOVE
 * differently, not just rename the deer.
 */
public class Deer extends Animal {

    public Deer(double x, double y) {
        super("Deer", x, y, 120); // a deer trots at 120 px/s
    }

    /**
     * Deer walk steadily to the right; off the right edge, they wrap
     * around and re-enter from the left. The wrap constants live in
     * Animal because every species shares the same world.
     */
    @Override
    public void move(double dt) {
        setX(getX() + getSpeed() * dt);
        if (getX() > WORLD_WIDTH) {
            setX(OFFSCREEN_LEFT);
        }
    }

    @Override
    public int getPoints() {
        return 10;
    }
}
