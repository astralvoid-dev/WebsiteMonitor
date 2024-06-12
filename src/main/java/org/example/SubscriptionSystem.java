package org.example;

/*
 *  Author: Klejdi Galushi
 *  This program was developed with the assistance of GitHub Copilot.
 */

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SubscriptionSystem {
    private ArrayList<Website> subscribedWebsites;
    private Instant timeStart;
    private Instant timeEnd;

    public SubscriptionSystem() {
        this.subscribedWebsites = new ArrayList<Website>();
        timeStart = Instant.now();
    }
    public void registerWebsite(Website website) {
        subscribedWebsites.add(website);
    }
    public void unregisterWebsite(Website website) {
        subscribedWebsites.remove(website);
    }
    public void notifySubscribers(Website website, Notification notification) {
        notification.sendNotification();
        System.out.println(" " + website.getURL() + " has been updated! ");
    }

    // Check for updates on all subscribed websites
    public void checkForUpdates() {
        while(true) {
            for(Website website : subscribedWebsites) {
                website.updateContent();
            }

            for(Website website : subscribedWebsites) {
                timeEnd = Instant.now();
                long timeElapsed = Duration.between(timeStart, timeEnd).toSeconds();
                if(website.isUpdated()) {
                    notifySubscribers(website, website.getNotification());
                } else if(!website.isUpdated() && timeElapsed % website.getNotification().getFrequency() == 0) {
                    System.out.println("No updates for " + website.getURL() + "...");
                    try {
                        TimeUnit.MILLISECONDS.sleep(950); // pause for almost a second
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // restore interrupted status
                    }
                }
            }
        }
    }
    // Check for updates on a single website
    public void checkForUpdates(String url) {
        while(true) {
            for(Website website : subscribedWebsites) {
                if(website.getURL().toString().equals(url)) {
                    website.updateContent();
                    timeEnd = Instant.now();
                    long timeElapsed = Duration.between(timeStart, timeEnd).toSeconds();
                    if(website.isUpdated()) {
                        notifySubscribers(website, website.getNotification());
                    } else if(!website.isUpdated() && timeElapsed % website.getNotification().getFrequency() == 0) {
                        System.out.println("No updates for " + website.getURL() + "...");
                        try {
                            TimeUnit.MILLISECONDS.sleep(950); // pause for almost a second
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // restore interrupted status
                        }
                    }
                    break;
                }
            }
        }
    }

    public ArrayList<Website> getSubscribedWebsites() {
        return subscribedWebsites;
    }
}