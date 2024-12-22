package com.fedcorp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.UserPins;


@Repository
public interface UserPinsRepository extends JpaRepository<UserPins, Long> {

}
