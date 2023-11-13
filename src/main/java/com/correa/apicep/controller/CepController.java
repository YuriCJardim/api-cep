package com.correa.apicep.controller;

import com.correa.apicep.entity.Endereco;
import com.correa.apicep.service.CepService;
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
@RequestMapping(value = "/api/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService consultaCepService, CepService cepService) {
        this.cepService = cepService;
    }


        /**
         * Manipula solicitações GET para consultar informações de um CEP específico.
         * @param cep O CEP a ser consultado.
         * @return Um objeto ResponseEntity que contém os dados do endereço associado ao CEP.
         */
    @GetMapping(value = "/{cep}")
    public ResponseEntity<Endereco> consultaCep(@PathVariable("cep") String cep) {
        return cepService.consultaCep(cep);
    }

}
