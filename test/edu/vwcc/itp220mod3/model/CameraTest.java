package edu.vwcc.itp220mod3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Instructions: these go green when Camera's three methods are done.
 * The second-photo test is the one that catches a missing
 * markPhotographed call -- order matters in shoot().
 */
class CameraTest {

    @Test
    void cameraKnowsItsNameAndSound() {
        Camera camera = new Camera();
        assertEquals("Camera", camera.name());
        assertEquals("Click!", camera.soundEffect());
    }

    @Test
    void firstPhotoScoresDoubleAndSparesTheAnimal() {
        Camera camera = new Camera();
        Deer deer = new Deer(0, 0);
        ShotResult result = camera.shoot(deer);
        assertEquals(20, result.points()); // 10 * 2
        assertFalse(result.animalRemoved());
        assertTrue(deer.isPhotographed());
    }

    @Test
    void secondPhotoOfTheSameAnimalScoresNothing() {
        Camera camera = new Camera();
        Deer deer = new Deer(0, 0);
        camera.shoot(deer);
        ShotResult second = camera.shoot(deer);
        assertEquals(0, second.points());
        assertFalse(second.animalRemoved());
    }

    @Test
    void cameraMessagesTellTheStory() {
        Camera camera = new Camera();
        Bear bear = new Bear(0, 0);
        assertEquals("Click! Bear photographed for 100 points.",
                camera.shoot(bear).message());
        assertEquals("Bear is camera-shy now. 0 points.",
                camera.shoot(bear).message());
    }
}
