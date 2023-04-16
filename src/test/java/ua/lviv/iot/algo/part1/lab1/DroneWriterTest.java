package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DroneWriterTest {

    public static final String RESULT_FILENAME = "src/main/resources/result.csv";
    public static final String EXPECTED_FILENAME = "src/main/resources/expectedSuccess.csv";

    private List<Drone> droneList;
    private DroneWriter droneWriter;
    private final File expectedFile = new File(EXPECTED_FILENAME);
    private File actualFile;

    @BeforeEach
    public void setUp(){
        droneList = new ArrayList<>();
        droneWriter = new DroneWriter();
        droneList.add(new ElectroDrone(1000, 500, 300));
        droneList.add(new PetrolDrone(300, "Gasoline", 150));
        droneList.add(new ElectroDrone(900, 800, 200));
        droneList.add(new PetrolDrone(250, "Kerosin", 130));
        actualFile = new File(RESULT_FILENAME);
    }

    @Test
    public void writeToFileSuccess() throws IOException {

        droneWriter.writeToFile(droneList, RESULT_FILENAME);

        assertTrue(Files.exists(actualFile.toPath()));
        assertEquals(Files.readAllLines(expectedFile.toPath()),
                Files.readAllLines(actualFile.toPath()));
    }

    @Test
    public void writeToFileEmptyList() throws IOException {
        droneList = new ArrayList<>();

        droneWriter.writeToFile(droneList, RESULT_FILENAME);

        assertFalse(actualFile.exists());
    }

    @Test
    public void writeToFileExistingFile() throws IOException {
        Files.createFile(Path.of(RESULT_FILENAME));
        writeToFileSuccess();
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(RESULT_FILENAME));
    }
}
