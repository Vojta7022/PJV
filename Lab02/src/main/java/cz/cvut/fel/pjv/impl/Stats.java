package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.StatsInterface;

import java.util.ArrayList;
import java.util.List;

public class Stats implements StatsInterface {
    private final List<Double> numbers = new ArrayList<>();

    @Override
    public void addNumber(double number) {
        numbers.add(number);
        if(numbers.size() == 11) {
            for(int i = 0; i < 10; i++) {
                numbers.removeFirst();
            }
        }

        if (numbers.size() % 10 == 0) {
            System.out.println(getFormattedStatistics());
        }
    }

    @Override
    public double getAverage() {
        if (numbers.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    @Override
    public double getStandardDeviation() {
        if (numbers.size() < 2) {
            return 0.0;
        }
        double mean = getAverage();
        double sumSquares = 0;
        for (double number : numbers) {
            sumSquares += Math.pow(number, 2);
        }
        double meanOfSquares = sumSquares / numbers.size();

        return Math.sqrt(meanOfSquares - Math.pow(mean, 2));
    }

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public String getFormattedStatistics() {
        return String.format("%2d %.3f %.3f", getCount(), getAverage(), getStandardDeviation());
    }
}
