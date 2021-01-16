package com.maps.finances.domain.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.domain.model.Entry;
import com.maps.finances.domain.service.EntryService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EntryAdapter {

	@Autowired
	private EntryService entryService;
	
	public List<Entry> getRetriveAll(){
		log.info(" Executou o RetriveAll () "); 
		return entryService.retriveAll();
	}
	
	public Optional<Entry> getRetriveId(Long id){
		log.info(" Executou o RetriveId () "); 
		return entryService.retriveId(id);
	}
	
	public Entry postSave(Entry entry){
		log.info(" Executou o PostSave () "); 
		return entryService.save(entry);
	}
	
	public void postDelete(Entry entry){
		log.info(" Executou o Delete () "); 
		entryService.delete(entry);
	}
	
}
