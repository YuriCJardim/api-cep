package com.correa.apicep.controller;

import com.correa.apicep.entity.EnderecoPorCep;
import com.correa.apicep.exceptions.CepInformadoErradoException;
import com.correa.apicep.service.ConsultaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta classe representa o controlador REST para consulta de CEP.
 * Ela lida com solicitações HTTP relacionadas à consulta de CEP e
 * encaminha essas solicitações para o serviço apropriado.
 */

@RestController
@RequestMapping(value = "/cep-consulta")
public class ConsultaCepController {

    @Autowired
    private ConsultaCepService service;

    /**
     * Manipula solicitações GET para consultar informações de um CEP específico.
     * @param cep O CEP a ser consultado.
     * @return Um objeto ResponseEntity que contém os dados do endereço associado ao CEP.
     */
    @GetMapping(value = "/{cep}")
    public ResponseEntity<EnderecoPorCep> consultaCep(@PathVariable("cep") String cep) {
        return service.ConsultaCep(cep);
    }

}
