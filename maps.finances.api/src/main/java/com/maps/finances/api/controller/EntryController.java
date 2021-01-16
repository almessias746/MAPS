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

import com.maps.finances.domain.adapter.EntryAdapter;
import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Entry;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/entry")
@Api(value = "Entry")
public class EntryController {

	@Autowired
	private EntryAdapter entryAdapter; 
	
	@GetMapping
	@ApiOperation(value = "Busca todos os Lançamentos cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista os Lançamentos cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public List<Entry> getAll() {
		return this.entryAdapter.getRetriveAll();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Busca um Lançamento cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um Lançamento cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Entry> get(@PathVariable  Long id) {
		Optional<Entry> entry = this.entryAdapter.getRetriveId(id);
		if (entry.isPresent()) {
			return ResponseEntity.ok(entry.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Adiciona um Lançamento na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um Lançamento cadastrada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> add(@RequestBody Entry entry) {
		try {
			entry = this.entryAdapter.postSave(entry);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(entry);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um Lançamento na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um Lançamento atualizada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> update(@PathVariable Long id,
			@RequestBody Entry entry) {
		try {
			Optional<Entry> entryUpdt = this.entryAdapter.getRetriveId(id);
			if (entryUpdt.isPresent()) {
				BeanUtils.copyProperties(entry, entryUpdt, "id");
				entry = this.entryAdapter.postSave(entryUpdt.get());
				return ResponseEntity.ok(entry);
			}
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um Lançamento na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um ok"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Entry> erase(@PathVariable Long id) {
		try {
			Optional<Entry> entryDlt = this.entryAdapter.getRetriveId(id);
			if (entryDlt.isPresent()) {
				this.entryAdapter.postDelete(entryDlt.get());
				return ResponseEntity.ok().build();
			}
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
