package com.maps.finances.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.maps.finances.api.dto.SaldoDto;

@Service
public class SaldoService {

	public SaldoDto saldo( LocalDate data){
		
		return SaldoDto.builder()
				.saldo(new BigDecimal(1234.56))
				.build();
	}
	
}
