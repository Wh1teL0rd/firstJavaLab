package ua.lviv.iot.algo.part1.lab1.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryDroneTest {
    DeliveryDrone testDrone;

    @BeforeEach
    public void setUp() {
        testDrone = new DeliveryDrone();
        testDrone.setMaxPayload(1000);
    }

    @Test
    void testLoadDroneWithinCapacity() {
        testDrone.loadDrone(500);
        assertEquals(500, testDrone.getCurrentPayload());
    }

    @Test
    void testLoadDroneExceedingCapacity() {
        testDrone.loadDrone(1500);
        assertEquals(1000, testDrone.getCurrentPayload());
    }
}
