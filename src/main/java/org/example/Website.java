package org.example;

/*
 * Author: Klejdi Galushi
 * This program was developed with the assistance of GitHub Copilot.
 *
 *  Pulling data from a webpage:
 *  https://stackoverflow.com/questions/6159118/using-java-to-pull-data-from-a-webpage
 */

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Website {
    private URL url;
    private WebsiteContent previousContent;
    private WebsiteContent content;
    private Notification notification;

    public Website(String link) {
        setURL(link);
        setContent(new WebsiteContent(url));
    }
    public void updateContent() {
        this.previousContent = getContent();
        setContent(new WebsiteContent(url));
    }
    public WebsiteContent getContent() {
        return content;
    }
    public void setContent(WebsiteContent content) {
        this.content = content;
    }

    public Boolean isUpdated() {
        if(content == null) {
            return false;
        }
        return !content.getWebsiteText().equals(previousContent.getWebsiteText());
    }

    public URL getURL() {
        return url;
    }

    public void setURL(String link) {
        try {
            url = new URL(link);
            URLConnection connection = url.openConnection();
            connection.connect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
