package com.wineservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("quantidade")
    private int quantidade;
    @JsonProperty("ano_compra")
    private int anoCompra;
    @ManyToOne
    @JoinTable(name = "produto_id")
    private Produto produto;

}