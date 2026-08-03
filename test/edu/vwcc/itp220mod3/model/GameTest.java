package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: the finale -- these go green when Game.update and
 * Game.shoot are done, and they exercise everything underneath: the
 * hierarchy moves, the strategies score, the hunter delegates. These
 * tests play the game with no window open; that is the payoff of
 * keeping Swing out of the model.
 */
class GameTest {

    @Test
    void updateMovesEveryAnimalItsOwnWay() {
        Game game = new Game();
        game.addAnimal(new Deer(100, 300)); // 120 px/s right
        game.addAnimal(new Duck(50, 150));  // 180 px/s right
        game.update(1.0);
        assertEquals(220, game.getAnimals().get(0).getX(), 1e-9);
        assertEquals(230, game.getAnimals().get(1).getX(), 1e-9);
    }

    @Test
    void aBowShotScoresAndRemovesTheAnimal() {
        Game game = new Game();
        game.addAnimal(new Deer(400, 300));
        ShotResult result = game.shoot(400, 300); // dead center
        assertEquals(10, result.points());
        assertEquals(10, game.getScore());
        assertEquals(0, game.getAnimals().size());
    }

    @Test
    void aCameraShotScoresDoubleAndSparesTheAnimal() {
        Game game = new Game();
        game.addAnimal(new Deer(400, 300));
        game.getHunter().setShootBehavior(new Camera());
        game.shoot(400, 300);
        assertEquals(20, game.getScore());
        assertEquals(1, game.getAnimals().size()); // still walking
    }

    @Test
    void aClickOnEmptySkyIsAMiss() {
        Game game = new Game();
        game.addAnimal(new Deer(400, 300));
        ShotResult result = game.shoot(600, 100); // nowhere near
        assertEquals("Miss!", result.message());
        assertEquals(0, game.getScore());
        assertEquals(1, game.getAnimals().size());
    }

    @Test
    void aClickJustOutsideTheHitRadiusIsAMissToo() {
        Game game = new Game();
        game.addAnimal(new Deer(400, 300));
        // HIT_RADIUS is 40; this click is 41 away. Close only counts
        // in horseshoes.
        ShotResult result = game.shoot(441, 300);
        assertEquals("Miss!", result.message());
    }
}
