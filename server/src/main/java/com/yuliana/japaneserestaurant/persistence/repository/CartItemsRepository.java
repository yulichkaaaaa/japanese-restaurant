package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.CartItems;
import com.yuliana.japaneserestaurant.persistence.entity.CartItemsKey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemsRepository extends CrudRepository<CartItems, CartItemsKey> {
    List<CartItems> findByUser_UserId(int userId);
}
