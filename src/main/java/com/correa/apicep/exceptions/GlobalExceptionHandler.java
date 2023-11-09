package com.correa.apicep.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Manipulador global de exceções para fornecer respostas padronizadas para diferentes tipos de exceções.
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Manipula a exceção CepInformadoErradoException e fornece uma resposta com detalhes do problema.
     *
     * @param e A exceção CepInformadoErradoException lançada.
     * @return Um objeto ProblemDetail com detalhes do problema e status HTTP NOT_FOUND.
     */
    @ExceptionHandler(CepInformadoErradoException.class)
    ProblemDetail handleCepInformadoErradoException(CepInformadoErradoException e){

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("CEP informado está errado ");
        problemDetail.setDetail("É preciso informar o CEP da seguinte forma ex: 01001000");
        return problemDetail;


    }


}
