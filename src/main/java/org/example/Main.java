package org.example;

/*
    Website Monitor
 */

public class Main {
    public static void main(String[] args) {
        // Initialise user
        User user = new User();

        // Subscribe to websites
        // TODO: Implement mock GUI for user input
        user.subscribe("https://gist.githubusercontent.com/astralvoid-dev/e5a383a13138a836194ab53307266cdd/raw", 5, Channel.WEB);
        user.subscribe("https://teaching.dahahm.de", 10, Channel.EMAIL);

        // Check for updates
        user.getSubscriptionSystem().checkForUpdates();
    }
}