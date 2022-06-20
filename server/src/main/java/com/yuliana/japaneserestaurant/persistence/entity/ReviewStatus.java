package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "review_statuses")
public class ReviewStatus {

    @Column(name = "review_status_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short reviewStatusId;

    @Column
    private String name;

    @OneToMany(mappedBy = "reviewStatus")
    private Set<Review> reviews;

    public short getReviewStatusId() {
        return reviewStatusId;
    }

    public void setReviewStatusId(short reviewStatusId) {
        this.reviewStatusId = reviewStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
