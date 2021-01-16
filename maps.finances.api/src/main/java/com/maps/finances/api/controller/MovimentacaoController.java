package com.maps.finances.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maps.finances.api.dto.MovimentacaoDto;
import com.maps.finances.domain.adapter.MovimentacaoAdapter;

@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoAdapter movimentacaoAdapter; 
	
	@PostMapping("/compra")
	public MovimentacaoDto compra() {
		return this.movimentacaoAdapter.compra();
	}
	
	@PostMapping("/venda")
	public MovimentacaoDto venda() {
		
		return this.movimentacaoAdapter.venda();
	}
	
}
