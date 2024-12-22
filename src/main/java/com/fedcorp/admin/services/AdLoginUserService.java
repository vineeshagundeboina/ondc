package com.fedcorp.admin.services;

import com.fedcorp.admin.entities.LoginUser;


public interface AdLoginUserService {
	
	LoginUser logincheck(String adUsername);

}
