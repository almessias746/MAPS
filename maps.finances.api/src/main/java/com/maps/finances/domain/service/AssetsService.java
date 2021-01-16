package com.maps.finances.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Assets;
import com.maps.finances.domain.repository.AssetsRepository;


@Service
public class AssetsService {

	@Autowired
	private AssetsRepository repository;
	
	public List<Assets> retriveAll(){
		return (List<Assets>) this.repository.findAll();	
	}

	public Optional<Assets> retriveId(Long id){
		return this.repository.findById(id);
	}
	
	public Assets save(Assets assets){
		try {
			return this.repository.save(assets);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Já existe um cadastro!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public void delete(Assets assets){
		try {
			this.repository.delete(assets);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não pode ser removido!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser deletado!"));
		}
	}
	
}
