package com.twg.dairy.mydairy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.dairy.mydairy.entity.UsersEntity;
import com.twg.dairy.mydairy.repository.UsersRepository;


@Service
public class UsersServiceImpl implements UsersService {

	
	@Autowired
	private UsersRepository usersRepository;
	
	
	@Override
	public UsersEntity saveUser(UsersEntity usersEntity) {
		// TODO Auto-generated method stub
		return usersRepository.save(usersEntity);
	}

	@Override
	public UsersEntity updateUser(UsersEntity usersEntity) {
		// TODO Auto-generated method stub
		return usersRepository.save(usersEntity);
	}

	@Override
	public void deleteUser(UsersEntity usersEntity) {
		// TODO Auto-generated method stub

		usersRepository.delete(usersEntity);
	}

	@Override
	public UsersEntity findById(long id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).get();
	}

	@Override
	public List<UsersEntity> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	public UsersEntity findByUsername(String userName) {
		return usersRepository.findByUserName(userName);
	}

	

}
