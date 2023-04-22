package ua.lviv.iot.algo.part1.lab1.writers;

import ua.lviv.iot.algo.part1.lab1.models.Drone;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DroneWriter {
    public void writeToFile(List<Drone> drones, String fileName) throws IOException {
        if (drones == null || drones.isEmpty()) {
            return;
        }

        FileWriter writer = new FileWriter(fileName);
        Set<String> writtenHeaders = new HashSet<>();

        drones.sort(Comparator.comparing(d -> d.getClass().getSimpleName()));

        for (Drone drone : drones) {
            if (!writtenHeaders.contains(drone.getClass().getSimpleName())) {
                writer.write(drone.getHeaders() + "\n");
                writtenHeaders.add(drone.getClass().getSimpleName());
            }
            writer.write(drone.toCSV() + "\n");
        }

        writer.close();
    }
}
