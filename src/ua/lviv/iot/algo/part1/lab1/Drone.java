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

        Drone firstDrone = new Drone(70,600,7000,100);
        Drone secondDrone = new Drone();
        Drone instance1 = new Drone();

        instance1 = getInstance();

        Drone instance2 = new Drone();

        instance2 = getInstance();

        Drone[] drones = new Drone[4];

        drones[0] = firstDrone;
        drones[1] = secondDrone;
        drones[2] = instance1;
        drones[3] = instance2;
        int i = 0;
        while (i<drones.length){
            System.out.println(drones[i]);
            i++;
        }
    }
}
