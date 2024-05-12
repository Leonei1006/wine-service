package com.wineservice.mapper;

import com.wineservice.dto.ClienteResponse;
import com.wineservice.dto.CompraResponse;
import com.wineservice.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClienteMapper {

    private final ClienteService clienteService;
    private final CompraMapper compraMapper;


    public List<ClienteResponse> mapToClienteResponse() {
        List<ClienteResponse> clientes = clienteService.obterClientes();
        return clientes.stream()
                .map(this::mapClienteResponse)
                .collect(Collectors.toList());
    }

    private ClienteResponse mapClienteResponse(ClienteResponse clienteResponse) {
        List<CompraResponse> comprasResponse = clienteResponse.getCompras().stream()
                .map(compraMapper::mapToCompraResponse)
                .collect(Collectors.toList());

        return ClienteResponse.builder()
                .nome(clienteResponse.getNome())
                .cpf(clienteResponse.getCpf())
                .compras(comprasResponse)
                .build();
    }
}

