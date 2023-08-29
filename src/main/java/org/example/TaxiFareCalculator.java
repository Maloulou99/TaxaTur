package org.example;

import java.util.Scanner;


public class TaxiFareCalculator {
    private double dayTime = 39;
    private double eveningTime = 49;
    private double dayKmRate = 10;
    private double eveningKmRate = 14;

    public TaxiFareCalculator() {
    }

    public TaxiFareCalculator(double dayTime, double eveningTime, double dayKmRate, double eveningKmRate) {
        this.dayTime = dayTime;
        this.eveningTime = eveningTime;
        this.dayKmRate = dayKmRate;
        this.eveningKmRate = eveningKmRate;
    }

    public double calculatePrice(double distance, int passengers, boolean isDaytime, boolean hasBike) {
        double startFee;
        double kmPrice;
        double speed;
        double time;

        if (isDaytime) {
            if (passengers <= 4) {
                startFee = 39.0;
                kmPrice = 10.0;
                speed = 44.0;
            } else {
                startFee = 69.0;
                kmPrice = 14.0;
                speed = 44.0;
            }
        } else {
            if (passengers <= 4) {
                startFee = 49.0;
                kmPrice = 14.0;
                speed = 40.0;
            } else {
                startFee = 79.0;
                kmPrice = 20.0;
                speed = 40.0;
            }
        }

        if (hasBike) {
            startFee += 25.0;
        }

        time = distance / speed;
        double price = startFee + (kmPrice * distance);

        if (!isDaytime) {
            if (passengers <= 4) {
                double minuteRate = 6.5;
                double timeInMinutes = time * 60;
                price += minuteRate * timeInMinutes;
            } else {
                double minuteRate = 7.0;
                double timeInMinutes = time * 60;
                price += minuteRate * timeInMinutes;
            }
        } else {
            if (passengers <= 4) {
                double minuteRate = 6.75;
                double timeInMinutes = time * 60;
                price += minuteRate * timeInMinutes;
            } else {
                double minuteRate = 6.7;
                double timeInMinutes = time * 60;
                price += minuteRate * timeInMinutes;
            }
        }

        return price;
    }

    public static void main(String[] args) {
        TaxiFareCalculator fareCalculator = new TaxiFareCalculator();
        fareCalculator.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        boolean calculateAgain = true;
        while (calculateAgain) {
            System.out.println("Taxi beregner:\n");

            System.out.print("Hvor lang er taxa turen (km): ");
            double distanceKm = scanner.nextDouble();

            System.out.print("Skal du køre om dagen (06-18) [y/n] ? ");
            boolean isEveningWeekend = scanner.next().equalsIgnoreCase("n");

            System.out.print("Antal passagere (maks 8)? ");
            int passengers = scanner.nextInt();

            System.out.print("Medbringes en cykel [y/n]? ");
            boolean hasBike = scanner.next().equalsIgnoreCase("y");

            double fare = calculatePrice(distanceKm, passengers, isEveningWeekend, hasBike);
            System.out.println("\nTaxapris: " + fare + " kroner\n");

            System.out.print("Lav en ny beregning [y/n]? ");
            calculateAgain = scanner.next().equalsIgnoreCase("y");
        }

        System.out.println("Hej hej!");
        scanner.close();
    }
}


