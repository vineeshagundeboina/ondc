package com.fedcorp.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedcorp.admin.entities.AdLoginUsers;

@Repository
public interface AdLoginUsersRepository  extends JpaRepository<AdLoginUsers, Long>{	
	
	
	 AdLoginUsers findByUsername(String username);

	AdLoginUsers findByUsernameAndIsFedservAndStatus(String username, boolean isFedserve, String status);

	AdLoginUsers findByUsernameAndIsFedserv(String username, boolean isFedserve);
	
}
