package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Integer> {
    List<Review> findByHeader(String header);
    List<Review> findByReviewStatus_ReviewStatusId(short id);
}
