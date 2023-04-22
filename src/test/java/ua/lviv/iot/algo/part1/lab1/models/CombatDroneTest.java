package ua.lviv.iot.algo.part1.lab1.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatDroneTest {
    CombatDrone testDrone;

    @BeforeEach
    public void setUp() {
        testDrone = new CombatDrone();
        testDrone.setMaxAmmo(10);
        testDrone.setCurrentAmmo(5);
    }

    @Test
    void testFireWithAmmo() {
        testDrone.fire();
        assertEquals(4, testDrone.getCurrentAmmo());
    }

    @Test
    void testFireWithoutAmmo() {
        testDrone.setCurrentAmmo(0);
        testDrone.fire();
        assertEquals(0, testDrone.getCurrentAmmo());
    }

    @Test
    void testReload() {
        testDrone.reload();
        assertEquals(10, testDrone.getCurrentAmmo());
    }
}