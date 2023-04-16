package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Drone {
    private double currentSpeed;
    private double currentAltitude;
    public void flyAt(double speedMetersPerMinute, double altitude) {
        this.currentSpeed = speedMetersPerMinute;
        this.currentAltitude = altitude;
    }

    public String getHeaders(){
        return "currentSpeed, currentAltitude";
    }

    public String toCSV(){
        return String.format("%.1f,%.1f",currentSpeed,currentAltitude);
    }

    public abstract double getMaxFlyingDistanceAtCurrentSpeed();
}
