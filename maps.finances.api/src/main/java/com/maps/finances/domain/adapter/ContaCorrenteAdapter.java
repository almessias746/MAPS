package com.maps.finances.domain.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.maps.finances.api.dto.ContaCorrenteDto;
import com.maps.finances.domain.service.ContaCorrenteService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ContaCorrenteAdapter {

	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	public ContaCorrenteDto credito(){
		log.info(" Executou o Credito de Conta Corrente () "); 
		return this.contaCorrenteService.credito();
	}

	public ContaCorrenteDto debito(){
		log.info(" Executou o Debito de Conta Corrente () "); 
		return this.contaCorrenteService.debito();
	}
	
}
