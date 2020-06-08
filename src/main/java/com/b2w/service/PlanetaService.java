package com.b2w.service;

import java.text.MessageFormat;
import java.util.List;

import com.b2w.excecao.PlanetaNaoEncontradoException;
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

    @Autowired
    private SwapiService swapiService;

    @Override
    public PlanetaDto adicionar(PlanetaDto planetaDto) {
		planetaDto.isValid();

        Planeta planeta = IPlanetaMapper.INSTANCE.planetaDtoToPlaneta(planetaDto);
        planeta.setQtdFilmes(swapiService.quantidadeFilmesPorPlaneta(planeta.getNome()));
        planeta = planetaRepository.save(planeta);

        return IPlanetaMapper.INSTANCE.planetaToPlanetaDto(planeta);
    }

    @Override
    public PlanetaDto atualizar(String id, PlanetaDto planetaDto) {
		Planeta planeta = planetaRepository.findById(id);

		if (planeta == null) {
            new PlanetaNaoEncontradoException(MessageFormat.format("Planeta com id {0} não encontrado", id));
        }

		if (planetaDto.getNome() != null && !planetaDto.getNome().trim().isEmpty()){
		    planeta.setNome(planetaDto.getNome());
        }

        if (planetaDto.getClima() != null && !planetaDto.getClima().trim().isEmpty()){
            planeta.setClima(planetaDto.getClima());
        }

        if (planetaDto.getTerreno() != null && !planetaDto.getTerreno().trim().isEmpty()){
            planeta.setTerreno(planetaDto.getTerreno());
        }

		planetaRepository.save(planeta);

		return IPlanetaMapper.INSTANCE.planetaToPlanetaDto(planeta);
    }

    @Override
    public void remover(String id) {
		Planeta planeta = planetaRepository.findById(id);

        if (planeta == null) {
            new PlanetaNaoEncontradoException(MessageFormat.format("Planeta com id {0} não encontrado", id));
        }

		planetaRepository.delete(planeta);
    }

    @Override
    public PlanetaDto buscarPorId(String id) {
        Planeta planeta = planetaRepository.findById(id);

        if (planeta == null) {
            new PlanetaNaoEncontradoException(MessageFormat.format("Planeta com id {0} não encontrado", id));
        }

        return IPlanetaMapper.INSTANCE.planetaToPlanetaDto(planeta);
    }

    @Override
    public List<PlanetaDto> buscar() {
        List<Planeta> planetas = planetaRepository.findAll();
        return IPlanetaMapper.INSTANCE.planetasToPlanetaDtos(planetas);
    }

    @Override
    public List<PlanetaDto> buscarPorPalavraChave(String palavraChave) {
		List<Planeta> planetas = planetaRepository.
                findByNomeLikeOrClimaLikeOrTerrenoLikeOrIdLike(palavraChave,palavraChave,palavraChave,palavraChave);
		return IPlanetaMapper.INSTANCE.planetasToPlanetaDtos(planetas);
    }

}

