package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, 
					JpaSpecificationExecutor<Restaurante>{
	
	public final static String CONSULTAR_POR_NOME = "from Restaurante where nome like %:nome% and cozinha.id = :id";
	
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	//@Query(CONSULTAR_POR_NOME)
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
	
	//List<Restaurante>findByNomeContainingAndCozinhaId(String nome, Long cozinha);

}
