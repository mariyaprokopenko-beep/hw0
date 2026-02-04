package edu.narxoz.galactic.drones;

public class LightDroneFactory extends DroneFactory {
    @Override
    public Drone createDrone(String id) {
        return new LightDrone(id, 10.0);
    }
}