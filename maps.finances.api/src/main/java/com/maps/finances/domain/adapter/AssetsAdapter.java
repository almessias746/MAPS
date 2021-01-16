package com.maps.finances.domain.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.domain.model.Assets;
import com.maps.finances.domain.service.AssetsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AssetsAdapter {

	@Autowired
	private AssetsService assetsService;
	
	public List<Assets> getRetriveAll(){
		log.info(" Executou o RetriveAll () "); 
		return assetsService.retriveAll();
	}
	
	public Optional<Assets> getRetriveId(Long id){
		log.info(" Executou o RetriveId () "); 
		return assetsService.retriveId(id);
	}
	
	public Assets postSave(Assets assets){
		log.info(" Executou o PostSave () "); 
		return assetsService.save(assets);
	}
	
	public void postDelete(Assets assets){
		log.info(" Executou o Delete () "); 
		assetsService.delete(assets);
	}
	
}
