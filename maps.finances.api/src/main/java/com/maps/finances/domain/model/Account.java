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
public class Account {
	
	@ApiModelProperty(value = "Código da Conta")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Data de criação da Conta")
	@NonNull
	@Column(nullable = false)
	private Date createdat;
	
	@ApiModelProperty(value = "Data de atualização da Conta")
	@Column(nullable = true)
	private Date updatedat;
	
	@ApiModelProperty(value = "Habilita a conta")
	@NonNull
	@Column(nullable = false)
	private boolean enabled ;
	
	@ApiModelProperty(value = "Usuário")
	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;

}
