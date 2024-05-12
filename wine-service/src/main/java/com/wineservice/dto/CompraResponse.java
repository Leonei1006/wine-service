package com.wineservice.dto;

import com.wineservice.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraResponse {

    private String codigo;
    private int quantidade;
    private int anoCompra;
    private String nomeCliente;
    private String cpfCliente;
    private ProdutoResponse produto;
    private double valorTotal;

}
