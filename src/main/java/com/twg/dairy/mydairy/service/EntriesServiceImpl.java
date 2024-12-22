package com.twg.dairy.mydairy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.dairy.mydairy.entity.EntriesEntity;
import com.twg.dairy.mydairy.repository.EntriesRepository;


@Service
public class EntriesServiceImpl implements EntriesService {

	
	@Autowired 
	private EntriesRepository entriesRepository;
	
	
	@Override
	public EntriesEntity saveEntries(EntriesEntity entriesEntity) {
		// TODO Auto-generated method stub
		return entriesRepository.save(entriesEntity);
	}

	@Override
	public EntriesEntity updateEntries(EntriesEntity entriesEntity) {
		// TODO Auto-generated method stub
		return entriesRepository.save(entriesEntity);
	}

	@Override
	public void deleteEntries(EntriesEntity entriesEntity) {
		// TODO Auto-generated method stub
		entriesRepository.save(entriesEntity);

	}

	@Override
	public EntriesEntity findById(long id) {
		// TODO Auto-generated method stub
		return entriesRepository.findById(id).get();
	}

	@Override
	public List<EntriesEntity> findAll() {
		// TODO Auto-generated method stub
		return entriesRepository.findAll();
	}

}
