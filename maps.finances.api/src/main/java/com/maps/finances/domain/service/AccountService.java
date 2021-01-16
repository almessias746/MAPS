package com.maps.finances.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.Account;
import com.maps.finances.domain.repository.AccountRepository;


@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	public List<Account> retriveAll(){
		return (List<Account>) this.repository.findAll();	
	}

	public Optional<Account> retriveId(Long id){
		return this.repository.findById(id);
	}
	
	public Account save(Account account){
		try {
			return this.repository.save(account);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Já existe um cadastro!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public void delete(Account account){
		try {
			this.repository.delete(account);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não pode ser removido!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser deletado!"));
		}
	}
	
}
