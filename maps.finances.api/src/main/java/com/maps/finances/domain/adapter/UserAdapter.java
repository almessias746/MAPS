package com.maps.finances.domain.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.domain.model.User;
import com.maps.finances.domain.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserAdapter {

	@Autowired
	private UserService service;
	
	public List<User> getRetriveAll(){
		log.info(" Executou o RetriveAll () "); 
		return this.service.retriveAll();
	}
	
	public User getRetriveId(Long id){
		log.info(" Executou o RetriveId () "); 
		return this.service.retriveId(id);
	}
	
	public User postSave(User user){
		log.info(" Executou o PostSave () "); 
		return this.service.save(user);
	}
	
	public void postDelete(User user){
		log.info(" Executou o Delete () "); 
		this.service.delete(user);
	}
	
}
