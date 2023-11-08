package com.correa.apicep.controller;

import com.correa.apicep.entity.EnderecoPorCep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/cep-consulta")
public class ConsultaCepController {

     @GetMapping(value = "/{cep}")
     public EnderecoPorCep consultaCep(@PathVariable ("cep") String cep){
          String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
          RestTemplate restTemplate = new RestTemplate();
          ResponseEntity<EnderecoPorCep> response = restTemplate.getForEntity(url, EnderecoPorCep.class);
          return response.getBody();
     }
}
