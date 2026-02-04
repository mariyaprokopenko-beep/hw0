package edu.narxoz.galactic.factories;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.drones.*;

public class DeepSpaceFactory implements GalacticSectorFactory {
    @Override
    public Drone createDrone(String id) {
        return new HeavyDrone(id, 500.0);
    }

    @Override
    public CelestialBody createBase(String name, double x, double y) {
        return new Planet(name, x, y, "Gas Giant");
    }
}
