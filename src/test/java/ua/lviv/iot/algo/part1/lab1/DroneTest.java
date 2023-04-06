package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneTest {
    @Test
    public void testFlyAt() {
        Drone drone = new ElectroDrone();
        drone.setCurrentSpeed(0);
        drone.setCurrentAltitude(0);

        double speed = 10.0;
        double altitude = 100.0;
        drone.flyAt(speed, altitude);
        assertEquals(speed, drone.getCurrentSpeed());
        assertEquals(altitude, drone.getCurrentAltitude());
    }
}