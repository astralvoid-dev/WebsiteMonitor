package org.example;

public class CompareHTMLContent implements IStrategy {
    @Override
    public Boolean compare(WebsiteContent currentContent, WebsiteContent previousContent) {
        if(currentContent == null) {
            return false;
        }
//        System.out.println(currentContent.getWebsiteText());
//        System.out.println(previousContent.getWebsiteText());
        return !currentContent.getWebsiteText().equals(previousContent.getWebsiteText());
    }
}
