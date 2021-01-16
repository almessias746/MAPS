package com.maps.finances.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.maps.finances.api.dto.MovimentacaoDto;

@Service
public class MovimentacaoService {

	public MovimentacaoDto compra(){
		
		return MovimentacaoDto.builder()
				.valor(new BigDecimal(105.53))
				.data("2020-02-28")
				.ativo("ATIVO1")
				.quantidade(2.5)
				.build();
	}
	
	public MovimentacaoDto venda(){
		
		return MovimentacaoDto.builder()
				.valor(new BigDecimal(105.53))
				.data("2020-02-28")
				.ativo("ATIVO2")
				.quantidade(2.5)
				.build();
	}
}
