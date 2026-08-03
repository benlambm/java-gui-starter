package edu.vwcc.itp220mod3.model;

/**
 * The bloodless instrument -- and the interesting one. A photograph
 * scores DOUBLE points and the animal keeps walking. But an animal only
 * poses once: photograph the same one again and you get nothing. (That
 * flag lives on Animal -- see isPhotographed / markPhotographed.)
 *
 * Instructions:
 * Implement all three methods.
 *
 *   name()        returns "Camera"
 *   soundEffect() returns "Click!"
 *   shoot(target) has two cases, in this order:
 *
 *     Already photographed?  ShotResult with 0 points, animalRemoved
 *     false, and message:
 *         target's name + " is camera-shy now. 0 points."
 *         e.g.  "Deer is camera-shy now. 0 points."
 *
 *     Fresh subject?  FIRST mark the target photographed, then return
 *     a ShotResult where:
 *       - points        = the target's points * 2
 *       - animalRemoved = false  (nobody dies for a photo)
 *       - message       = soundEffect() + " " + target's name +
 *                         " photographed for " + points + " points."
 *         e.g.  "Click! Deer photographed for 20 points."
 *
 * Why does Camera get to change the animal's state? Because that IS the
 * strategy's job: each instrument decides what a hit does to the target.
 * Bow removes it from the world; Camera just makes it shy.
 */
public class Camera implements ShootBehavior {

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
