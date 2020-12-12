package com.algaworks.algafood.testes.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;


public class InclusaoCozinhaMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		CozinhaRepository cozinhaRepository = context.getBean(CozinhaRepository.class);

		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinhaRepository.salvar(cozinha1);
		cozinhaRepository.salvar(cozinha2);
		
		for(Cozinha c : cozinhaRepository.listar()) {
			System.out.printf("%d - %s\n",c.getId(),c.getNome());
		}
		/*
		 * System.out.printf("%d - %s\n",cozinha1.getId(),cozinha1.getNome());
		 * System.out.printf("%d - %s\n",cozinha2.getId(),cozinha2.getNome());
		 */
	}
}
