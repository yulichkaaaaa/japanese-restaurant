package com.yuliana.japaneserestaurant.service.dto;

public class ReviewStatusDto {
    private short reviewStatusId;
    private String name;

    public ReviewStatusDto(short reviewStatusId, String name) {
        this.reviewStatusId = reviewStatusId;
        this.name = name;
    }

    public ReviewStatusDto() {
    }

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
}
