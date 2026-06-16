package org.prog.session5;

public class Plane {
    public int maxSeats = 200;
    public int passengers;

    public int getFreeSeatsPercentage() {
        int freeSeats = (maxSeats - passengers) / maxSeats;
        return freeSeats;
    }
}
