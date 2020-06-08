package com.b2w.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "planeta")
@Getter @Setter @NoArgsConstructor
public class Planeta {

	@Id
	private String id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "clima", nullable = false)
	private String clima;
	
	@Column(name = "terreno", nullable = false)
	private String terreno;

	@Column(name = "qtd_filmes")
	private Integer qtdFilmes;

}
