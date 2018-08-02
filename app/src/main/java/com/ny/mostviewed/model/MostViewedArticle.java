package com.ny.mostviewed.model;

import com.google.gson.annotations.SerializedName;

public class MostViewedArticle {
    @SerializedName("url")
    private String url;

    @SerializedName("title")
    private String title;

    @SerializedName("byline")
    private String author;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("media")
    private MediaList media;

//    public MostViewedArticle(String url, String title, String author, String publishedDate) {
//        this.url = url;
//        this.title = title;
//        this.author = author;
//        this.publishedDate = publishedDate;
//    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public MediaList getMedia() {
        return media;
    }
}
