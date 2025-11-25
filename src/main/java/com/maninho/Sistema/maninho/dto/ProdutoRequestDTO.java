package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    private String nome;
    private String codigo;
    private BigDecimal preco;

    public Produto converterParaEntidade() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setCodigo(this.codigo);
        produto.setPreco(this.preco);
        return produto;
    }
}
