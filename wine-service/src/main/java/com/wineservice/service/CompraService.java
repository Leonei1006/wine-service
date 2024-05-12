package com.wineservice.service;

import com.wineservice.dto.CompraResponse;
import com.wineservice.dto.ProdutoResponse;
import com.wineservice.entity.Compra;
import com.wineservice.mapper.ProdutoMapper;
import com.wineservice.repository.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<CompraResponse> getComprasOrdenadasPorValor() {
        List<Compra> compras = compraRepository.findAll();

        List<Compra> comprasOrdenadas = compras.stream()
                .sorted((c1, c2) -> Double.compare(calcularValorTotal(c1), calcularValorTotal(c2)))
                .collect(Collectors.toList());

        return comprasOrdenadas.stream()
                .map(compra -> {
                    ProdutoResponse produtoResponse = produtoMapper.mapToProdutoResponse(compra.getProduto());
                    return CompraResponse.builder()
                            .codigo(compra.getCodigo())
                            .quantidade(compra.getQuantidade())
                            .anoCompra(compra.getAnoCompra())
                            .produto(produtoResponse)
                            .valorTotal(calcularValorTotal(compra))
                            .build();
                })
                .collect(Collectors.toList());
    }

    private double calcularValorTotal(Compra compra) {
        return compra.getQuantidade() * compra.getProduto().getPreco();
    }


}
