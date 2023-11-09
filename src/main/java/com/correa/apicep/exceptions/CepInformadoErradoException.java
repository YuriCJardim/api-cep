package com.correa.apicep.exceptions;

/**
 * Exceção lançada quando um CEP é informado de forma incorreta.
 * Esta exceção estende RuntimeException para indicar que é uma exceção não verificada.
 */
public class CepInformadoErradoException extends RuntimeException {

    /**
     * Construtor padrão que define a mensagem de erro padrão para a exceção.
     */
    public CepInformadoErradoException(){
        super("CEP informado está errado" );
    }
}
