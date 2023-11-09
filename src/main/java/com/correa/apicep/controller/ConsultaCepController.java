package com.correa.apicep.controller;

import com.correa.apicep.entity.EnderecoPorCep;
import com.correa.apicep.service.ConsultaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/cep-consulta")
public class ConsultaCepController {

    @Autowired
    private ConsultaCepService service;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<EnderecoPorCep> consultaCep(@PathVariable("cep") String cep) {
        return service.ConsultaCep(cep);
    }
}
