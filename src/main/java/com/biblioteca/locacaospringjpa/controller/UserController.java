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
import com.biblioteca.locacaospringjpa.repository.CadastroRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@Autowired
	private CadastroRepository repository;

	@PostMapping("user")
	public String login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		Cadastro cadastro = new Cadastro();
		cadastro = repository.findByNome(username);
		String nome = cadastro.getLogin();
		String senha = cadastro.getSenha();
		if (senha.equals(pwd)  && nome.equals(username)) {
			String token = getJWTToken(username);	
			return token;
		} else {
			return "";
		}
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}