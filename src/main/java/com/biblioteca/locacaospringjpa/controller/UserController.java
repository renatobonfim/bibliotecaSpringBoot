package com.biblioteca.locacaospringjpa.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.locacaospringjpa.model.Cadastro;
import com.biblioteca.locacaospringjpa.model.Token;
import com.biblioteca.locacaospringjpa.repository.CadastroRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@Autowired
	private CadastroRepository repository;
	
	@PostMapping("user")
	public Token login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		Token token = new Token();
		Cadastro cadastro = new Cadastro();
		cadastro = repository.findByNome(username);
		String nome = cadastro.getLogin();
		String senha = cadastro.getSenha();
		if (senha.equals(pwd)  && nome.equals(username)) {
			token = getJWTToken(username);	
			return token;

		} else {
			return token;
		}
	}

	private Token getJWTToken(String username) {
		String secretKey = "mySecretKey";
		Token tokenObject = new Token();
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		Date exdata = new Date(System.currentTimeMillis() + 600000);
		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(exdata)
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		tokenObject.setToken("Bearer " + token);
		tokenObject.setDateExpiration(exdata);
		return  tokenObject;
	}
}