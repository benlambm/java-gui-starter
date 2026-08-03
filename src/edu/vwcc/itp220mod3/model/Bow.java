package edu.vwcc.itp220mod3.model;

/**
 * The classic instrument: the animal is harvested, leaves the field,
 * and scores its face-value points.
 *
 * Instructions:
 * Implement all three methods.
 *
 *   name()        returns "Bow"
 *   soundEffect() returns "Twang!"
 *   shoot(target) returns a ShotResult where:
 *     - points        = the target's own points (ask the animal!)
 *     - animalRemoved = true  (the bow is permanent)
 *     - message       = soundEffect() + " " + the target's name +
 *                       " harvested for " + points + " points."
 *
 *       e.g.  "Twang! Deer harvested for 10 points."
 *
 * Build the message from soundEffect() and the target's getters -- do
 * not hard-code "Deer". BowTest fires at more than one species.
 */
public class Bow implements ShootBehavior {

    @Override
    public String name() {
        // TODO: your code goes here
        return "";
    }

    @Override
    public String soundEffect() {
        // TODO: your code goes here
        return "";
    }

    @Override
    public ShotResult shoot(Animal target) {
        // TODO: your code goes here
        return null;
    }
}
