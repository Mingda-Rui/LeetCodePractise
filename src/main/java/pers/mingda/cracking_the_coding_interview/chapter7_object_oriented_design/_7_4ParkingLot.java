package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.ArrayList;

public class _7_4ParkingLot {
}

enum VehicleSize {
    Motorcycle,
    Compact,
    Large
}

abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    /* Park vehicle in this spot (among others, potentially) */
    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    /* Remove car from spot, and notify spot that it's gone */
    public void cleaSpots() {
        // ...
    }

    /*Checks if the spot is big enough for the vehicle (and is available). This
     * compares the SIZE only. It does not check if it has enough spots.
    * */
    public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    /* Checks if the spot is a Large. Doesn't check num of spots */
    public boolean canFitInSpot(ParkingSpot spot) {
        // ...
        return false;
    }
}

class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    /* Checks if the spot is a Compact or a Large. */
    public boolean canFitInSpot(ParkingSpot spot) {
        // ...
        return false;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        // ...
        return false;
    }
}

class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot() {
        // ...
    }

    /* Park the vehicle in a spot (or multiple spots). Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) {
        // ...
        return false;
    }
}

/* Represents a level in a parking garage */
class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;// number of free spots
    private static final int SPOT_PER_ROW = 10;

    public Level(int flr, int numberSpots) {
        // ...
    }

    public int availableSpots() {
        return availableSpots;
    }

    /* Find a place to park this vehicle. Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) {
        // ...
        return false;
    }

    /* Park a vehicle starting at the spot spotNumber, and continuing until
    * vehicle.spotsNeeded. */
    private boolean parkStartingAtSpot(int num, Vehicle v) {
        // ...
        return false;
    }

    /* Find a spot to park this vehicle. Return index of spot, or -1 on failure. */
    private int findAvailableSpots(Vehicle vehicle) {
        // ...
        return 0;
    }

    /* When a car was removed from the spot, increment availableSpots */
    public void spotFreed() {
        availableSpots++;
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
        // ...
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    /* Check if the spot is big enough and is available */
    public boolean canFitVehicle(Vehicle vehicle) {
        // ...
        return false;
    }

    /* Park vehicle in this spot. */
    public boolean park(Vehicle vehicle) {
        // ...
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    /* Remove vehicle from spot, and notify level that a new spot is available */
    public void removeVehicle() {
        // ...
    }
}
