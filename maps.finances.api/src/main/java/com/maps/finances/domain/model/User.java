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
public class User {

		@EqualsAndHashCode.Include
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NonNull
		@Column(nullable = false)
		@ApiModelProperty(value = "Nome")
		private String name;

		@NonNull
		@Column(nullable = false)
		@ApiModelProperty(value = "Email")
		private String email;
				
		@Column(nullable = false)
		@ApiModelProperty(value = "Data de criação")
		private Date createdat;
		
		@Column(nullable = true)
		@ApiModelProperty(value = "Data da última atualização")
		private Date updatedat;
		
		
		@ApiModelProperty(value = "Perfil do usuário")
		@ManyToOne
		@JoinColumn(nullable = false)
		private Role role;
	
}
