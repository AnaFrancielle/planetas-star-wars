package com.b2w.execoes;

import lombok.Getter;

@Getter
public class PlanetaNaoEncontradoException extends RuntimeException{

    private String mensagem;

    public PlanetaNaoEncontradoException(String mensagem){
        this.mensagem = mensagem;
    }

}
