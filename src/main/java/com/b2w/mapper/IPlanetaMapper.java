package com.b2w.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.b2w.dto.PlanetaDto;
import com.b2w.entity.Planeta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPlanetaMapper {

	IPlanetaMapper INSTANCE = Mappers.getMapper( IPlanetaMapper.class );
    
    PlanetaDto planetaToPlanetaDto(Planeta planeta);
    Planeta planetaDtoToPlaneta(PlanetaDto planetaDto);

    List<PlanetaDto> planetasToPlanetaDtos(List<Planeta> planetas);
    List<Planeta> planetaDtosToPlanetas(List<PlanetaDto> planetaDtos);
	
}
