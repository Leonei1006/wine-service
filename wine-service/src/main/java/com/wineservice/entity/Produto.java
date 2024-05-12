package com.wineservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonProperty("codigo")
    private int codigo;
    @JsonProperty("tipo_vinho")
    private String tipoVinho;
    @JsonProperty("preco")
    private double preco;
    @JsonProperty("safra")
    private String safra;
    @JsonProperty("ano_compra")
    private int anoCompra;
    @ManyToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Compra> compras;

}
