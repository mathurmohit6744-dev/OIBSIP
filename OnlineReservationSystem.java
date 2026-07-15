import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class OnlineReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Reservation> reservations = new HashMap<>();

    // Login details
    static final String USERNAME = "admin";
    static final String PASSWORD = "1234";

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   ONLINE RESERVATION SYSTEM");
        System.out.println("=================================");

        if (login()) {
            System.out.println("\nLogin Successful!");

            while (true) {
                System.out.println("\n----- MAIN MENU -----");
                System.out.println("1. Make Reservation");
                System.out.println("2. Cancel Reservation");
                System.out.println("3. View Reservation");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        makeReservation();
                        break;

                    case 2:
                        cancelReservation();
                        break;

                    case 3:
                        viewReservation();
                        break;

                    case 4:
                        System.out.println("Thank you for using the system!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } else {
            System.out.println("Invalid Login ID or Password!");
        }
    }

    // Login Module
    static boolean login() {

        System.out.print("Enter Login ID: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        return username.equals(USERNAME)
                && password.equals(PASSWORD);
    }

    // Reservation Module
    static void makeReservation() {

        System.out.println("\n----- RESERVATION FORM -----");

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Train Number: ");
        String trainNumber = sc.nextLine();

        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();

        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Enter Date of Journey: ");
        String date = sc.nextLine();

        System.out.print("Enter Starting Place: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        // Generate random PNR number
        Random random = new Random();
        int pnr = 100000 + random.nextInt(900000);

        Reservation reservation = new Reservation(
                pnr,
                name,
                trainNumber,
                trainName,
                classType,
                date,
                source,
                destination
        );

        reservations.put(pnr, reservation);

        System.out.println("\nReservation Successful!");
        System.out.println("Your PNR Number is: " + pnr);
    }

    // Cancellation Module
    static void cancelReservation() {

        System.out.println("\n----- CANCELLATION FORM -----");

        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();
        sc.nextLine();

        if (reservations.containsKey(pnr)) {

            Reservation reservation = reservations.get(pnr);

            reservation.displayDetails();

            System.out.print("\nConfirm Cancellation (yes/no): ");
            String confirmation = sc.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {

                reservations.remove(pnr);

                System.out.println(
                        "Ticket Cancelled Successfully!"
                );

            } else {

                System.out.println(
                        "Cancellation Aborted."
                );
            }

        } else {

            System.out.println(
                    "Reservation not found!"
            );
        }
    }

    // View Reservation
    static void viewReservation() {

        System.out.print("\nEnter PNR Number: ");
        int pnr = sc.nextInt();
        sc.nextLine();

        if (reservations.containsKey(pnr)) {

            reservations.get(pnr).displayDetails();

        } else {

            System.out.println(
                    "Reservation not found!"
            );
        }
    }
}


// Reservation Class
class Reservation {

    int pnr;
    String passengerName;
    String trainNumber;
    String trainName;
    String classType;
    String journeyDate;
    String source;
    String destination;

    Reservation(
            int pnr,
            String passengerName,
            String trainNumber,
            String trainName,
            String classType,
            String journeyDate,
            String source,
            String destination
    ) {

        this.pnr = pnr;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.source = source;
        this.destination = destination;
    }

    void displayDetails() {

        System.out.println("\n----- RESERVATION DETAILS -----");

        System.out.println("PNR Number       : " + pnr);
        System.out.println("Passenger Name   : " + passengerName);
        System.out.println("Train Number     : " + trainNumber);
        System.out.println("Train Name       : " + trainName);
        System.out.println("Class Type       : " + classType);
        System.out.println("Journey Date     : " + journeyDate);
        System.out.println("Starting Place   : " + source);
        System.out.println("Destination      : " + destination);
    }
}