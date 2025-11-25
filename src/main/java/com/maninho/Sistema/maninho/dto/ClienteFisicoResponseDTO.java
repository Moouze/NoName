package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.enums.TipoPessoa;
import com.maninho.Sistema.maninho.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteFisicoResponseDTO {

    private Long id;
    private TipoPessoa tipoPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;

    public static ClienteFisicoResponseDTO fromEntity(Cliente cliente) {
        ClienteFisicoResponseDTO dto = new ClienteFisicoResponseDTO();

        dto.setTipoPessoa(cliente.getTipoPessoa());
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setRg(cliente.getRg());
        dto.setEndereco(cliente.getEndereco());
        dto.setBairro(cliente.getBairro());
        dto.setCidade(cliente.getCidade());
        dto.setUf(cliente.getUf());
        dto.setCep(cliente.getCep());
        dto.setNumero(cliente.getNumero());
        return dto;
    }
}
