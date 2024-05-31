package org.example;

/*
 * Author: Klejdi Galushi
 * This program was developed with the assistance of GitHub Copilot.
 */

public class User {
   private final SubscriptionSystem subscriptionSystem;

   public User() {
       this.subscriptionSystem = new SubscriptionSystem();
   }
   public void subscribe(String link, int frequency, Channel channel) {
       Website subscribedWebsite = new Website(link);
       subscribedWebsite.setNotification(new Notification(frequency, channel));
       System.out.println("Subscribing to " + link + "...");
       subscriptionSystem.registerWebsite(subscribedWebsite);
   }
   public void unsubscribe(String link) {
       System.out.println("Unsubscribing from " + link + "...");
       subscriptionSystem.unregisterWebsite(new Website(link));
   }

    public SubscriptionSystem getSubscriptionSystem() {
       return subscriptionSystem;
    }
}
