package com.wineservice.controller;

import com.wineservice.dto.CompraResponse;
import com.wineservice.service.ClienteService;
import com.wineservice.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<CompraResponse>> getComprasOrdenadasPorValor() {
        List<CompraResponse> comprasOrdenadas = compraService.getComprasOrdenadasPorValor();
        return ResponseEntity.ok(comprasOrdenadas);
    }
}


