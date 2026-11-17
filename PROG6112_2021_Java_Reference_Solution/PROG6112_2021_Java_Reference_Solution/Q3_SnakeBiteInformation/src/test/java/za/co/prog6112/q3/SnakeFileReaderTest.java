package za.co.prog6112.q3;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SnakeFileReaderTest {
    @Test void readsThreeSnakeRecordsFromSampleFile() throws Exception {
        List<SnakeInfo> snakes = new SnakeFileReader().loadSnakes(Path.of("snakes.txt"));
        assertEquals(3, snakes.size());
        assertEquals("Black Mamba", snakes.get(0).getType());
        assertEquals("Fatality Ranking: 7", snakes.get(0).getFatalityRanking());
        assertEquals("Medical Assistance: In 45 minutes", snakes.get(1).getMedicalAssistance());
        assertEquals("Puff Adder", snakes.get(2).getType());
    }
}
