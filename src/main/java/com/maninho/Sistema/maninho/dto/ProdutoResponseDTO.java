package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String codigo;
    private BigDecimal preco;

    public static ProdutoResponseDTO ConverterParaDTO(Produto produto) {
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
        produtoResponseDTO.setId(produto.getId());
        produtoResponseDTO.setNome(produto.getNome());
        produtoResponseDTO.setCodigo(produto.getCodigo());
        produtoResponseDTO.setPreco(produto.getPreco());
        return produtoResponseDTO;
    }
}
