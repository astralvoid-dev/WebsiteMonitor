package org.example;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Scanner;

/*
 * Author: Klejdi Galushi
 * This program was developed with the assistance of GitHub Copilot.
 */

public class WebsiteContent {
    String websiteText;
    LocalDateTime lastUpdated;

    public WebsiteContent(URL url) {
        try (Scanner scanner = new Scanner(url.openStream())) {
            StringBuilder htmlText = new StringBuilder();
            while (scanner.hasNext()) {
                htmlText.append(scanner.nextLine());
            }
            setWebsiteText(convertToHash(htmlText.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setLastUpdated(LocalDateTime.now());
    }

    public String convertToHash(String htmlText) {
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        final byte[] hashbytes = digest.digest(websiteText.getBytes());
        final StringBuilder hash = new StringBuilder();
        for (byte b : hashbytes) {
            hash.append(String.format("%02x", b));
        }
        return hash.toString();
    }

    public String getWebsiteText() {
        return websiteText;
    }

    public void setWebsiteText(String websiteText) {
        this.websiteText = websiteText;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
