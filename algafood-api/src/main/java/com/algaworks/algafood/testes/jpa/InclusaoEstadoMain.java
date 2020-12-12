package com.algaworks.algafood.testes.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;


public class InclusaoEstadoMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		EstadoRepository estadoRepository = context.getBean(EstadoRepository.class);

		
		Estado estado1 = new Estado();
		estado1.setNome("Bahia");
		
		Estado estado2 = new Estado();
		estado2.setNome("Goias");
		
		estadoRepository.salvar(estado1);
		estadoRepository.salvar(estado2);
		
		for(Estado e : estadoRepository.listar()) {
			System.out.printf("%d - %s\n",e.getId(),e.getNome());
		}
	}
}
