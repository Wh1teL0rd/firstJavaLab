package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DroneManagerTest {
    private DroneManager droneManager;

    @BeforeEach
    public void setUp() {
        droneManager = new DroneManager();
        List<Drone> drones = new ArrayList<>();
        drones.add(new ElectroDrone(8000,7000,900));
        drones.add(new ElectroDrone(9600,9000,1000));
        drones.add(new PetrolDrone(20,"Benzin",2));
        droneManager.addDrones(drones);
        droneManager.getDroneList().get(0).flyAt(40,250);
        droneManager.getDroneList().get(1).flyAt(35,110);
        droneManager.getDroneList().get(2).flyAt(25,280);
    }

    @Test
    void testAddDrone() {
        ElectroDrone newDrone = new ElectroDrone(8000, 7000, 900);
        droneManager.addDrone(newDrone);
        assertTrue(droneManager.getDroneList().contains(newDrone));
    }

    @Test
    void testAddDrones() {
        ElectroDrone testDrone = new ElectroDrone(180,30,20);
        droneManager.addDrones(Arrays.asList(testDrone));
        assertTrue(droneManager.getDroneList().contains(testDrone));
    }

    @Test
    void testFindAltitudeBiggerThan() {
        List<Drone> drones = droneManager.findAltitudeBiggerThan(50);
        assertEquals(3, drones.size());
        assertTrue(drones.stream().allMatch(drone -> drone.getCurrentAltitude() > 50));
    }

    @Test
    void testFindAltitudeBiggerThanHigherThanAllDrones() {
        List<Drone> drones = droneManager.findAltitudeBiggerThan(300);
        assertEquals(0, drones.size());
    }

    @Test
    void testFindSpeedBiggerThan() {
        List<Drone> drones = droneManager.findSpeedBiggerThan(10);
        assertEquals(3, drones.size());
        assertTrue(drones.stream().allMatch(drone -> drone.getCurrentSpeed() > 10));
    }

    @Test
    void testFindSpeedBiggerThanHigherThanAllDrones() {
        List<Drone> drones = droneManager.findSpeedBiggerThan(100);
        assertEquals(0, drones.size());
    }
}
