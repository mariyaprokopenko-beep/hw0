package edu.narxoz.galactic.factories;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.drones.*;

public class EarthSectorFactory implements GalacticSectorFactory {
    @Override
    public Drone createDrone(String id) {
        return new LightDrone(id, 15.0);
    }

    @Override
    public CelestialBody createBase(String name, double x, double y) {
        return new SpaceStation(name, x, y, 1);
    }
}