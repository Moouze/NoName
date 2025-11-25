package com.maninho.Sistema.maninho.services;

import com.maninho.Sistema.maninho.dto.ProdutoRequestDTO;
import com.maninho.Sistema.maninho.dto.ProdutoResponseDTO;
import com.maninho.Sistema.maninho.model.Produto;
import com.maninho.Sistema.maninho.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto){
        Produto produto = dto.converterParaEntidade();

        produto = produtoRepository.save(produto);

        return ProdutoResponseDTO.ConverterParaDTO(produto);
    }

    public List<ProdutoResponseDTO> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(ProdutoResponseDTO::ConverterParaDTO)
                .collect(Collectors.toList());
    }

    public void excluirProduto(Long id){

        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado"));

        produtoRepository.delete(produto);
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO dto){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setCodigo(dto.getCodigo());
        produto.setPreco(dto.getPreco());

        return ProdutoResponseDTO.ConverterParaDTO(produto);
    }
}
