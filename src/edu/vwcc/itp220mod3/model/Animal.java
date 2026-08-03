package edu.vwcc.itp220mod3.model;

/**
 * The base class for every animal in the game.
 *
 * You met an abstract class in Module 2 (Person). Here the idea carries a
 * whole game: you can never write "new Animal(...)" -- only concrete
 * species like Deer, Duck, and Bear can be created. The abstract methods
 * below are a contract every subclass MUST fill in. That contract is what
 * lets Game hold a single List of Animal and treat every species the same
 * way (polymorphism) while each species behaves differently on screen
 * (dynamic dispatch). When the game runs, you literally WATCH
 * polymorphism happen: one move() call per frame, three different walks.
 *
 * Note: there are NO Swing or AWT imports in this file, and there never
 * will be. Model classes are pure Java -- which is exactly why the tests
 * in test/ can run them without opening a window.
 */
public abstract class Animal {

    /**
     * World bounds, shared by every species. An animal that walks off one
     * edge re-enters from the other (see Deer.move for the worked
     * example). The window is 860 px wide; -60 is far enough off-screen
     * that a re-entering animal doesn't pop into view mid-body.
     */
    public static final double WORLD_WIDTH = 860;
    public static final double OFFSCREEN_LEFT = -60;

    // private final: set once in the constructor, read-only forever.
    private final String name;
    private final double speed; // pixels per second

    // Position changes every frame, so these are not final. Subclasses
    // reach them through the protected setters below.
    private double x;
    private double y;

    // The Camera strategy marks animals it has photographed so the same
    // deer can't be farmed for points twice. See Camera.java.
    private boolean photographed = false;

    /**
     * protected: only subclasses call this, via super(...), as the first
     * line of their own constructors. Look at Deer's constructor to see
     * the pattern.
     */
    protected Animal(String name, double x, double y, double speed) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    /**
     * Advance this animal's position by dt seconds. Every species moves
     * in its own way -- that is the whole point of the hierarchy. Called
     * about 60 times per second while the game runs.
     *
     * @param dt time elapsed since the last frame, in seconds
     */
    public abstract void move(double dt);

    /** How many points this animal is worth. Each species decides. */
    public abstract int getPoints();

    /**
     * Shared behavior lives in the base class: hit detection is the same
     * circle test for every species, so it is written once, here, and
     * inherited by all. (Distance formula, squared on both sides so we
     * never need Math.sqrt.)
     *
     * @return true if the point (clickX, clickY) is within radius pixels
     *         of this animal's position
     */
    public boolean isHit(double clickX, double clickY, double radius) {
        double dx = clickX - x;
        double dy = clickY - y;
        return (dx * dx + dy * dy) <= radius * radius;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isPhotographed() {
        return photographed;
    }

    /** Called by the Camera strategy; there is no way to un-photograph. */
    public void markPhotographed() {
        this.photographed = true;
    }

    /** Subclasses use these from inside their own move() logic. */
    protected void setX(double x) {
        this.x = x;
    }

    protected void setY(double y) {
        this.y = y;
    }
}
