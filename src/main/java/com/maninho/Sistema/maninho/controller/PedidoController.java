package com.maninho.Sistema.maninho.controller;

import com.maninho.Sistema.maninho.dto.PedidoRequestDTO;
import com.maninho.Sistema.maninho.dto.PedidoResponseDTO;
import com.maninho.Sistema.maninho.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criar(@RequestBody @Valid PedidoRequestDTO dto) {
        PedidoResponseDTO pedidoCriado = pedidoService.criarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
    }
}
