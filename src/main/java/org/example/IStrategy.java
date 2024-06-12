package org.example;

public interface IStrategy {
    Boolean compare(WebsiteContent currentContent, WebsiteContent previousContent);
}
