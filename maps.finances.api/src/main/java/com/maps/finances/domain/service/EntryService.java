package com.maps.finances.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Entry;
import com.maps.finances.domain.repository.EntryRepository;


@Service
public class EntryService {

	@Autowired
	private EntryRepository repository;
	
	public List<Entry> retriveAll(){
		return (List<Entry>) this.repository.findAll();	
	}

	public Optional<Entry> retriveId(Long id){
		return this.repository.findById(id);
	}
	
	public Entry save(Entry entry){
		try {
			return this.repository.save(entry);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Já existe um cadastro!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public void delete(Entry entry){
		try {
			this.repository.delete(entry);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não pode ser removido!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser deletado!"));
		}
	}
	
}
