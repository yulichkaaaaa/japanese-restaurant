package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.DishCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishCategoryRepository extends CrudRepository<DishCategory, Short> {
}
