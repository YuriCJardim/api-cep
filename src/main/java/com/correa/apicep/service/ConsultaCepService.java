package com.correa.apicep.service;

import com.correa.apicep.entity.EnderecoPorCep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepService {


    public ResponseEntity<EnderecoPorCep> ConsultaCep(String cep) {

        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EnderecoPorCep> response = restTemplate.getForEntity(url, EnderecoPorCep.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }

    }

}
