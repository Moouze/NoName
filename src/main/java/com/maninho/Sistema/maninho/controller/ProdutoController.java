package com.maninho.Sistema.maninho.controller;
import com.maninho.Sistema.maninho.dto.ProdutoRequestDTO;
import com.maninho.Sistema.maninho.dto.ProdutoResponseDTO;
import com.maninho.Sistema.maninho.model.Produto;
import com.maninho.Sistema.maninho.repositories.ProdutoRepository;
import com.maninho.Sistema.maninho.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {

        List<ProdutoResponseDTO> produtos = produtoService.listarProdutos();

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@RequestBody @Valid ProdutoRequestDTO dto) {

        ProdutoResponseDTO resposta = produtoService.cadastrarProduto(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> deletarProduto(@PathVariable Long id) {

        produtoService.excluirProduto(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO dto) {

        ProdutoResponseDTO resposta = produtoService.atualizarProduto(id, dto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resposta);
    }

}
