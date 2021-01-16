package com.maps.finances.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Assets_Type;
import com.maps.finances.domain.repository.Assets_TypeRepository;


@Service
public class Assets_TypeService {

	@Autowired
	private Assets_TypeRepository repository;
	
	public List<Assets_Type> retriveAll(){
		return (List<Assets_Type>) this.repository.findAll();	
	}

	public Optional<Assets_Type> retriveId(Long id){
		return this.repository.findById(id);
	}
	
	public Assets_Type save(Assets_Type assets_Type){
		try {
			return this.repository.save(assets_Type);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Já existe um cadastro!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public void delete(Assets_Type assets_Type){
		try {
			this.repository.delete(assets_Type);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não pode ser removido!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser deletado!"));
		}
	}
	
}
