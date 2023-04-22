package ua.lviv.iot.algo.part1.lab1.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryDrone extends Drone {
    private double maxPayload;
    private double currentBatteryLevel;
    private double currentPayload;

    @Override
    public double getMaxFlyingDistanceAtCurrentSpeed() {
        return this.currentBatteryLevel / 10 * this.getCurrentSpeed();
    }

    public void loadDrone(double cargoWeight) {
        if (cargoWeight >= this.maxPayload) {
            this.currentPayload = this.maxPayload;
        } else {
            this.currentPayload += cargoWeight;
        }

    }

    public String getHeaders() {
        return super.getHeaders() + ",maxPayload,currentBatteryLevel,currentPayLoad";
    }

    public String toCSV() {
        return super.toCSV() + "," + maxPayload +
                "," + currentBatteryLevel +
                "," + currentPayload;
    }
}
