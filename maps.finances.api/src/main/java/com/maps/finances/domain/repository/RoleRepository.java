package com.maps.finances.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maps.finances.domain.model.Role;

@Repository
public interface  RoleRepository  extends JpaRepository<Role, Long>{
	
}
