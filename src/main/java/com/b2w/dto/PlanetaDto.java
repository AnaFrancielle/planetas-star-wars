package com.b2w.dto;

import java.io.Serializable;

import com.b2w.excecao.ValidacaoPlanetaDtoException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PlanetaDto implements Serializable {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer qtdFilmes;

	public void isValid(){
		if (this.nome == null || this.nome.trim().isEmpty()) {
			throw new ValidacaoPlanetaDtoException("O campo nome é obrigatório");
		}

		if (this.clima == null || this.clima.trim().isEmpty()) {
			throw new ValidacaoPlanetaDtoException("O campo clima é obrigatório");
		}

		if (this.terreno == null || this.terreno.trim().isEmpty()) {
			throw new ValidacaoPlanetaDtoException("O campo terreno é obrigatório");
		}
	}
}
