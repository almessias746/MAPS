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

import com.maps.finances.domain.adapter.UserAdapter;
import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User")
public class UserController {

	@Autowired
	private UserAdapter userAdapter; 
	
	@GetMapping
	@ApiOperation(value = "Busca todos as Users cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de Users cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public List<User> getAll() {
		return this.userAdapter.getRetriveAll();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Busca uma Users cadastrada na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a Users cadastradas"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<User> get(@PathVariable  Long id) {
		User user = this.userAdapter.getRetriveId(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Adiciona uma Users na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a Users cadastrada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> add(@RequestBody User user) {
		try {
			user = this.userAdapter.postSave(user);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(user);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza uma Users na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a Users atualizada"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<?> update(@PathVariable Long id,
			@RequestBody User user) {
		try {
			User userUpdt = this.userAdapter.getRetriveId(id);
			if (userUpdt != null) {
				BeanUtils.copyProperties(user, userUpdt, "id");
				if(userUpdt.getEmail().equals(user.getEmail())) {
					userUpdt = this.userAdapter.postSave(userUpdt);
					return ResponseEntity.ok(userUpdt);					
				} else {
					return ResponseEntity.badRequest()
							.body("Email não pode ser modificado!");
				}

			}
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove uma Users na base")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um ok"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<User> erase(@PathVariable Long id) {
		try {
			User userDlt = this.userAdapter.getRetriveId(id);
			if (userDlt != null) {
				this.userAdapter.postDelete(userDlt);
				return ResponseEntity.ok().build();
			}
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
