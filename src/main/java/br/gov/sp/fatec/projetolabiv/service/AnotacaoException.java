package br.gov.sp.fatec.projetolabiv.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnotacaoException extends RuntimeException{

    public AnotacaoException() {
        super();
    }

    public AnotacaoException(String mensagem) {
        super(mensagem);
    }
    
}
