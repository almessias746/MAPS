package com.maps.finances.domain.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.domain.model.Account;
import com.maps.finances.domain.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccountAdapter {

	@Autowired
	private AccountService accountService;
	
	public List<Account> getRetriveAll(){
		log.info(" Executou o RetriveAll () "); 
		return accountService.retriveAll();
	}
	
	public Optional<Account> getRetriveId(Long id){
		log.info(" Executou o RetriveId () "); 
		return accountService.retriveId(id);
	}
	
	public Account postSave(Account account){
		log.info(" Executou o PostSave () "); 
		return accountService.save(account);
	}
	
	public void postDelete(Account account){
		log.info(" Executou o Delete () "); 
		accountService.delete(account);
	}
	
}
