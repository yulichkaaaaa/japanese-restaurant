package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.PromoCode;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PromoCodeRepository extends PagingAndSortingRepository<PromoCode, Integer> {
    Optional<PromoCode> findByName(String name);

    List<PromoCode> findByNameLike(String name);
}
