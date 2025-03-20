package cz.cvut.fel.pjv.cars.data;

import cz.cvut.fel.pjv.cars.model.Car;

import java.util.LinkedList;

public class CarLinkedList {
    private CarListNode head;
    private int size;

    public CarLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public Car[] toArray() {
        Car[] cars = new Car[size];
        CarListNode tmp = head;

        int index = 0;
        while(tmp != null) {
            cars[index] = tmp.car;
            tmp = tmp.next;
            index++;
        }

        return cars;
    }

    public void addCar(Car car) {
        head = new CarListNode(car, head);
        size++;
    }
}
