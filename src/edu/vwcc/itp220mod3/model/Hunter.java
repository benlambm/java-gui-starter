package edu.vwcc.itp220mod3.model;

/**
 * The CONTEXT of the strategy pattern: the hunter carries exactly one
 * instrument at a time and doesn't know or care which one it is. All
 * the hunter can see is the ShootBehavior interface.
 *
 * There is deliberately no if-statement in this file and no mention of
 * Bow or Camera below the field's starting value. If you find yourself
 * writing "if the behavior is a camera..." -- stop. Delegation is the
 * entire job: forward the call, return the answer.
 *
 * Instructions:
 * Implement the three methods.
 *
 *   setShootBehavior(behavior)  stores the given behavior in the field.
 *       One line -- but it is THE line of Module 3: the GUI's Camera
 *       button calls this mid-game, and every shot after it behaves
 *       differently. Swapping an object at runtime is the whole
 *       strategy pattern.
 *
 *   getBehaviorName()  asks the current behavior for its name() and
 *       returns it. (The window shows this in the corner.)
 *
 *   shootAt(target)  delegates to the current behavior's shoot(target)
 *       and returns whatever it returns.
 */
public class Hunter {

    // Every hunter starts armed with a Bow. The type of the FIELD is the
    // interface -- that is what makes the swap possible.
    private ShootBehavior behavior = new Bow();

    public void setShootBehavior(ShootBehavior behavior) {
        // TODO: your code goes here
    }

    public String getBehaviorName() {
        // TODO: your code goes here
        return "";
    }

    public ShotResult shootAt(Animal target) {
        // TODO: your code goes here
        return null;
    }
}
