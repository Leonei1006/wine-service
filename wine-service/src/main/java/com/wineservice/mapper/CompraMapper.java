package com.wineservice.mapper;

import com.wineservice.dto.CompraResponse;
import com.wineservice.dto.ProdutoResponse;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    public CompraResponse mapToCompraResponse(CompraResponse compra) {
        ProdutoResponse produtoResponse = ProdutoResponse.builder()
                .codigo(compra.getProduto().getCodigo())
                .tipoVinho(compra.getProduto().getTipoVinho())
                .preco(compra.getProduto().getPreco())
                .safra(compra.getProduto().getSafra())
                .anoCompra(compra.getProduto().getAnoCompra())
                .build();

        return CompraResponse.builder()
                .codigo(compra.getCodigo())
                .quantidade(compra.getQuantidade())
                .anoCompra(compra.getAnoCompra())
//                .nomeCliente(null) // Não precisamos do nome do cliente aqui
//                .cpfCliente(null) // Não precisamos do CPF do cliente aqui
                .produto(produtoResponse)
                .valorTotal(calcularValorTotal(compra))
                .build();
    }

    private double calcularValorTotal(CompraResponse compra) {
        return compra.getQuantidade() * compra.getProduto().getPreco();
    }
}
