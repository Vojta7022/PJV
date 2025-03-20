package cz.cvut.fel.pjv;

import java.awt.*;

public class Bicycle {

    protected int cadence;
    protected int speed;
    protected int gear;
    protected BikeColor color;

    public Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
        this.color = BikeColor.RED;
    }

    public void printDescription() {
        System.out.println("\nBike is " + "in gear " + this.gear
            + " with a cadence of " + this.cadence +
            " and travelling at a speed of " + this.speed + ". ");
        System.out.println("The " + "Bike has a" + this.color + " color.");
    }

//    public void visit(BasicService service) {
//        service.acceptBike(this);
//    }
//
//    public void visit(Car car) {
//        car.accept(this);
//    }

    public void visit(BicycleVisitable visitable) {
        visitable.accept(this);
    }
}
