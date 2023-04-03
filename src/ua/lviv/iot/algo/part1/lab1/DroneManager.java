package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ToString
@NoArgsConstructor
@Getter
public class DroneManager {
    private List<Drone> droneList = new ArrayList<>();

    public void addDrone(Drone newDrone){
        this.droneList.add(newDrone);
    }

    public void addDrones(List<Drone> drones){
        this.droneList.addAll(drones);
    }

    public void addDrones(Drone ... drones){
        this.droneList.addAll(List.of(drones));
    }

    public List<Drone> findAltitudeBiggerThan(double altitude){
        return droneList.stream().filter(drone -> drone.getCurrentAtlitude() > altitude).toList();
    }

    public List<Drone> findSpeedBiggerThan(double speed){
        return droneList.stream().filter(drone -> drone.getCurrentSpeed() > speed).toList();
    }
    public static void main(String ...strings){
        System.out.println("\t\tFIRST PART\n");

        List<Drone> drones = new ArrayList<>();

        drones.add(new ElectroDrone(8000,7000,900));
        drones.add(new ElectroDrone(9600,9000,1000));
        drones.add(new PetrolDrone(20,"Benzin",2));
        drones.add(new PetrolDrone(25,"Benzin",2.5));

        for (Drone drone : drones){
            System.out.println(drone);
        }

        var fleet = new DroneManager();
        fleet.addDrones(drones);
        fleet.addDrone(new PetrolDrone(24, "Kerosin",1.5));

        fleet.getDroneList().get(0).flyAt(40,250);
        fleet.getDroneList().get(1).flyAt(35,350);
        fleet.getDroneList().get(2).flyAt(25,130);
        fleet.getDroneList().get(3).flyAt(60,280);
        fleet.getDroneList().get(4).flyAt(75,310);

        System.out.println("\n\t\tSECOND PART\n");
        System.out.println("Drones current altitude bigger than 270: \n");

        var drones1 = fleet.findAltitudeBiggerThan(270);

        for(Drone drone : drones1){
            System.out.println(drone);
        }

        System.out.println("\nDrones current speed bigger than 50\n");

        var drones2 = fleet.findSpeedBiggerThan(50);

        for(Drone drone : drones2){
            System.out.println(drone);
        }
    }
}
