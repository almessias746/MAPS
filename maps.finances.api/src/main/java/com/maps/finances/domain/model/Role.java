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
public class Role {
	
		@ApiModelProperty(value = "Código do perfil")
		@EqualsAndHashCode.Include
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ApiModelProperty(value = "Descrição do perfil")
		@NonNull
		@Column(nullable = false)
		private String description;
		
		@ApiModelProperty(value = "Data de criação do perfil")
		@NonNull
		@Column(nullable = false)
		private Date createdat;
		
		@ApiModelProperty(value = "Data de atualização do perfil")
		@Column(nullable = true)
		private Date updatedat;
		
		@ApiModelProperty(value = "Habilita o perfil")
		@NonNull
		@Column(nullable = false)
		private boolean enabled ;
	
}
