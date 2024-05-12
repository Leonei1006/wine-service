package com.wineservice.mapper;

import com.wineservice.dto.ProdutoResponse;
import com.wineservice.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoResponse mapToProdutoResponse(Produto produto) {
        return ProdutoResponse.builder()
                .codigo(produto.getCodigo())
                .tipoVinho(produto.getTipoVinho())
                .preco(produto.getPreco())
                .safra(produto.getSafra())
                .anoCompra(produto.getAnoCompra())
                .build();
    }
}
