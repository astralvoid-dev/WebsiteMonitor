package org.example;

public class CompareContentSize implements IStrategy {
    @Override
    public Boolean compare(WebsiteContent currentContent, WebsiteContent previousContent) {
        if(currentContent.getWebsiteText().length() == 0) {
            return false;
        }
        if(currentContent.getWebsiteText().length() == previousContent.getWebsiteText().length()) {
//            System.out.println(currentContent.getWebsiteText().length());
//            System.out.println(previousContent.getWebsiteText().length());
//            System.out.println();
            return true;
        }
        return false;
    }
}
