package com.biblioteca.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Cadastro;
import com.biblioteca.model.Sessao;
import com.biblioteca.repository.CadastroRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {
	
	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Sessao logar(String login, String senha) {
		
		if (login == null || senha==null) {
			throw new RuntimeException("Login e senha são requeridos");
		}
		
		Cadastro cadastro = repository.findByLogin(login);
		
		if(cadastro == null) {
			throw new RuntimeException("Login inválido!");
		}
		
		boolean validaSenha = encoder.matches(senha, cadastro.getSenha());
		
		if(!validaSenha) {
			throw new RuntimeException("Senha inválida!");
		}
		
		Sessao sessao = new Sessao();
		
		sessao = getJWTToken(login);
		
		return sessao;
		
	}
	
	private Sessao getJWTToken(String login) {
		String secretKey = "mySecretKey";
		Sessao sessao = new Sessao();
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		Date dataFim = new Date(System.currentTimeMillis() + 3600000);
		String token = Jwts.builder().setId("softtekJWT").setSubject(login)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(dataFim)
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		sessao.setLogin(login);
		sessao.setDataInicio(new Date(System.currentTimeMillis()));
		sessao.setToken("Bearer " + token);
		sessao.setDataFim(dataFim);
		return  sessao;
	}
	
}
