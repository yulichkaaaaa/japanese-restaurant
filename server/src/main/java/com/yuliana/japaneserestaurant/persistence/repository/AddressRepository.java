package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    Optional<Address> findByUser_UserId(int userId);

    @Query("select a from Address a join a.orders o where o.orderId = :orderId")
    Optional<Address> findByOrderId(int orderId);

    @Query("select a from Address a join a.cafe c where a = c.address")
    List<Address> findCafeAddresses();
}
