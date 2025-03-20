package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Lab01;

import java.util.Scanner;

public class Lab01Impl implements Lab01 {
    @Override
    public void homework() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);

        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
        int operation = sc.nextInt();

        double a, b;
        int decimalCount;
        String sign;
        double result;
        switch (operation) {
            case 1:
                System.out.println("Zadej scitanec: ");
                a = sc.nextDouble();
                System.out.println("Zadej scitanec: ");
                b = sc.nextDouble();
                sign = "+";
                result = a + b;
                break;
            case 2:
                System.out.println("Zadej mensenec: ");
                a = sc.nextDouble();
                System.out.println("Zadej mensitel: ");
                b = sc.nextDouble();
                sign = "-";
                result = a - b;
                break;
            case 3:
                System.out.println("Zadej cinitel: ");
                a = sc.nextDouble();
                System.out.println("Zadej cinitel: ");
                b = sc.nextDouble();
                sign = "*";
                result = a * b;
                break;
            case 4:
                System.out.println("Zadej delenec: ");
                a = sc.nextDouble();
                System.out.println("Zadej delitel: ");
                b = sc.nextDouble();

                if (b == 0) {
                    System.out.println("Pokus o deleni nulou!");
                    return;
                }

                sign = "/";
                result = a / b;
                break;
            default:
                System.out.println("Chybna volba!");
                return;
        }

        System.out.println("Zadej pocet desetinnych mist: ");
        decimalCount = sc.nextInt();

        if (decimalCount < 0) {
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            return;
        }

        String format = "%." + decimalCount + "f";
        System.out.println(String.format(format, a) + " " + sign + " " + String.format(format, b) + " = " + String.format(format, result));

    }
}

