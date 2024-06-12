package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CompareWebsiteText implements IStrategy {
    @Override
    public Boolean compare(WebsiteContent currentContent, WebsiteContent previousContent) {
        Document currentDocument = Jsoup.parse(currentContent.getWebsiteText());
        Document previousDocument = Jsoup.parse(previousContent.getWebsiteText());

        String currentText = currentDocument.body().text();
//        System.out.println(currentText);
        String previousText = previousDocument.body().text();
//        System.out.println(previousText);

        if(currentText == null) {
            return false;
        }
        return !currentText.equals(previousText);
    }
}
