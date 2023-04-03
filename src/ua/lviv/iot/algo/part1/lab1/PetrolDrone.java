package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PetrolDrone extends Drone {
    private double tankCapacity;
    private String typeOfFuel;
    private double fuelConsumptionPerHour;
    @Override
    public double getMaxFlyingDistanceAtCurrentSpeed() {
        return this.tankCapacity / this.fuelConsumptionPerHour*this.getCurrentSpeed();
    }
}
