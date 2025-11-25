package com.maninho.Sistema.maninho.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoResponseDTO {

    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;

}
