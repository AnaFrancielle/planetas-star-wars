package com.b2w.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter @Setter @NoArgsConstructor
@Data
public class PlanetaDto implements Serializable {

	private Long id;
	private String nome;
	private String clima;
	private String terreno;
	private Long qtdDeFilmes;

}
