package org.example;

/*
 *  Author: Klejdi Galushi
 *  This program was developed with the assistance of GitHub Copilot.
 */

public class Notification {
    private int frequency;
    private Channel channel;
    private String message;

    public Notification(int frequency, Channel channel) {
        setFrequency(frequency);
        setChannel(channel);
        setMessage();
    }

    public void sendNotification() {
        System.out.print(getMessage());
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public Channel getChannel() {
        return channel;
    }
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage() {
        switch(getChannel()) {
            case WEB:
                message = "Sent web notification!";
                break;
            case EMAIL:
                message = "Sent e-mail notification!";
                break;
            case MOBILE:
                message = "Sent mobile notification!";
                break;
        }
    }
}
