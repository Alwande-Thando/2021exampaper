package za.co.prog6112.q3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/** Reads the sequential snakes.txt file, where each snake uses three lines. */
public class SnakeFileReader {
    public List<SnakeInfo> loadSnakes(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        List<SnakeInfo> snakes = new ArrayList<>();

        // Each record consists of snake name, fatality ranking and medical assistance timing.
        for (int i = 0; i + 2 < lines.size(); i += 3) {
            String type = lines.get(i).trim();
            String ranking = lines.get(i + 1).trim();
            String assistance = lines.get(i + 2).trim();
            if (!type.isEmpty()) snakes.add(new SnakeInfo(type, ranking, assistance));
        }
        return snakes;
    }
}
