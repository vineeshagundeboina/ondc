package com.twg.dairy.mydairy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.twg.dairy.mydairy.entity.EntriesEntity;



public interface EntriesService {
	
	
	public EntriesEntity saveEntries(EntriesEntity entriesEntity);

	public EntriesEntity updateEntries(EntriesEntity entriesEntity);

	public void deleteEntries(EntriesEntity entriesEntity);

	public EntriesEntity findById(long id);

	public List<EntriesEntity> findAll();

}
