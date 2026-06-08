package org.prog.session4;

public class Main {

    /**
     * ####################################
     * ####################################
     * ####################################
     * ####################################
     * #####[car1@Car.color=Green]#########
     * ####################################
     * ###############[car2@Car.color=Blue]
     * ####################################
     * ####################################
     * ####################################
     * ------------------------------------
     * ####################################
     */

    //TODO: Add field owner to class car, add parameter destination to goTo()
    //TODO: Print {car.color} car belonging to {car.owner} goes to {destination}
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        Car car1 = new Car();
        Car car2 = new Car();
        CarService carService = new CarService();

        carService.paintCar(car1, "Green");
        carService.paintCar(car2, "Blue");

        car1.maxSpeed = 50;
        car2.maxSpeed = 250;

        int distance = 45;

        car1.goTo(distance, "test1");
        car2.goTo(500, "test2");
    }
}
