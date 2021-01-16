package com.maps.finances.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maps.finances.domain.model.Assets_Type;

@Repository
public interface Assets_TypeRepository extends CrudRepository<Assets_Type, Long> {
	
}
