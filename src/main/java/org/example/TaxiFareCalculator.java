package org.example;

import java.util.Scanner;


    public class TaxiFareCalculator {
        private double dayTime = 39;
        private double eveningTime = 49;
        private double dayKmRate = 10;
        private double eveningKmRate = 14;

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
                char timeOfDayChoice = scanner.next().charAt(0);
                boolean isEveningWeekend = (timeOfDayChoice == 'n' || timeOfDayChoice == 'N');

                System.out.print("Antal passagere (maks 8)? ");
                int passengers = scanner.nextInt();

                System.out.print("Medbringes en cykel [y/n]? ");
                char bikeChoice = scanner.next().charAt(0);
                boolean hasBike = (bikeChoice == 'y' || bikeChoice == 'Y');

                double fare = calculateFare(distanceKm, isEveningWeekend, passengers, hasBike);
                System.out.println("\nTaxapris: " + fare + " kroner\n");

                System.out.print("Lav en ny beregning [y/n]? ");
                char newCalculationChoice = scanner.next().charAt(0);
                calculateAgain = (newCalculationChoice == 'y' || newCalculationChoice == 'Y');
            }

            System.out.println("Tak for brugen!");
            scanner.close();
        }

        public double calculateFare(double distanceKm, boolean isEveningWeekend, int passengers, boolean hasBike) {
            double baseFare = isEveningWeekend ? eveningTime : dayTime;
            double kmRate = isEveningWeekend ? eveningKmRate : dayKmRate;

            double fare = baseFare + distanceKm * kmRate;

            if (passengers > 4) {
                fare += 50;
            }

            if (hasBike) {
                fare += 25;
            }

            return fare;
        }
    }

