package com.biblioteca.locacaospringjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.biblioteca.locacaospringjpa.model.Endereco;
import com.biblioteca.locacaospringjpa.service.EnderecoService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public CommandLineRunner run(ApplicationSample sample) throws Exception {
        return args -> {
        	//if(sample.cadastrarCadastro().equals(sample))
        		//sample.cadastrarCadastro();
        	
        	/*Endereco endereco = new Endereco();
        	
        	endereco = EnderecoService.RecuperaEndereco("31742527");
        	
        	System.out.print(endereco.getBairro());*/
        	
        	//console.log(endereco);
        	
        };
    }

}
