package com.algaworks.algafood.testes.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class BuscaCidadeMain {
	
	public static void main(String[] args) {

		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidadeRepository = context.getBean(CidadeRepository.class);
		
		Cidade cidade = cidadeRepository.buscar(1l);

		System.out.printf("%d - %s\n",cidade.getId(), cidade.getNome());
	}
}
