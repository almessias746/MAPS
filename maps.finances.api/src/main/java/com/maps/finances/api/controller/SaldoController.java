package com.maps.finances.api.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maps.finances.api.dto.SaldoDto;
import com.maps.finances.domain.adapter.SaldoAdapter;

@RestController
@RequestMapping(value = "/saldo")
public class SaldoController {

	@Autowired
	private SaldoAdapter saldoAdapter; 
	
	/*
	 * ISO.DATE = yyyy-MM-dd
	 */
	@PostMapping("/saldo")
	public SaldoDto saldo( 
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
			@RequestParam(name="data" , required = true) LocalDate data ) {
		return this.saldoAdapter.saldo(data);
	}
	
	
}
