package edu.vwcc.itp220mod3.model;

/**
 * NEW CONCEPT -- the STRATEGY pattern.
 *
 * The question this interface answers: what happens when the hunter
 * pulls the trigger? With a Bow, the animal is harvested and leaves the
 * field. With a Camera, it gets its picture taken and keeps walking.
 * Two completely different outcomes for the same click.
 *
 * The beginner move is an if-statement inside Hunter:
 *
 *     if (mode.equals("bow")) { ... } else if (mode.equals("camera")) { ... }
 *
 * That works until the third instrument arrives, and the fourth, and the
 * if-chain grows forever inside a class that shouldn't care. The strategy
 * pattern flips it: each way-of-shooting becomes its OWN CLASS
 * implementing this interface, and Hunter just holds "whichever one is
 * currently selected" without knowing or caring which it is.
 *
 * You met interfaces in Module 2 (Modality: InPerson / VirtualSync /
 * OnlineAsync describe themselves differently). Strategy is the same
 * mechanism with one upgrade: the game SWAPS the object at runtime.
 * Click the Camera button mid-game and every later shot behaves
 * differently -- no if-statement anywhere, just a different object
 * answering the same method call. Watch for it in HunterTest: that swap
 * is the whole pattern in one test.
 *
 * Nothing to implement in this file -- the interface IS the design.
 * Your work is in Bow.java and Camera.java.
 */
public interface ShootBehavior {

    /** The instrument's display name: "Bow", "Camera", ... */
    String name();

    /** The noise it makes: "Twang!", "Click!", ... */
    String soundEffect();

    /**
     * The instrument does its thing to the target and reports what
     * happened. This is the strategy's one real job.
     *
     * @param target the animal that was hit
     * @return what happened: points scored, whether the animal leaves
     *         the field, and a message for the player
     */
    ShotResult shoot(Animal target);
}
