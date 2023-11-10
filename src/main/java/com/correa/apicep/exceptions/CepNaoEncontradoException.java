package com.correa.apicep.exceptions;

public class CepNaoEncontradoException extends RuntimeException{
    /**
     * Constructor that sets a custom error message for the exception.
     * @param cep The CEP that was not found.
     */
    public CepNaoEncontradoException(String cep){
        super("CEP não encontrado: " + cep);
    }
}
