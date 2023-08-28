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

                    double fare = calculateFare(distanceKm, isEveningWeekend, passengers, hasBike);
                    System.out.println("\nTaxapris: " + fare + " kroner\n");

                    System.out.print("Lav en ny beregning [y/n]? ");
                    calculateAgain = scanner.next().equalsIgnoreCase("y");
                }

                System.out.println("Tak for brugen!");
                scanner.close();
            }

            public static double calculateFare(double distanceKm, boolean isEveningWeekend, int passengers, boolean hasBike) {
                double baseFare;
                double kmRate;

                if (isEveningWeekend) {
                    baseFare = 49;
                    kmRate = 14;
                } else {
                    baseFare = 39;
                    kmRate = 10;
                }

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
