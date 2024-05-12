package com.wineservice.service;

import com.wineservice.dto.ProdutoResponse;
import com.wineservice.entity.Produto;
import com.wineservice.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private static final String PRODUTOS_URL = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<ProdutoResponse> obterProdutos() {
        ResponseEntity<List<Produto>> response = restTemplate.exchange(
                PRODUTOS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Produto>>() {
                }
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            List<Produto> produtos = response.getBody();
            return produtos.stream()
                    .map(produtoMapper::mapToProdutoResponse)
                    .collect(Collectors.toList()).reversed();
        } else {
            throw new RuntimeException("Falha ao obter os dados dos produtos.");
        }
    }

}
