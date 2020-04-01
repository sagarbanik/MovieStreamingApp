package com.example.moviestreamingapp.models;

public class Movie {

    private String title;
    private String description;
    private int thumnail;
    private String studio;
    private String rating;
    private String streamingLink;
    private int coverPhoto;

    public Movie(String title, int thumnail, int coverPhoto) {
        this.title = title;
        this.thumnail = thumnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, int thumnail) {
        this.title = title;
        this.thumnail = thumnail;
    }

    public Movie(String title, String description, int thumnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        this.thumnail = thumnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumnail() {
        return thumnail;
    }

    public void setThumnail(int thumnail) {
        this.thumnail = thumnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
}
