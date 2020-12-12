package com.algaworks.algafood.testes.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = context.getBean(RestauranteRepository.class);
		
		CozinhaRepository cozinhaRepository = context.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = cozinhaRepository.buscar(1L);
		Cozinha cozinha2 = cozinhaRepository.buscar(2L);
		Cozinha cozinha3 = cozinhaRepository.buscar(3L);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Casa Tailandia");
		restaurante1.setTaxaFrete(BigDecimal.valueOf(8.00));
		restaurante1.setCozinha(cozinha1);

		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Sabores Delivery");
		restaurante2.setCozinha(cozinha2);
		restaurante2.setTaxaFrete(BigDecimal.valueOf(5.50));
		
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setNome("Dona Mama Massas e Pizzas");
		restaurante3.setCozinha(cozinha3);
		restaurante3.setTaxaFrete(BigDecimal.valueOf(6.00));

		restauranteRepository.salvar(restaurante1);
		restauranteRepository.salvar(restaurante2);
		restauranteRepository.salvar(restaurante3);

		for (Restaurante r : restauranteRepository.listar()) {
			System.out.printf("%s - %s\n", r.getNome(), r.getCozinha().getNome());
		}
	}
}
