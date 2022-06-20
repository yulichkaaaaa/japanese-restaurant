package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Column(name = "review_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column
    private String header;

    @Column
    private String text;

    @Column
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "review_status_id")
    private ReviewStatus reviewStatus;

    public Review(int reviewId, String header, String text, int rating) {
        this.reviewId = reviewId;
        this.header = header;
        this.text = text;
        this.rating = rating;
    }

    public Review() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatus reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}
