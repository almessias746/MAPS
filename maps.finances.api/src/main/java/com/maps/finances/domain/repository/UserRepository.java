package com.maps.finances.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maps.finances.domain.model.User;

@Repository
public interface  UserRepository extends JpaRepository<User,Long>{
	
}
