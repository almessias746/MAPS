package com.maps.finances.domain.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.maps.finances.api.dto.MovimentacaoDto;
import com.maps.finances.domain.service.MovimentacaoService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MovimentacaoAdapter {

	@Autowired
	private MovimentacaoService movimentacaoService;
	
	public MovimentacaoDto compra(){
		log.info(" Executou a Compra de Movimentacao () "); 
		return this.movimentacaoService.compra();
	}

	public MovimentacaoDto venda(){
		log.info(" Executou a Venda de Movimentacao () "); 
		return this.movimentacaoService.venda();
	}
	
}
