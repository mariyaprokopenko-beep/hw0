package edu.narxoz.galactic.drones;

public class HeavyDroneFactory extends DroneFactory {
    @Override
    public Drone createDrone(String id) {
        return new HeavyDrone(id, 200.0);
    }
}