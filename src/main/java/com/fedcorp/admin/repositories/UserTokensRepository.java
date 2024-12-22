package com.fedcorp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.UserTokens;

@Repository
public interface UserTokensRepository extends JpaRepository<UserTokens, Long> {

}
