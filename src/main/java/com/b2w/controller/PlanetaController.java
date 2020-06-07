package com.b2w.controller;

import com.b2w.dto.PlanetaDto;
import com.b2w.dto.ResponseDto;
import com.b2w.service.contrato.IPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetaController {

	@Autowired
	private IPlanetaService planetaService;
	
	@PostMapping(path = "/planetas")
	public ResponseEntity<ResponseDto> adicionar(@RequestBody PlanetaDto planetaDto) {
		planetaDto = this.planetaService.adicionar(planetaDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetaDto);

		return ResponseEntity.ok(responseDto);
	}

	@GetMapping(path = "/planetas")
	@RequestMapping(path = "/planetas", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> buscarTodos() {
		List<PlanetaDto> planetas = this.planetaService.buscar();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetas);

		return ResponseEntity.ok(responseDto);
	}

	@GetMapping(path = "/planetas/{id}")
	public ResponseEntity<ResponseDto> buscarPorId(@PathVariable Long id) {
		PlanetaDto planetaDto = this.planetaService.buscar(id);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetaDto);

		return ResponseEntity.ok(responseDto);
	}

	@GetMapping(path = "/planetas/buscar/{palavraChave}")
	public ResponseEntity<ResponseDto> buscarPorPalavraChave(@PathVariable String palavraChave) {
		List<PlanetaDto> planetas = this.planetaService.buscar(palavraChave);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetas);

		return ResponseEntity.ok(responseDto);
	}

	@PutMapping(path = "/planetas/{id}")
	public ResponseEntity<ResponseDto> atualizar(@PathVariable Long id, @RequestBody PlanetaDto planetaDto) {
		planetaDto = this.planetaService.atualizar(id, planetaDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDados(planetaDto);

		return ResponseEntity.ok(responseDto);
	}

	@DeleteMapping(path = "/planetas/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		this.planetaService.remover(id);
		return ResponseEntity.ok().build();
	}

}
