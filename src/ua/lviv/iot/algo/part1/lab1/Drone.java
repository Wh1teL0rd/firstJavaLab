package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Drone {
    private double currentSpeed;
    private double currentAltitude;
    private double batteryCapacity;
    private double currentBatteryLevel;
    private static Drone instance;

    public static Drone getInstance() {
        if(instance == null) {
            instance = new Drone();
        }
        return instance;
    }

    public void flyAt(double speedMetersPerMinute, double altitude) {
        this.currentSpeed = speedMetersPerMinute;
        this.currentAltitude = altitude;
    }

    public void chargeBattery(double amount) {
        this.currentBatteryLevel += amount;
    }

    public void useBattery(double amount) {
        this.currentBatteryLevel -= amount;
    }

    public static void main(String[] args) {

        Drone[] drones = new Drone[4];

        drones[0] = new Drone(70,600,7000,100);
        drones[1] = new Drone();
        drones[2] = getInstance();
        drones[3] = getInstance();

        for (Drone drone: drones) {
            System.out.println(drone);
        }
    }
}
