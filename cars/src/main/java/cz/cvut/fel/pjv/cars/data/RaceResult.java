package cz.cvut.fel.pjv.cars.data;

import cz.cvut.fel.pjv.cars.model.Car;

public class RaceResult implements Comparable<RaceResult> {
    private Car car;
    private double raceTime;

    public RaceResult(Car car, double raceTime) {
        this.car = car;
        this.raceTime = raceTime;
    }

    public Car getCar() {
        return car;
    }

    public double getRaceTime() {
        return raceTime;
    }

    @Override
    public String toString() {
        return car + " " + raceTime;
    }

    @Override
    public int compareTo(RaceResult o) {
        return Double.compare(this.raceTime, o.raceTime);
    }

//    @Override
//    public int compareTo(Object o) {
//        return Double.compare(this.raceTime, ((RaceResult) o).raceTime);
//    }
}