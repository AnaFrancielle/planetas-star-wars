package com.b2w.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.b2w.dto.PlanetaDto;
import com.b2w.entity.Planeta;

@Mapper
public interface IPlanetaMapper {

	IPlanetaMapper INSTANCE = Mappers.getMapper( IPlanetaMapper.class );
    
    PlanetaDto planetaToCarDto(Planeta planeta);
    Planeta planetaDtoToPlaneta(PlanetaDto planetaDto);
	
}
