package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComFreteGratisSpec;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComNomeSemelhanteSpec;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome")
	Optional<Cozinha> cozinhaPorNome(String nome){
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome")
	List<Restaurante> restaurantesPorTaxaFrete(String nome, Long cozinhaId) {
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	@GetMapping("/restaurantes/por-nome-e-frete")
	List<Restaurante> restaurantesPorNomeFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	List<Restaurante> restaurantesPorNomeFrete(String nome) {
		
		
		  var comFreteGratis = new RestauranteComFreteGratisSpec(); 
		  var comNomeSemelhante = new RestauranteComNomeSemelhanteSpec(nome);
		 
		
		return restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante));
		//return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
	}

}
