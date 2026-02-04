package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.factories.*;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
    public static void main(String[] args) {

        GalacticSectorFactory sectorFactory = new EarthSectorFactory();
        Planet venerus = new Planet("Venerus", 10000, 1000, "Unknown");
        CelestialBody appolon = sectorFactory.createBase("Apolon-1", 100, 101);

        Cargo cargo = new Cargo(45, "Oxygen Tanks");
        DroneFactory lightFactory = new LightDroneFactory();
        DroneFactory heavyFactory = new HeavyDroneFactory();

        Drone lightDrone = lightFactory.createDrone("Light-1");
        Drone heavyDrone = heavyFactory.createDrone("Heavy-1");

        DeliveryTask task = new DeliveryTask(venerus, appolon, cargo);
        Dispatcher dispatcher = new Dispatcher();

        Result r1 = dispatcher.assignTask(task, lightDrone);
        System.out.println(" ");
        System.out.println("LightDrone assign: ok=" + r1.ok());
        System.out.println("Reason=" + r1.reason());
        System.out.println(" ");

        Result r2 = dispatcher.assignTask(task, heavyDrone);
        System.out.println("HeavyDrone assign: ok=" + r2.ok());
        System.out.println("Reason=" + r2.reason());
        System.out.println(" ");

        if (task.getAssignedDrone() != null) {
            System.out.println("Estimated time: " + task.estimateTime() + " min");
        }

        Result r3 = dispatcher.completeTask(task);
        System.out.println("Task completed: ok=" + r3.ok());
        System.out.println("Task state: " + task.getState());
        System.out.println("Drone status: " + heavyDrone.getStatus());
    }
}