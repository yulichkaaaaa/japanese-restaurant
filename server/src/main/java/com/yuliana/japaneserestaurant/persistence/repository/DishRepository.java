package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByCategory_DishCategoryId(short categoryId);

    List<Dish> findByName(String name);

    @Query("select d from Dish d join d.orderedDishes od group by d.dishId order by sum(od.count)")
    List<Dish> findAllDishesSortedByPopularity();

    @Query("select d from Dish d join d.favorites f where f.userId = :userId")
    List<Dish> findUserFavorites(int userId);
}
