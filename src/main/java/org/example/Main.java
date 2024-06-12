package org.example;

/*
 *  =================================================================
 *  WEBSITE MONITOR
 *  =================================================================
 *  Author: Klejdi Galushi
 *  This program was developed with the assistance of GitHub Copilot.
 *  -----------------------------------------------------------------
 *  EXAMPLE LINKS
 *  https://gist.githubusercontent.com/astralvoid-dev/e5a383a13138a836194ab53307266cdd/raw
 *  https://teaching.dahahm.de
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialise scanner and username
        Scanner scanner = new Scanner(System.in);
        String username;

        // Login Menu
        System.out.println("========================================");
        System.out.println("LOG IN");
        System.out.println("========================================");
        System.out.print("Username: ");
        username = scanner.next();
        // Consume newline character
        scanner.nextLine();

        // Initialise user
        User user = new User(username);

        // TODO: Implement "dev"
        while(true) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("WEBSITE MONITOR");
            System.out.println("========================================");
            System.out.println("Welcome, " + username + "!");
            System.out.println();
            System.out.println("INSTRUCTIONS");
            if(!username.equals("dev")) {
                System.out.println("sub <website> <frequency> <channel> <strategy> - subscribe to a website");
                System.out.println("unsub <website> - unsubscribe from a website");
            }
            System.out.println("check <website> - check for updates on a single website");
            System.out.println("checkall - check for updates on all subscribed websites");
            System.out.println("quit - quit website monitor");
            System.out.println("========================================");
            System.out.print("> ");

            // Parse user input
            String[] arguments = scanner.nextLine().split(" ");

            if(arguments.length == 5) {
                // Subscribe to a website
                if(arguments[0].equals("sub") && arguments[1] != null && arguments[2] != null && arguments[3] != null) {
                    user.subscribe(arguments[1], Integer.parseInt(arguments[2]), Channel.valueOf(arguments[3].toUpperCase()), Integer.parseInt(arguments[4]));
                }
            } else if(arguments.length == 2) {
                // Unsubscribe from a website
                if(arguments[0].equals("unsub")) {
                    user.unsubscribe(arguments[1]);
                } // Check for updates on a single website
                else if(arguments[0].equals("check") && arguments[1] != null) {
                    user.getSubscriptionSystem().checkForUpdates(arguments[1]);
                }
            } else if(arguments.length == 1) {
                // Check for updates on all subscribed websites
                if(arguments[0].equals("checkall")) {
                    user.getSubscriptionSystem().checkForUpdates();
                } // Quit website monitor
                else if(arguments[0].equals("quit")) {
                    break;
                }
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
        System.out.println("Quitting website monitor...");
    }
}