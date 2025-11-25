package com.maninho.Sistema.maninho.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteAutoCompleteDTO {

    private String nome;
    private Long id;
}
