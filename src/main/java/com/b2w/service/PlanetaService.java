package com.b2w.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.dto.PlanetaDto;
import com.b2w.repository.IPlanetaRepository;
import com.b2w.service.contrato.IPlanetaService;

@Service
public class PlanetaService implements IPlanetaService{

	//private IPlanetaMapper mapper;
	@Autowired
	private IPlanetaRepository planetaRepository;
	
	@Override
	public PlanetaDto adicionar(PlanetaDto planetaDto) {
		// TODO Auto-generated method stub
		return null;
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
