package com.b2w.excecao;

import lombok.Getter;

@Getter
public class SwapiException extends RuntimeException{

    private String mensagem;

    public SwapiException(){
        this.mensagem = "Um erro ocorreu ao tentar acessar a api Swapi";
    }

}
