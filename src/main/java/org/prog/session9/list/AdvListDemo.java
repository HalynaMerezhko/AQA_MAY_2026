package org.prog.session9.list;

import org.prog.session6.inheritance.Car;
import org.prog.session6.inheritance.Crossover;
import org.prog.session6.inheritance.Truck;

import java.util.ArrayList;
import java.util.List;

public class AdvListDemo {
    // Car -> Cross -> Truck -> Lorry
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("red"));
        list.add(new Crossover("blue"));
        list.add(new Truck("green"));

        for (Car car : list) {
            if (car instanceof Truck){
                ((Truck) car).deliverCargo();
            }
        }
    }
}
