package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.Review;
import com.yuliana.japaneserestaurant.persistence.entity.ReviewStatus;
import com.yuliana.japaneserestaurant.persistence.repository.ReviewRepository;
import com.yuliana.japaneserestaurant.persistence.repository.ReviewStatusRepository;
import com.yuliana.japaneserestaurant.service.ReviewService;
import com.yuliana.japaneserestaurant.service.dto.ReviewDto;
import com.yuliana.japaneserestaurant.service.dto.ReviewStatusDto;
import com.yuliana.japaneserestaurant.service.dto.converter.ReviewDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import com.yuliana.japaneserestaurant.service.exception.ResourceAlreadyExistsException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewDtoConverter reviewConverter;
    private final ReviewStatusRepository reviewStatusRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewDtoConverter reviewConverter, ReviewStatusRepository reviewStatusRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
        this.reviewStatusRepository = reviewStatusRepository;
    }

    @Override
    public void addReview(ReviewDto reviewDto) {
        if (reviewRepository.existsById(reviewDto.getReviewId())) {
            throw new ResourceAlreadyExistsException();
        }

        reviewRepository.save(reviewConverter.convertToEntity(reviewDto));
    }

    @Override
    public List<ReviewDto> findAllReviews(String sortType, String sortDirection, String header) {
        List<Review> reviews;
        if (sortType != null && !sortType.isBlank()) {
            Sort sort = Sort.by(sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortType);
            reviews = (List<Review>) reviewRepository.findAll(sort);
        } else if (header != null && !header.isBlank()) {
            reviews = reviewRepository.findByHeader(header);
        } else {
            reviews = (List<Review>) reviewRepository.findAll();
        }

        return reviews.stream().map(reviewConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findReviewsByStatus(ReviewStatusDto status) {
        return reviewRepository
                .findByReviewStatus_ReviewStatusId(status.getReviewStatusId())
                .stream()
                .map(reviewConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto findReviewById(int reviewId) {
        return reviewRepository
                .findById(reviewId)
                .map(reviewConverter::convertToDto)
                .orElseThrow(NoSuchResourceException::new);
    }

    @Override
    public void updateStatus(short statusId, int reviewId) {
        ReviewStatus status = reviewStatusRepository.findById(statusId).orElseThrow(NoSuchResourceException::new);
        Review review = reviewRepository.findById(reviewId).orElseThrow(NoSuchResourceException::new);
        review.setReviewStatus(status);
        reviewRepository.save(review);
    }
}
