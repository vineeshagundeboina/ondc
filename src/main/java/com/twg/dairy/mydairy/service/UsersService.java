package com.twg.dairy.mydairy.service;

import java.util.List;

import com.twg.dairy.mydairy.entity.UsersEntity;

public interface UsersService {

	public UsersEntity saveUser(UsersEntity usersEntity);

	public UsersEntity updateUser(UsersEntity usersEntity);

	public void deleteUser(UsersEntity usersEntity);

	public UsersEntity findById(long id);

	public List<UsersEntity> findAll();

}
