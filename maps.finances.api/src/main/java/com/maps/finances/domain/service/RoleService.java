package com.maps.finances.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Role;
import com.maps.finances.domain.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	public List<Role> retriveAll(){
		return this.repository.findAll();		
	}

	public Role retriveId(Long id){
		return this.repository.getOne(id);
	}
	
	public Role save(Role role){
		try {
			return this.repository.save(role);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Já existe um cadastro!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public void delete(Role role){
		try {
			this.repository.delete(role);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não pode ser removido!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser deletado!"));
		}
	}
	
}
