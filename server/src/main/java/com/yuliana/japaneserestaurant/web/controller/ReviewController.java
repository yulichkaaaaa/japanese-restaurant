package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.ReviewService;
import com.yuliana.japaneserestaurant.service.dto.ReviewDto;
import com.yuliana.japaneserestaurant.service.dto.ReviewStatusDto;
import com.yuliana.japaneserestaurant.service.exception.NotValidFieldsException;
import com.yuliana.japaneserestaurant.service.validator.ReviewValidator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewValidator reviewValidator;

    public ReviewController(ReviewService reviewService, ReviewValidator reviewValidator) {
        this.reviewService = reviewService;
        this.reviewValidator = reviewValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(reviewValidator);
    }

    @GetMapping
    public List<ReviewDto> findAll(@RequestParam(defaultValue = "") String sortCriteria,
                                   @RequestParam(defaultValue = "asc") String sortDirection,
                                   @RequestParam(defaultValue = "") String header) {
        return reviewService.findAllReviews(sortCriteria, sortDirection, header);
    }

    @PostMapping
    public void create(@Valid @RequestBody ReviewDto reviewDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }

        reviewService.addReview(reviewDto);
    }

    @PatchMapping("/{id}")
    public void updateStatus(@PathVariable int id, @RequestBody ReviewStatusDto reviewStatusDto) {
        reviewService.updateStatus(reviewStatusDto.getReviewStatusId(), id);
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findReviewById(id);
    }
}
