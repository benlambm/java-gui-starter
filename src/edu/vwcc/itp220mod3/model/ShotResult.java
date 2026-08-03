package edu.vwcc.itp220mod3.model;

/**
 * A record, exactly like MeetingTime in Module 2: a small immutable
 * value that exists to carry data from one place to another. Every
 * ShootBehavior returns one of these; Game reads it to update the score,
 * and the window reads it to show the message.
 *
 * Free of charge, records give you the constructor and the accessors:
 * result.points(), result.animalRemoved(), result.message().
 *
 * Nothing to implement in this file.
 *
 * @param points        points the shot scored (0 for a miss)
 * @param animalRemoved true if the animal leaves the field
 * @param message       one line for the player, e.g.
 *                      "Twang! Deer harvested for 10 points."
 */
public record ShotResult(int points, boolean animalRemoved, String message) {
}
