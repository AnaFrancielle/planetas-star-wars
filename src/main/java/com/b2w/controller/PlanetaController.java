package com.b2w.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.dto.PlanetaDto;
import com.b2w.service.contrato.IPlanetaService;

@RestController
public class PlanetaController {

	@Autowired
	private IPlanetaService planetaService;
	
	@PostMapping(path = "/planetas")
	public ResponseEntity<PlanetaDto> adicionar(@RequestBody PlanetaDto planetaDto) {
		planetaDto = this.planetaService.adicionar(planetaDto);
		return ResponseEntity.ok(planetaDto);
	}

	@GetMapping(path = "/planetas")
	public ResponseEntity<List<PlanetaDto>> buscarTodos() {
		return ResponseEntity.ok(new ArrayList<>());
	}

	@GetMapping(path = "/planetas/:id")
	public ResponseEntity<PlanetaDto> buscarPorId(@RequestParam Long id) {
		return ResponseEntity.ok(new PlanetaDto());
	}

	@GetMapping(path = "/planetas/?busca=:palavraChave")
	public ResponseEntity<List<PlanetaDto>> buscarPorPalavraChave(@RequestParam String palavraChave) {
		return ResponseEntity.ok(new ArrayList<>());
	}

	@PutMapping(path = "/planetas/:id")
	public ResponseEntity<PlanetaDto> atualizar(@RequestParam Long id) {
		return ResponseEntity.ok(new PlanetaDto());
	}

	@DeleteMapping(path = "/planetas/:id")
	public ResponseEntity<PlanetaDto> remover(@RequestParam Long id) {
		return ResponseEntity.ok(new PlanetaDto());
	}

}
