package com.beckytech.biologygrade9studenttextbook;

public class ModelViewPager {
    private final String title;
    private final String link;
    private final int image;

    public ModelViewPager(String title, String link, int image) {
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public int getImage() {
        return image;
    }
}
