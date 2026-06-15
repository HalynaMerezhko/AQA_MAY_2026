package org.prog.session9.list;

import org.prog.session7.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarListDemo {

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car());
        carList.add(new Car());
        carList.add(new Car());

        carList.get(0).color = "red";
        carList.get(1).color = "blue";
        carList.get(2).color = "green";
        carList.get(0).model = "h";
        carList.get(1).model = "l";
        carList.get(2).model = "w";
        carList.get(0).plateNumber = "003";
        carList.get(1).plateNumber = "002";
        carList.get(2).plateNumber = "001";

        for (int i = 0; i < carList.size(); i++) {
            System.out.println("====================");
            System.out.println(carList.get(i).model);
            System.out.println(carList.get(i).plateNumber);
            System.out.println(carList.get(i).color);
        }
    }
}
