package com.b2w.service;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.dto.PlanetaDto;
import com.b2w.entity.Planeta;
import com.b2w.mapper.IPlanetaMapper;
import com.b2w.repository.IPlanetaRepository;
import com.b2w.service.contrato.IPlanetaService;

@Service
public class PlanetaService implements IPlanetaService {

	@Autowired
	private IPlanetaRepository planetaRepository;
	

	@Override
	public PlanetaDto adicionar(PlanetaDto planetaDto) {
		Planeta planeta = IPlanetaMapper.INSTANCE.planetaDtoToPlaneta(planetaDto);
		planeta = planetaRepository.save(planeta);
		return IPlanetaMapper.INSTANCE.planetaToPlanetaDto(planeta);
	}

	@Override
	public PlanetaDto atualizar(PlanetaDto planetaDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PlanetaDto buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanetaDto> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanetaDto> buscar(String palavraChave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal buscarQuantidadeDeFilmes(String nomePlaneta) {
		// TODO Auto-generated method stub
		return null;
	}

}
