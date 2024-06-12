package org.example;

/*
 * Author: Klejdi Galushi
 * This program was developed with the assistance of GitHub Copilot.
 */

public class User {
    // Each user has their own subscription system
   private final SubscriptionSystem subscriptionSystem;

   public User(String username) {
       this.subscriptionSystem = new SubscriptionSystem();
   }
   public void subscribe(String link, int frequency, Channel channel, int strategyType) {
       // Resolve link to website
       Website subscribedWebsite = new Website(link);
       switch(strategyType) {
           case 1:
               subscribedWebsite.setStrategy(new CompareContentSize());
               break;
           case 2:
               subscribedWebsite.setStrategy(new CompareHTMLContent());
               break;
           case 3:
               subscribedWebsite.setStrategy(new CompareWebsiteText());
               break;
       }

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
