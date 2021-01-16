package com.maps.finances.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entry {

	@ApiModelProperty(value = "Código do Lançamento")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Data de criação do Lançamento")
	@NonNull
	@Column(nullable = false)
	private Date createdat;
	
	@ApiModelProperty(value = "Data de atualização do Lançamento")
	@Column(nullable = true)
	private Date updatedat;
	
	@ApiModelProperty(value = "Habilita o lançamento")
	@NonNull
	@Column(nullable = false)
	private boolean enabled ;
	
	@ApiModelProperty(value = "Valor do Lançamento")
	@Column(nullable = false ,  precision = 8 , scale = 2 )
	private BigDecimal value;
	
	@ApiModelProperty(value = "Tipo do Lançamento 'C' Crédito 'D' Débito ")
	@Column(nullable = false ,  length = 1 )
	private String type;
	
	@ApiModelProperty(value = "Conta associada")
	@NonNull
	@OneToOne
	@JoinColumn(nullable = false)
	private Account account;
	
	@ApiModelProperty(value = "Data do movimento Lançamento")
	@NonNull
	@Column(nullable = false)
	private Date dataMovimento;
	
	
	
}
