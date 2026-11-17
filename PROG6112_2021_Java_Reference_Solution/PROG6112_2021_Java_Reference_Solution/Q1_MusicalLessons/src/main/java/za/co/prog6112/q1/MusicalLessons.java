package za.co.prog6112.q1;

/** Holds lesson prices and calculations for instruments and musical levels. */
public class MusicalLessons {
    private final String[] instruments = {"Guitar", "Piano", "Violin"};
    private final String[] levels = {"Beginner", "Intermediate", "Advanced"};
    // Rows represent levels; columns represent Guitar, Piano and Violin.
    private final double[][] lessonCosts = {
        {150, 250, 280},
        {215, 232, 280},
        {130, 185, 310}
    };

    public String[] getInstruments() { return instruments.clone(); }
    public String[] getLevels() { return levels.clone(); }

    public double getLessonCost(String instrument, String level) {
        int instrumentIndex = indexOf(instruments, instrument);
        int levelIndex = indexOf(levels, level);
        if (instrumentIndex < 0 || levelIndex < 0) {
            throw new IllegalArgumentException("Select a valid instrument and musical level.");
        }
        return lessonCosts[levelIndex][instrumentIndex];
    }

    private int indexOf(String[] values, String target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(target)) return i;
        }
        return -1;
    }

    /** Calculates the average cost across all three instruments for one level. */
    public double averageCostForLevel(String level) {
        int levelIndex = indexOf(levels, level);
        if (levelIndex < 0) throw new IllegalArgumentException("Unknown musical level.");
        double total = 0;
        for (double cost : lessonCosts[levelIndex]) total += cost;
        return total / instruments.length;
    }

    public String createAverageReport() {
        StringBuilder report = new StringBuilder("Average lesson cost per musical level\n");
        for (String level : levels) {
            report.append(String.format("%s: R%.2f%n", level, averageCostForLevel(level)));
        }
        return report.toString();
    }
}
