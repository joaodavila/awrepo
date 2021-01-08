package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.ColunaNulaNaoPermitidaEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	CozinhaRepository cozinhaRepository;

	public Restaurante gravar(Restaurante restaurante) {
		verificaColunasNulas(restaurante);
		
		Long cozinhaId = restaurante.getCozinha().getId();		
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com o sódigo %d", cozinhaId)));

		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}

	private void verificaColunasNulas(Restaurante restaurante) {
		String colunaNula = restaurante.getNome() == null ? "nome" : 
							restaurante.getTaxaFrete() == null ? "taxaFrete" : 
							restaurante.getCozinha() == null ? "Cozinha" : "";
		if(!colunaNula.isEmpty()) {
			throw new ColunaNulaNaoPermitidaEncontradaException(String.format("Coluna %s não pode ser nula", colunaNula));
		}
	}
	
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
			
		} catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe uma entidade com o código %d", restauranteId));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Restaurante de código %d não pode ser removido, "
											+ "pois está em uso", restauranteId));
		}
	}
}
