package com.maninho.Sistema.maninho.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private LocalDate dataVencimento;
    private LocalDate dataPedido;
    private String nomeCliente;
    private String documento1;
    private String documento2;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;
    private List<ItemPedidoResponseDTO> itens;
    private BigDecimal valorTotal;

}
