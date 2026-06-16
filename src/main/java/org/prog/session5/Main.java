package org.prog.session5;

import java.util.Random;

public class Main {

    //TODO: Create class Plane
    //TODO: Class Plane must have max seats (200)
    //TODO: Create array of 50 Planes
    //TODO: Seat random number of passengers in each plane (up to 200)
    //TODO: Add method that will return % of free seats in plane as int
    //TODO* : sort planes by taken seats amount as %
    //TODO** : use bubble sort

    public static void main(String[] args) {
        Plane[] planes = new Plane[50];
        Random rand = new Random();
        for (int i = 0; i < planes.length; i++) {
            Plane plane = new Plane();
            plane.passengers = rand.nextInt(201);
            planes[i] = plane;
        }
    }
}
