package edu.narxoz.galactic.factories;

import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.drones.Drone;

public interface GalacticSectorFactory {
    Drone createDrone(String id);
    CelestialBody createBase(String name, double x, double y);
}
