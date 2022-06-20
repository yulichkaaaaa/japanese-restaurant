package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

public interface ReviewStatusRepository extends CrudRepository<ReviewStatus, Short> {
}
