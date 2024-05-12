package com.wineservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponse {

    private int codigo;
    private String tipoVinho;
    private double preco;
    private String safra;
    private int anoCompra;
}
