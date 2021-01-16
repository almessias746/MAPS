package com.maps.finances.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.maps.finances.api.dto.ContaCorrenteDto;

@Service
public class ContaCorrenteService {

	public ContaCorrenteDto credito(){
		
		return ContaCorrenteDto.builder()
				.valor(new BigDecimal(12.42))
				.descricao("creditado")
				.data("2020-02-28")
				.build();
	}
	
	public ContaCorrenteDto debito(){
		
		return ContaCorrenteDto.builder()
				.valor(new BigDecimal(12.42))
				.descricao("debitado")
				.data("2020-02-28")
				.build();
	}
}
