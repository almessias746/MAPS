package com.maps.finances.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Assets {
	
	@ApiModelProperty(value = "Código do Ativo Financeiro")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	@ApiModelProperty(value = "Nome")
	private String name;

	@ApiModelProperty(value = "Data de criação do Ativo Financeiro")
	@NonNull
	@Column(nullable = false)
	private Date createdat;
	
	@ApiModelProperty(value = "Data de atualização do Ativo Financeiro")
	@Column(nullable = true)
	private Date updatedat;
	
	@ApiModelProperty(value = "Habilita o Ativo Financeiro")
	@NonNull
	@Column(nullable = false)
	private boolean enabled ;

	@ApiModelProperty(value = "Tipo do Ativo Financeiro")
	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Assets_Type type;
	
	@ApiModelProperty(value = "Usuário")
	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;
	
	@ApiModelProperty(value = "Data de vencimento do Ativo Financeiro")
	@NonNull
	@Column(nullable = true)
	private Date dataVencimento;
	
	
	@ApiModelProperty(value = "Data de emissão do Ativo Financeiro")
	@NonNull
	@Column(nullable = true)
	private Date dataEmissao;
	

}
