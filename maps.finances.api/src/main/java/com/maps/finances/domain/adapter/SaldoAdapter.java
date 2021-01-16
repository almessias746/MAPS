package com.maps.finances.domain.adapter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maps.finances.api.dto.SaldoDto;
import com.maps.finances.domain.service.SaldoService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SaldoAdapter {

	@Autowired
	private SaldoService saldoService;
	
	public SaldoDto saldo(LocalDate data){
		log.info(" Executou o Credito de Conta Corrente () "); 
		return this.saldoService.saldo(data);
	}
	
}
