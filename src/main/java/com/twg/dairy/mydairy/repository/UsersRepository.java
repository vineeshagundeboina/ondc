package com.twg.dairy.mydairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twg.dairy.mydairy.entity.UsersEntity;


@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	UsersEntity findByUserName(String userName);


	//UsersEntity findByUsername(String userName);
	

	
}
 