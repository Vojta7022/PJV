package cz.cvut.fel.pjv.cars;

import cz.cvut.fel.pjv.cars.data.CarLinkedList;
import cz.cvut.fel.pjv.cars.data.RaceResult;
import cz.cvut.fel.pjv.cars.model.Car;
import cz.cvut.fel.pjv.utils.ArrayUtil;

import java.util.Arrays;

public class Race {
    private int length;
    private CarLinkedList cars;
    private RaceResult[] rr;
    private boolean raceStarted;

    public Race(int length) {
        this.length = length;
        cars = new CarLinkedList();
        raceStarted = false;
    }

    public boolean addRacingCar(Car car) {
        if (!raceStarted) {
            cars.addCar(car);
            return true;
        }
        return false;
    }

    public Car getWinner() {
       if (!raceStarted) {
           getRaceResults();
       }
       return rr[0].getCar();
    }

    public double getWinningTime() {
        if (!raceStarted) {
            getRaceResults();
        }
        return rr[0].getRaceTime();
    }

    private RaceResult[] getRaceResults() {
        raceStarted = true;
        Car[] carsArray = cars.toArray();
        rr = new RaceResult[carsArray.length];
        for (int i = 0; i < carsArray.length; i++) {
            rr[i] = new RaceResult(carsArray[i], (double) length / carsArray[i].getSpeed());
        }
        ArrayUtil.sort(rr);

        return rr;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (raceStarted) {
            for (int i = 0; i < rr.length; i++) {
                result.append(rr[i].getCar()).append(" ").append(rr[i].getRaceTime()).append("\n");
            }
        } else {
            Car[] carsArray = cars.toArray();
            for (Car car : carsArray) {
                result.append(car).append("\n");
            }
        }
        return result.toString();
    }
}
