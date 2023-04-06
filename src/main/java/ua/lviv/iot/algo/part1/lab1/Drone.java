package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Drone {
    private double currentSpeed;
    private double currentAltitude;
    public void flyAt(double speedMetersPerMinute, double altitude){
        this.currentSpeed = speedMetersPerMinute;
        this.currentAltitude = altitude;
    }

    public abstract double getMaxFlyingDistanceAtCurrentSpeed();
}