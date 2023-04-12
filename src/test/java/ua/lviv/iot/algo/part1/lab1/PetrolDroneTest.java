package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetrolDroneTest extends AbstractDroneTest {
    private PetrolDrone baseDrone;
    @BeforeEach
    public void setUp(){
        baseDrone = new PetrolDrone(100,"Benzin", 10);
        baseDrone.setTypeOfFuel("Kerosin");
        baseDrone.setTankCapacity(200);
        baseDrone.setFuelConsumptionPerHour(20);
    }

    @Test
    public void testGetMaxFlyingDistanceAtCurrentSpeed() {
        baseDrone.setCurrentSpeed(50.0);
        baseDrone.setFuelConsumptionPerHour(20);
        assertEquals(500, baseDrone.getMaxFlyingDistanceAtCurrentSpeed()); // using delta to account for floating point errors
    }

    @Test
    public void testFlyAt() {
        super.testFlyAt(baseDrone);
    }
}