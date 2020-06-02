package com.b2w.service.contrato;

import java.math.BigDecimal;
import java.util.List;

import com.b2w.dto.PlanetaDto;

public interface IPlanetaService {

	PlanetaDto adicionar(PlanetaDto planetaDto);
	PlanetaDto atualizar(PlanetaDto planetaDto);
	void remover(Long id);
	PlanetaDto buscar(Long id);
	List<PlanetaDto> buscar();
	List<PlanetaDto> buscar(String palavraChave);
	BigDecimal buscarQuantidadeDeFilmes(String nomePlaneta);
	
}
