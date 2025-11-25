package com.maninho.Sistema.maninho.controller;
import com.maninho.Sistema.maninho.dto.*;
import com.maninho.Sistema.maninho.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/fisico")
    public ResponseEntity<ClienteFisicoResponseDTO> criarClienteFisico(@RequestBody @Valid ClienteFisicoRequestDTO dto) {

        ClienteFisicoResponseDTO resposta = clienteService.cadastrarClienteFisico(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/juridico")
    public ResponseEntity<ClienteJuridicoResponseDTO> criarClienteJuridico(@RequestBody @Valid ClienteJuridicoRequestDTO dto) {

        ClienteJuridicoResponseDTO resposta = clienteService.cadastrarClienteJuridico(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<Object>> buscarTodosClientes() {
        List<Object> clientesDTO = clienteService.buscarTodosClientes();
        return ResponseEntity.ok(clientesDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteFisicoResponseDTO> delete(@PathVariable Long id) {

        clienteService.excluirCliente(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/autocomplete")
    public List<ClienteAutoCompleteDTO> autocomplete(@RequestParam String nome) {
        return clienteService.buscarPorNome(nome);
    }


}


