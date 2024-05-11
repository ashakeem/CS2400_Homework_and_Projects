//
// Name: Hakeem, Ayomide
// Project: #4
// Due: 05/10/2024
// Course: cs-2400-03-sp24
//
// Description:
// Final Project on Minimum distance between Airports
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AirportApp {
    private HashedDictionary<String, String> airports;
    private static GraphInterface<String> myMap; // instance of map

    public AirportApp() {
        airports = new HashedDictionary<>();
        myMap = new DirectedGraph<>(); // you can change this to yours professor if you like, keeping here for app to
                                       // run
    }

    // Method to load airports from file

    public void loadAirportsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > 4) { // Ensuring the line has at least one character beyond "XXX "
                    String code = line.substring(0, 3); // Extract the first three characters as the airport code
                    String description = line.substring(4); // Everything after the first three characters is the
                                                            // description
                    airports.add(code, description);
                    // System.out.println("Loaded: " + code + " -> " + description); // Debug print
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to load distances from file

    public void loadDistancesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String from = parts[0].trim();
                    String to = parts[1].trim();
                    double distance = Double.parseDouble(parts[2].trim());
                    myMap.addVertex(from);
                    myMap.addVertex(to);
                    myMap.addEdge(from, to, distance);
                    //  System.out.println("Loaded: " + from + " -> " + to + " = " + distance); // Debug print
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to get airport info
    public String getAirportInfo(String code) {
        if (airports.get(code) != null) {
            return airports.get(code);
        }
        ;
        return "Airport code unknown";
    }

    // Method to get distance between two airports will go here
    public StackInterface<String> getDistance(String from, String to) {
        StackInterface<String> route = new ArrayStack<>();

        double distance = myMap.getCheapestPath(from, to, route);
        return distance;

        


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        AirportApp app = new AirportApp();
        app.loadAirportsFromFile("airports.csv");

        app.loadDistancesFromFile("distances.csv");
        // myMap.show();

        System.out.println("Airports v0.24 by Hakeem, Ayomide\n\n");

        do {
            System.out.print("Command? ");
            command = scanner.nextLine().toUpperCase();
            switch (command) {
                case "Q":
                    System.out.print("Airport code? ");
                    String code = scanner.nextLine().toUpperCase();

                    System.out.println(app.getAirportInfo(code));
                    break;
                case "D":
                    System.out.print("Airport codes from to? ");
                    String from = scanner.next().toUpperCase();
                    String to = scanner.next().toUpperCase();
                    System.out.println("The minimum distance between " + from + " and " + to + " is " + app.getDistance(from, to));
                    System.out.println(app.getAirportInfo(from) +  " " + from);
                    System.out.println("...in between airports");
                    System.out.println(app.getAirportInfo(to) +  " " + to);


                    scanner.nextLine(); // clear buffer
                    break;
                case "H":
                    displayHelp();
                    break;
                case "E":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        } while (!command.equals("E"));
        scanner.close();
    }

    private static void displayHelp() {
        System.out.println("H Display this message.");
        System.out.println("Q Query the airport information by entering the airport code.");
        System.out.println("D Find the minimum distance between two airports.");
        System.out.println("E Exit.");
    }
}
