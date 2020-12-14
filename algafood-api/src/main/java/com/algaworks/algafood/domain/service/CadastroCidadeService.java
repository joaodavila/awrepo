package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	EstadoRepository estadoRepository;

	public Cidade gravar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();		
		Optional<Estado> estadoOptional = estadoRepository.findById(estadoId);
		
		if (estadoOptional.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe estado com o código %d", estadoId));
		}
		cidade.setEstado(estadoOptional.get());
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe uma entidade com o código %d", cidadeId));
		}catch(DataIntegrityViolationException e ) {
			throw new EntidadeEmUsoException(
					String.format("Cidade com o código %d não pode ser removida, pois está em uso", cidadeId));
		}
	}
}
