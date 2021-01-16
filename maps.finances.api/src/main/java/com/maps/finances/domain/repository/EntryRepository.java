package com.maps.finances.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maps.finances.domain.model.Entry;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
	
}
