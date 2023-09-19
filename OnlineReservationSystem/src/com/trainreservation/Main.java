package com.trainreservation;

import java.util.Scanner;

public class Main {
    private static LoginManager loginManager;
    private static ReservationManager reservationManager;
    private static CancellationManager cancellationManager;
    private static Scanner scanner;

    public static void main(String[] args)throws Exception {
        loginManager = new LoginManager();
        reservationManager = new ReservationManager();
        cancellationManager = new CancellationManager();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Train Reservation System");
            System.out.println("1. Login");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (loginManager.authenticateUser(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }

    private static void makeReservation() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();

        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter date of journey (YYYY-MM-DD): ");
        String dateOfJourney = scanner.nextLine();

        System.out.print("Enter from location: ");
        String fromLocation = scanner.nextLine();

        System.out.print("Enter to location: ");
        String toLocation = scanner.nextLine();

        reservationManager.makeReservation(username, trainNumber, classType, dateOfJourney, fromLocation, toLocation);
    }

    private static void cancelReservation() {
        System.out.print("Enter PNR number to cancel the reservation: ");
        String pnr = scanner.nextLine();

        cancellationManager.cancelReservation(pnr);
    }
}
