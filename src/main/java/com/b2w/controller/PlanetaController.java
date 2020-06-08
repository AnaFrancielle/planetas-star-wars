package com.b2w.controller;

import com.b2w.dto.PlanetaDto;
import com.b2w.dto.ResponseDto;
import com.b2w.service.contrato.IPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetaController {

	@Autowired
	private IPlanetaService planetaService;
	
	@PostMapping(path = "/planetas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> adicionar(@RequestBody PlanetaDto planetaDto) {
		planetaDto = this.planetaService.adicionar(planetaDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetaDto);

		return ResponseEntity.ok(responseDto);
	}

	@GetMapping(path = "/planetas", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(path = "/planetas", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> buscarTodos() {
		List<PlanetaDto> planetas = this.planetaService.buscar();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetas);

		return ResponseEntity.ok(responseDto);
	}

	@GetMapping(path = "/planetas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> buscarPorId(@PathVariable String id) {
		PlanetaDto planetaDto = this.planetaService.buscarPorId(id);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetaDto);

		return ResponseEntity.ok(responseDto);
	}

	@GetMapping(path = "/planetas/busca={palavraChave}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> buscarPorPalavraChave(@PathVariable String palavraChave) {
		List<PlanetaDto> planetas = this.planetaService.buscarPorPalavraChave(palavraChave);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetas);

		return ResponseEntity.ok(responseDto);
	}

	@PutMapping(path = "/planetas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> atualizar(@PathVariable String id, @RequestBody PlanetaDto planetaDto) {
		planetaDto = this.planetaService.atualizar(id, planetaDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetaDto);

		return ResponseEntity.ok(responseDto);
	}

	@DeleteMapping(path = "/planetas/{id}")
	public ResponseEntity<Void> remover(@PathVariable String id) {
		this.planetaService.remover(id);
		return ResponseEntity.ok().build();
	}

}
