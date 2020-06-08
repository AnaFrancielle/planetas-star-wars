package com.b2w.controller;

import com.b2w.dto.ResponseDto;
import com.b2w.excecao.PlanetaNaoEncontradoException;
import com.b2w.excecao.SwapiException;
import com.b2w.excecao.ValidacaoPlanetaDtoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroController {

    @ExceptionHandler(value = ValidacaoPlanetaDtoException.class)
    public ResponseEntity<ResponseDto> erro(ValidacaoPlanetaDtoException exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro(exception.getMensagem());

        return ResponseEntity.unprocessableEntity().body(responseDto);
    }

    @ExceptionHandler(value = PlanetaNaoEncontradoException.class)
    public ResponseEntity<ResponseDto> erro(PlanetaNaoEncontradoException exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro(exception.getMensagem());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    @ExceptionHandler(value = HttpMediaTypeException.class)
    public ResponseEntity<ResponseDto> erro(HttpMediaTypeException exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro("Só aceitamos JSON...");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

    @ExceptionHandler(value = SwapiException.class)
    public ResponseEntity<ResponseDto> erro(SwapiException exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro(exception.getMensagem());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDto> erro(Exception exception){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErro("Ooops..alguma coisa deu errada.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }
}
