package org.example;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.subscribe("https://gist.githubusercontent.com/astralvoid-dev/e5a383a13138a836194ab53307266cdd/raw", 5, Channel.WEB);
        user.subscribe("https://teaching.dahahm.de", 10, Channel.EMAIL);

        user.getSubscriptionSystem().checkForUpdates();
    }
}