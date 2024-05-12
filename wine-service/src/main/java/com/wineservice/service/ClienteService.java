package com.wineservice.service;

import com.wineservice.dto.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ClienteService {

    private static final String CLIENTES_URL = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json";

    @Autowired
    private RestTemplate restTemplate;

    public List<ClienteResponse> obterClientes() {
        ResponseEntity<List<ClienteResponse>> response = restTemplate.exchange(
                CLIENTES_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ClienteResponse>>() {}
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Falha ao obter os dados dos clientes.");
        }
    }
}
