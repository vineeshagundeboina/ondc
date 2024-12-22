package com.splenta.hrms.common;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.splenta.hrms.exception.NotFoundException;
import com.splenta.hrms.utilites.CopyPropertiesUtil;

@Service
public abstract class GenericService<T extends BaseEntity> {

	private final GenericRepository<T> repository;

	public GenericService(GenericRepository<T> repository) {
		this.repository = repository;
	}

	public Page<T> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public T get(UUID id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
	}

	@Transactional
	public T update(T updated) {
		T existing = get(updated.getId());
		CopyPropertiesUtil.copyProperties(updated, existing);
		return repository.save(existing);
	}

	@Transactional
	public T create(T entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(UUID id) {
		// check if object with this id exists
		get(id);
		repository.deleteById(id);
	}
}
