package com.correa.apicep.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Manipulador global de exceções para fornecer respostas padronizadas para diferentes tipos de exceções.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Manipula a exceção CepInformadoErradoException e fornece uma resposta com detalhes do problema.
     * @param e A exceção CepInformadoErradoException lançada.
     * @return Um ResponseEntity com um objeto ProblemDetail, status HTTP NOT_FOUND e cabeçalhos padronizados.
     */
    @ExceptionHandler(CepInformadoErradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ProblemDetail> handleCepInformadoErradoException(CepInformadoErradoException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("CEP informado está errado ");
        problemDetail.setDetail("É preciso informar o CEP da seguinte forma ex: 01001000");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    /**
     * Manipula a exceção CepNaoEncontradoException e fornece uma resposta com detalhes do problema.
     * @param e A exceção CepNaoEncontradoException lançada.
     * @return Um ResponseEntity com um objeto ProblemDetail, status HTTP NOT_FOUND e cabeçalhos padronizados.
     */
    @ExceptionHandler(CepNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ProblemDetail> handleCepNaoEncontradoException(CepNaoEncontradoException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("CEP informado não existe ");
        problemDetail.setDetail("informar outro CEP");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }
}
