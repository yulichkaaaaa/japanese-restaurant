package com.yuliana.japaneserestaurant.service.dto;

public class ReviewDto {
    private int reviewId;
    private String header;
    private String text;
    private int rating;
    private UserDto user;
    private ReviewStatusDto reviewStatus;

    public ReviewDto(int reviewId, String header, String text, int rating, UserDto user, ReviewStatusDto reviewStatus) {
        this.reviewId = reviewId;
        this.header = header;
        this.text = text;
        this.rating = rating;
        this.user = user;
        this.reviewStatus = reviewStatus;
    }

    public ReviewDto() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ReviewStatusDto getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatusDto reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}
