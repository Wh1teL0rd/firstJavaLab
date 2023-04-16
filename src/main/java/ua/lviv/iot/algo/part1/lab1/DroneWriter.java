package ua.lviv.iot.algo.part1.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DroneWriter {
    public void writeToFile(List<Drone> drones, String fileName) throws IOException {
        if (drones == null || drones.isEmpty()) {
            return;
        }

        FileWriter writer = new FileWriter(fileName);
        Map<String, Boolean> headerMap = new HashMap<>();

        drones.sort(new Comparator<Drone>() {
            @Override
            public int compare(Drone d1, Drone d2) {
                return d1.getClass().getSimpleName().compareTo(d2.getClass().getSimpleName());
            }
        });

        for(Drone drone : drones){
            if(!headerMap.containsKey(drone.getClass().getSimpleName())){
                writer.write(drone.getHeaders() + "\n");
                headerMap.put(drone.getClass().getSimpleName(), true);
            }
            writer.write(drone.toCSV() + "\n");
        }

        writer.close();
    }
}
