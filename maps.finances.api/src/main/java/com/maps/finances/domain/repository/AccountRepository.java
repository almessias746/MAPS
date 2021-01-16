package com.maps.finances.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maps.finances.domain.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
}
