package com.algaworks.algafood.testes.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormasPagamentoMain {
public static void main(String[] args) {
		
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = context.getBean(FormaPagamentoRepository.class);
		
		for(FormaPagamento formaPagamento : formaPagamentoRepository.listar()) {
			System.out.printf("%d - %s\n",formaPagamento.getId(),formaPagamento.getNome());
		}
	}

}
