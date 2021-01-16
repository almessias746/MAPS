package com.maps.finances.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maps.finances.domain.model.Assets;

@Repository
public interface AssetsRepository extends CrudRepository<Assets, Long> {
	
}
