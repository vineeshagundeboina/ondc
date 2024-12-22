package com.twg.dairy.mydairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twg.dairy.mydairy.entity.EntriesEntity;

@Repository
public interface EntriesRepository extends JpaRepository<EntriesEntity,Long> {

	List<EntriesEntity> findByUsersEntityId(long id);

}
