package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ElectroDrone extends Drone {
    private double batteryCapacity;
    private double currentBatteryLevel;
    private double fuelConsumptionPerHour;

    public void chargeBattery(double amount) {
        this.currentBatteryLevel += amount;
        if(this.currentBatteryLevel > this.batteryCapacity){
            this.currentBatteryLevel = this.batteryCapacity;
        }
    }

    public void useBattery(double amount) {
        this.currentBatteryLevel -= amount;
        if (this.currentBatteryLevel < 0){
            this.currentBatteryLevel = 0;
        }
    }

    @Override
    public double getMaxFlyingDistanceAtCurrentSpeed() {
        return this.currentBatteryLevel / this.fuelConsumptionPerHour * this.getCurrentSpeed();
    }

    public String getHeaders(){
        return super.getHeaders() + "," +
                "batteryCapacity, currentBatteryLevel, fuelConsumptionPerHour";
    }

    public String toCSV(){
        return super.toCSV() + "," + batteryCapacity +
                "," + currentBatteryLevel +
                "," + fuelConsumptionPerHour;
    }
}
