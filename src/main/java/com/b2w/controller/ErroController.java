package com.b2w.controller;

import com.b2w.dto.ResponseDto;
import com.b2w.execoes.PlanetaNaoEncontradoException;
import com.b2w.execoes.ValidacaoPlanetaDtoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroController {

    @ExceptionHandler(value = ValidacaoPlanetaDtoException.class)
    public ResponseEntity<ResponseDto> erroValidacao(ValidacaoPlanetaDtoException exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro(exception.getMensagem());

        return ResponseEntity.unprocessableEntity().body(responseDto);
    }

    @ExceptionHandler(value = PlanetaNaoEncontradoException.class)
    public ResponseEntity<ResponseDto> erroNaoEncontrado(PlanetaNaoEncontradoException exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro(exception.getMensagem());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDto> erro(Exception exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro("Erro interno do servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }
}
