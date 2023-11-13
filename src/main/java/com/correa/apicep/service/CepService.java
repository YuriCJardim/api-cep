package com.correa.apicep.service;

import com.correa.apicep.entity.Endereco;
import com.correa.apicep.exceptions.CepInformadoErradoException;
import com.correa.apicep.exceptions.CepNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço para consultar informações de CEP.
 * Esta classe lida com a consulta de informações de CEP usando a API ViaCep.
 */

@Service
public class CepService {

    /**
     * Consulta informações de endereço com base em um CEP fornecido.
     *
     * @param cep O CEP a ser consultado.
     * @return Um objeto ResponseEntity que contém os dados do endereço associado ao CEP.
     */
    public ResponseEntity<Endereco> consultaCep(String cep) {

        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);


        try {
            ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                if (response.getBody() != null && response.getBody().getCep() != null) {
                    return ResponseEntity.ok(response.getBody());
                } else {
                    throw new CepNaoEncontradoException(cep);
                }
            } else {
                throw new CepInformadoErradoException();
            }
        } catch (HttpClientErrorException.NotFound notFoundException) {
            throw new CepNaoEncontradoException(cep);
        } catch (HttpClientErrorException.BadRequest badRequestException) {
            throw new CepInformadoErradoException();
        }
    }
}
