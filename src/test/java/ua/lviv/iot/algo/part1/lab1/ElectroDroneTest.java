package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectroDroneTest extends AbstractDroneTest {
    private ElectroDrone baseDrone;
    @BeforeEach
    public void setUp(){
        baseDrone = new ElectroDrone(8000,7000,700);
    }

    @Test
    public void testChargeBattery(){
        baseDrone.chargeBattery(1200);
        assertEquals(8000,baseDrone.getBatteryCapacity());
    }

    @Test
    public void testUseBattery(){
        ElectroDrone testDrone = new ElectroDrone(100,100,10);
        testDrone.useBattery(30);

        assertEquals(70, testDrone.getCurrentBatteryLevel());

        testDrone.useBattery(80);

        assertEquals(0, testDrone.getCurrentBatteryLevel());

        testDrone.useBattery(10);

        assertEquals(0, testDrone.getCurrentBatteryLevel());

    }

    @Test
    public void testGetMaxFlyingDistanceAtCurrentSpeed() {
        baseDrone.setCurrentSpeed(50);

        double actualDistance = baseDrone.getMaxFlyingDistanceAtCurrentSpeed();

        assertEquals(500, actualDistance);
    }

    @Test
    public void testFlyAt() {
        super.testFlyAt(baseDrone);
    }
}