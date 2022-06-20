package com.yuliana.japaneserestaurant.persistence.repository;

import com.yuliana.japaneserestaurant.persistence.entity.UserStatus;
import org.springframework.data.repository.CrudRepository;

public interface UserStatusRepository extends CrudRepository<UserStatus, Short> {
}
