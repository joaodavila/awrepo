package com.algaworks.algafood.testes.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class ConsultaPermissoesMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		PermissaoRepository permissaoRepository = context.getBean(PermissaoRepository.class);
		
		for(Permissao permissao : permissaoRepository.listar()) {
			System.out.println(permissao.getNome() + " - " + permissao.getDescricao());
		}
	}
}
