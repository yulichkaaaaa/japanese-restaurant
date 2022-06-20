package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.Review;
import com.yuliana.japaneserestaurant.persistence.entity.ReviewStatus;
import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.service.dto.ReviewDto;
import com.yuliana.japaneserestaurant.service.dto.ReviewStatusDto;
import com.yuliana.japaneserestaurant.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoConverter implements DtoConverter<ReviewDto, Review> {

    @Override
    public ReviewDto convertToDto(Review review) {
        User user = review.getUser();
        UserDto userDto = new UserDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getAvatar());
        ReviewStatus reviewStatus = review.getReviewStatus();
        ReviewStatusDto reviewStatusDto = new ReviewStatusDto(
                reviewStatus.getReviewStatusId(),
                reviewStatus.getName());
        return new ReviewDto(
                review.getReviewId(),
                review.getHeader(),
                review.getText(),
                review.getRating(),
                userDto,
                reviewStatusDto);
    }

    @Override
    public Review convertToEntity(ReviewDto reviewDto) {
        return new Review(
                reviewDto.getReviewId(),
                reviewDto.getHeader(),
                reviewDto.getText(),
                reviewDto.getRating());
    }
}
