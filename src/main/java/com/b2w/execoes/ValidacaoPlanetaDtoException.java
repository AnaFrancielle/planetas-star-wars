package com.b2w.execoes;

import lombok.Getter;

@Getter
public class ValidacaoPlanetaDtoException extends RuntimeException{

    private String mensagem;

    public ValidacaoPlanetaDtoException(String mensagem){
        this.mensagem = mensagem;
    }

}
