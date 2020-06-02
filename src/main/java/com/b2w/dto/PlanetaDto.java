package com.b2w.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PlanetaDto {
	
	private Long id;
	private String nome;
	private String clima;
	private String terreno;

}
