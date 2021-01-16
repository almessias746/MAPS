package com.maps.finances.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maps.finances.api.dto.ContaCorrenteDto;
import com.maps.finances.domain.adapter.ContaCorrenteAdapter;

@RestController
@RequestMapping(value = "/contacorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteAdapter contaCorrenteAdapter; 
	
	@PostMapping("/credito")
	public ContaCorrenteDto credito() {
		return this.contaCorrenteAdapter.credito();
	}
	
	@PostMapping("/debito")
	public ContaCorrenteDto debito() {
		
		return this.contaCorrenteAdapter.debito();
	}
	
}
