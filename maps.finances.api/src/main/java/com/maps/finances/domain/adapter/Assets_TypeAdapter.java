package com.maps.finances.domain.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.domain.model.Assets_Type;
import com.maps.finances.domain.service.Assets_TypeService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Assets_TypeAdapter {

	@Autowired
	private Assets_TypeService assetsService;
	
	public List<Assets_Type> getRetriveAll(){
		log.info(" Executou o RetriveAll () "); 
		return assetsService.retriveAll();
	}
	
	public Optional<Assets_Type> getRetriveId(Long id){
		log.info(" Executou o RetriveId () "); 
		return assetsService.retriveId(id);
	}
	
	public Assets_Type postSave(Assets_Type assets_Type){
		log.info(" Executou o PostSave () "); 
		return assetsService.save(assets_Type);
	}
	
	public void postDelete(Assets_Type assets_Type){
		log.info(" Executou o Delete () "); 
		assetsService.delete(assets_Type);
	}
	
}
