package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Drone {
    private double currentSpeed;
    private double currentAtlitude;
    public void flyAt(double speedMetersPerMinute, double alltitude){
        this.currentSpeed = speedMetersPerMinute;
        this.currentAtlitude = alltitude;
    }

    public abstract double getMaxFlyingDistanceAtCurrentSpeed();
}