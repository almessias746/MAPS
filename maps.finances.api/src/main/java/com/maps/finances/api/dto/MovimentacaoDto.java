package com.maps.finances.api.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovimentacaoDto {

	private String ativo;
	private String data;
	private Double quantidade;
	private BigDecimal valor;
	
}