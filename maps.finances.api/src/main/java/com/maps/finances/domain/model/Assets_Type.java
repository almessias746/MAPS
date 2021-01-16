package com.maps.finances.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Assets_Type {
	
	@ApiModelProperty(value = "Código do Tipo Ativo Financeiro")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	@ApiModelProperty(value = "Nome")
	private String name;

	@ApiModelProperty(value = "Data de criação do Tipo Ativo Financeiro")
	@NonNull
	@Column(nullable = false)
	private Date createdat;
	
	@ApiModelProperty(value = "Data de atualização do Tipo Ativo Financeiro")
	@Column(nullable = true)
	private Date updatedat;
	
	@ApiModelProperty(value = "Habilita o Tipo Ativo Financeiro")
	@NonNull
	@Column(nullable = false)
	private boolean enabled ;
	

}
