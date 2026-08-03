package edu.vwcc.itp220mod3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * One game session: the animals in the field, the hunter, the score.
 * This is where the hierarchy and the strategy finally meet -- and it
 * still has no Swing in it, which is why GameTest can play a whole
 * round without a window.
 *
 * Instructions:
 * Implement update(dt) and shoot(clickX, clickY). Everything else is
 * done for you.
 */
public class Game {

    /**
     * A click counts as a hit if it lands within this many pixels of an
     * animal's center. Bigger than the drawn body on purpose -- clicking
     * a moving duck is hard enough.
     */
    public static final double HIT_RADIUS = 40;

    private final List<Animal> animals = new ArrayList<>();
    private final Hunter hunter = new Hunter();
    private int score = 0;

    /** The opening lineup. Called once by the window, not by tests. */
    public void spawnStartingAnimals() {
        addAnimal(new Deer(100, 380));
        addAnimal(new Deer(420, 430));
        addAnimal(new Duck(60, 140));
        addAnimal(new Duck(300, 200));
        addAnimal(new Bear(760, 320));
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * A defensive COPY, same lesson as Section's collections in
     * Module 2: outsiders may look at the lineup but only this class
     * may change it.
     */
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public Hunter getHunter() {
        return hunter;
    }

    public int getScore() {
        return score;
    }

    /**
     * One tick of the world: EVERY animal advances by dt seconds.
     *
     * Instructions:
     * Loop over the animals field and call move(dt) on each one. Note
     * what you are NOT doing: no instanceof, no "if it's a duck".
     * You call one method on the superclass type and each species does
     * its own thing. Three lines, and one of them is a brace.
     */
    public void update(double dt) {
        // TODO: your code goes here
    }

    /**
     * The player clicked at (clickX, clickY). Find out what that means.
     *
     * Instructions:
     * Walk the animals list BY INDEX (you may need to remove the animal
     * at that index). For the FIRST animal where isHit(clickX, clickY,
     * HIT_RADIUS) is true:
     *
     *   1. Hand it to the hunter: result = hunter.shootAt(that animal)
     *   2. Add result.points() to the score.
     *   3. If result.animalRemoved(), remove that animal from the list.
     *   4. Return the result. (Only the first animal hit -- one click,
     *      one shot, so return from inside the loop.)
     *
     * If the loop finishes with no hit, the click was a miss: return
     *
     *   new ShotResult(0, false, "Miss!")
     *
     * @return what happened, for the window to display
     */
    public ShotResult shoot(double clickX, double clickY) {
        // TODO: your code goes here
        return null;
    }
}
