package com.maps.finances.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maps.finances.domain.adapter.Assets_TypeAdapter;
import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Assets_Type;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/assetsType")
@Api(value = "Assets Type")
public class Assets_TypeController {

	@Autowired
	private Assets_TypeAdapter assets_TypeAdapter; 
	
	@GetMapping
	@ApiOperation(value = "Busca todos os Tipos de Ativos Financeiros cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista dos Tipos de Ativos Financeiros cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public List<Assets_Type> getAll() {
		return this.assets_TypeAdapter.getRetriveAll();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Busca um tipo Ativo Financeiro cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um tipo Ativo Financeiro cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Assets_Type> get(@PathVariable  Long id) {
		Optional<Assets_Type> assets = this.assets_TypeAdapter.getRetriveId(id);
		if (assets.isPresent()) {
			return ResponseEntity.ok(assets.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Adiciona um Tipo de Ativo Financeiro na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um tipo de Ativo Financeiro cadastrada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> add(@RequestBody Assets_Type assets_Type) {
		try {
			assets_Type = this.assets_TypeAdapter.postSave(assets_Type);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(assets_Type);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um Tipo de Ativo Financeiro na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna o Tipo de Ativo Financeiro atualizado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> update(@PathVariable Long id,
			@RequestBody Assets_Type assets_Type) {
		try {
			Optional<Assets_Type> assets_TypeUpdt = this.assets_TypeAdapter.getRetriveId(id);
			if (assets_TypeUpdt.isPresent()) {
				BeanUtils.copyProperties(assets_Type, assets_TypeUpdt, "id");
				assets_Type = this.assets_TypeAdapter.postSave(assets_TypeUpdt.get());
				return ResponseEntity.ok(assets_Type);
			}
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um tipo de Ativo Financeiro na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um ok"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Assets_Type> erase(@PathVariable Long id) {
		try {
			Optional<Assets_Type> assets_TypeDlt = this.assets_TypeAdapter.getRetriveId(id);
			if (assets_TypeDlt.isPresent()) {
				this.assets_TypeAdapter.postDelete(assets_TypeDlt.get());
				return ResponseEntity.ok().build();
			}
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
