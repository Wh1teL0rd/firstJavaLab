package ua.lviv.iot.algo.part1.lab1.managers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.lviv.iot.algo.part1.lab1.models.Drone;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Getter
public class DroneManager {
    private List<Drone> droneList = new ArrayList<>();

    public void addDrone(Drone newDrone) {
        this.droneList.add(newDrone);
    }

    public void addDrones(List<Drone> drones) {
        this.droneList.addAll(drones);
    }

    public List<Drone> findAltitudeBiggerThan(double altitude) {
        return droneList.stream().filter(drone -> drone.getCurrentAltitude() > altitude).toList();
    }

    public List<Drone> findSpeedBiggerThan(double speed) {
        return droneList.stream().filter(drone -> drone.getCurrentSpeed() > speed).toList();
    }

}
