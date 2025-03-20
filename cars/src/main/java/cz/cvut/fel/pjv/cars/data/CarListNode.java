package cz.cvut.fel.pjv.cars.data;

import cz.cvut.fel.pjv.cars.model.Car;

class CarListNode {

    Car car;
    CarListNode next;

    public CarListNode(Car car, CarListNode next) {
        this.car = car;
        this.next = next;
    }
}
