package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);

    List<User> findByEmailLike(String email);

    boolean existsByEmail(String email);

}
