package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.ReviewDto;
import com.yuliana.japaneserestaurant.service.dto.ReviewStatusDto;

import java.util.List;

public interface ReviewService {

    /**
     * Add new review.
     *
     * @param reviewDto the {@code ReviewDto} object
     */
    void addReview(ReviewDto reviewDto);

    /**
     * Find all the reviews.
     *
     * @return list of the reviews
     */
    List<ReviewDto> findAllReviews(String sortType, String sortDirection, String header);

    /**
     * Find reviews by its status.
     *
     * @param status the {@code ReviewStatusDto} object
     * @return the {@code ReviewDtoObject}
     */
    List<ReviewDto> findReviewsByStatus(ReviewStatusDto status);

    /**
     * Find the review by its id.
     *
     * @param reviewId id of the review
     * @return the {@code ReviewDto} object
     */
    ReviewDto findReviewById(int reviewId);

    /**
     * Update status of the review by given status id.
     *
     * @param statusId id of the status
     * @param reviewId id of the review
     */
    void updateStatus(short statusId, int reviewId);
}
