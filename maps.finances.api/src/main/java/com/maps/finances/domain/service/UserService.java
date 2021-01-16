package com.maps.finances.domain.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maps.finances.domain.exception.EntidadeEmUsoException;
import com.maps.finances.domain.exception.EntidadeNaoEncontradaException;
import com.maps.finances.domain.model.User;
import com.maps.finances.domain.repository.RoleRepository;
import com.maps.finances.domain.repository.UserRepository;


@Service
public class UserService {
	
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository rolerepository;
	
	public List<User> retriveAll(){
		return this.repository.findAll();		
	}

	public User retriveId(Long id){
		try {
		return this.repository.getOne(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe %d cadastrado!" , id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public User save(User user){
		try {
			if(this.validarEmail(user.getEmail())) {
				return this.repository.save(user);	
			}else {
				throw new EntidadeNaoEncontradaException(
						String.format("Formato do email inválido!"));
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Já existe um cadastro!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser salva!"));
		}
	}
	
	public void delete(User user){
		try {
			this.repository.delete(user);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não pode ser removido!"));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Não pode ser deletado!"));
		}
	}
	
	public static boolean validarEmail(String email){
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	 }
	
}
