package za.co.prog6112.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MusicalLessonsTest {
    private final MusicalLessons lessons = new MusicalLessons();

    @Test void guitarBeginnerCostIs150() {
        assertEquals(150, lessons.getLessonCost("Guitar", "Beginner"), 0.001);
    }

    @Test void pianoIntermediateCostIs232() {
        assertEquals(232, lessons.getLessonCost("Piano", "Intermediate"), 0.001);
    }

    @Test void violinAdvancedCostIs310() {
        assertEquals(310, lessons.getLessonCost("Violin", "Advanced"), 0.001);
    }

    @Test void beginnerAverageIsCorrect() {
        assertEquals((150 + 250 + 280) / 3.0,
                lessons.averageCostForLevel("Beginner"), 0.001);
    }
}
