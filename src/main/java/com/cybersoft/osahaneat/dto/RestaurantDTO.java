package com.cybersoft.osahaneat.dto;

public class RestaurantDTO {
    private String title, subtitle,image;
    private boolean isFreeship ;
    private  double rating;
//    private String address, openDate;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
