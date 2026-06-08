package org.prog.session4;

public class Car {
    //поле класса
    public String color;
    public int maxSpeed;
    public String owner;

    //метод класса
    public void goTo(int distance, String destination) {
        System.out.println(color + " car starts engine");
        System.out.println(color + " car is going somewhere...");
        System.out.println(color + " car stops");
        System.out.println(color + " belonging to " + owner + " goes to " + destination);
        if (maxSpeed > distance) {
            System.out.println("Cannot calculate time - car is too fast!");
        } else {
            System.out.println("Car will arrive in: " + distance / maxSpeed);
        }
    }
}
