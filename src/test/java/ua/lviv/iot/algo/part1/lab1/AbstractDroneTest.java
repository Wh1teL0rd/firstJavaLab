package ua.lviv.iot.algo.part1.lab1;

import static org.junit.jupiter.api.Assertions.*;

class AbstractDroneTest {
    //Test
    public void testFlyAt(Drone drone) {
        drone.setCurrentSpeed(0);
        drone.setCurrentAltitude(0);

        double expectedSpeed = 10;
        double expectedAltitude = 100;
        drone.flyAt(expectedSpeed, expectedAltitude);
        assertEquals(expectedSpeed, drone.getCurrentSpeed());
        assertEquals(expectedAltitude, drone.getCurrentAltitude());
    }
}