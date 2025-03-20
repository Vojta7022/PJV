package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.StatsInterface;
import cz.cvut.fel.pjv.TextIO;

public class Lab02 {
    public void main(String[] args) {
        StatsInterface stats = new Stats();
        TextIO input = new TextIO();

        int lineNumber = 0;

        while (true) {
            String line = input.getLine();
            lineNumber++;

            if (line.isEmpty()) {
                System.err.println("End of input detected!");
                if (stats.getCount() > 0) {
                    System.out.println(stats.getFormattedStatistics());
                }
                break;
            }

            if (input.isInteger(line)) {
                stats.addNumber(Integer.parseInt(line));
            }
            else if (input.isDouble(line)) {
                stats.addNumber(Double.parseDouble(line));
            }
            else {
                System.err.println("A number has not been parsed from line " + lineNumber);
            }
        }
    }
}