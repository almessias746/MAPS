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

import com.maps.finances.domain.adapter.AssetsAdapter;
import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Assets;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/assets")
@Api(value = "Assets")
public class AssetsController {

	@Autowired
	private AssetsAdapter assetsAdapter; 
	
	@GetMapping
	@ApiOperation(value = "Busca todos os Ativos Financeiros cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista dos Ativos Financeiros cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public List<Assets> getAll() {
		return this.assetsAdapter.getRetriveAll();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Busca um Ativo Financeiro cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um Ativo Financeiro cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Assets> get(@PathVariable  Long id) {
		Optional<Assets> assets = this.assetsAdapter.getRetriveId(id);
		if (assets.isPresent()) {
			return ResponseEntity.ok(assets.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Adiciona um Ativo Financeiro na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna o Ativo Financeiro cadastrada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> add(@RequestBody Assets assets) {
		try {
			assets = this.assetsAdapter.postSave(assets);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(assets);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um Ativo Financeiro na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna o Ativo Financeiro atualizado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> update(@PathVariable Long id,
			@RequestBody Assets assets) {
		try {
			Optional<Assets> assetsUpdt = this.assetsAdapter.getRetriveId(id);
			if (assetsUpdt.isPresent()) {
				BeanUtils.copyProperties(assets, assetsUpdt, "id");
				assets = this.assetsAdapter.postSave(assetsUpdt.get());
				return ResponseEntity.ok(assets);
			}
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um Ativo Financeiro na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um ok"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Assets> erase(@PathVariable Long id) {
		try {
			Optional<Assets> assetsDlt = this.assetsAdapter.getRetriveId(id);
			if (assetsDlt.isPresent()) {
				this.assetsAdapter.postDelete(assetsDlt.get());
				return ResponseEntity.ok().build();
			}
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
