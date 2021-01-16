package com.maps.finances.domain.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.domain.model.Role;
import com.maps.finances.domain.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RoleAdapter {

	@Autowired
	private RoleService roleService;
	
	public List<Role> getRetriveAll(){
		log.info(" Executou o RetriveAll () "); 
		return roleService.retriveAll();
	}
	
	public Role getRetriveId(Long id){
		log.info(" Executou o RetriveId () "); 
		return roleService.retriveId(id);
	}
	
	public Role postSave(Role role){
		log.info(" Executou o PostSave () "); 
		return roleService.save(role);
	}
	
	public void postDelete(Role role){
		log.info(" Executou o Delete () "); 
		roleService.delete(role);
	}
	
}
