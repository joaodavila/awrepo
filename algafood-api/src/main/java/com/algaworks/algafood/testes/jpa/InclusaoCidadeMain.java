package com.algaworks.algafood.testes.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class InclusaoCidadeMain {

	public static void main(String[] args) {

		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidadeRepository = context.getBean(CidadeRepository.class);
		
		EstadoRepository estadoRepository = context.getBean(EstadoRepository.class);
		
		Estado estado1 = estadoRepository.buscar(1L);
		Estado estado2 = estadoRepository.buscar(2L);
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Bananias");
		cidade1.setEstado(estado1);

		Cidade cidade2 = new Cidade();
		cidade2.setNome("Porozinho do Sul");
		cidade2.setEstado(estado2);

		cidadeRepository.salvar(cidade1);
		cidadeRepository.salvar(cidade2);

		for (Cidade cidade : cidadeRepository.listar()) {
			System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
		}
	}
}