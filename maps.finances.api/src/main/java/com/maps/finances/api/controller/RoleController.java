package com.maps.finances.api.controller;

import java.util.List;

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

import com.maps.finances.domain.adapter.RoleAdapter;
import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Role;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/roles")
@Api(value = "Roles")
public class RoleController {

	@Autowired
	private RoleAdapter roleAdapter; 
	
	@GetMapping
	@ApiOperation(value = "Busca todos as Roles cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de Roles cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public List<Role> getAll() {
		return this.roleAdapter.getRetriveAll();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Busca uma Roles cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a Roles cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Role> get(@PathVariable  Long id) {
		Role role = this.roleAdapter.getRetriveId(id);
		if (role != null) {
			return ResponseEntity.ok(role);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Adiciona uma Roles na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a Roles cadastrada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> add(@RequestBody Role role) {
		try {
			role = this.roleAdapter.postSave(role);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(role);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza uma Roles na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a Roles atualizada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> update(@PathVariable Long id,
			@RequestBody Role role) {
		try {
			Role roleUpdt = this.roleAdapter.getRetriveId(id);
			if (roleUpdt != null) {
				BeanUtils.copyProperties(role, roleUpdt, "id");
				roleUpdt = this.roleAdapter.postSave(roleUpdt);
				return ResponseEntity.ok(roleUpdt);
			}
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove uma Roles na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um ok"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<Role> erase(@PathVariable Long id) {
		try {
			Role roleDlt = this.roleAdapter.getRetriveId(id);
			if (roleDlt != null) {
				this.roleAdapter.postDelete(roleDlt);
				return ResponseEntity.ok().build();
			}
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
