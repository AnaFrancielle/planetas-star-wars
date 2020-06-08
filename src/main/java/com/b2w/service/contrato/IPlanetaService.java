package com.b2w.service.contrato;

import java.math.BigDecimal;
import java.util.List;

import com.b2w.dto.PlanetaDto;

public interface IPlanetaService {

	PlanetaDto adicionar(PlanetaDto planetaDto);
	PlanetaDto atualizar(String id, PlanetaDto planetaDto);
	void remover(String id);
	PlanetaDto buscarPorId(String id);
	List<PlanetaDto> buscar();
	List<PlanetaDto> buscarPorPalavraChave(String palavraChave);
}
