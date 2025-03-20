package cz.fel.cvut.ponrtvoj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.err.print("Big ERROR");
        String txt = "Hello World!";
        int l = txt.length();

        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);
        System.out.println("Enter a number: ");
        boolean isDouble = sc.hasNextDouble();
        if (!isDouble) {
            System.out.println("You did not enter a number!");
            System.exit(0);
        } else {
            System.out.println("You entered a number!");
            System.out.println("The number is: " + sc.nextDouble());
        }
        sc.close();


    }
}