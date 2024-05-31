package org.example;

/*
 * Author: Klejdi Galushi
 * This program was developed with the assistance of GitHub Copilot.
 */

public class User {
    // Each user has their own subscription system
   private final SubscriptionSystem subscriptionSystem;

   public User() {
       this.subscriptionSystem = new SubscriptionSystem();
   }
   public void subscribe(String link, int frequency, Channel channel) {
       // Resolve link to website
       Website subscribedWebsite = new Website(link);

       // Resolve notification frequency and channel for website
       subscribedWebsite.setNotification(new Notification(frequency, channel));

       // Register to subscription list
       System.out.println("Subscribing to " + link + "...");
       subscriptionSystem.registerWebsite(subscribedWebsite);
   }
   public void unsubscribe(String link) {
       // Unregister from subscription list
       System.out.println("Unsubscribing from " + link + "...");
       subscriptionSystem.unregisterWebsite(new Website(link));
   }

    public SubscriptionSystem getSubscriptionSystem() {
       return subscriptionSystem;
    }
}
