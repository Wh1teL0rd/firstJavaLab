package ua.lviv.iot.algo.part1.lab1.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CombatDrone extends Drone {
    private double currentAmmo;
    private double maxAmmo;
    private double currentBatteryLevel;

    public void fire() {
        if (currentAmmo > 0) {
            currentAmmo--;
            System.out.println("Firing! Ammo left: " + currentAmmo);
        } else {
            System.out.println("Out of ammo. Reload!");
        }
    }

    public void reload() {
        currentAmmo = maxAmmo;
        System.out.println("Reloading. Ammo reloaded: " + maxAmmo);
    }

    @Override
    public double getMaxFlyingDistanceAtCurrentSpeed() {
        return this.currentBatteryLevel / 15 * this.getCurrentSpeed();
    }

    public String getHeaders() {
        return super.getHeaders() + ",currentAmmo,maxAmmo,currentBatteryLevel";
    }

    public String toCSV() {
        return super.toCSV() + "," + currentAmmo + "," + maxAmmo + "," + currentBatteryLevel;
    }
}
