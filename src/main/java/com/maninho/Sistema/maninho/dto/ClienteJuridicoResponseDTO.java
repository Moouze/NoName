package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.enums.TipoPessoa;
import com.maninho.Sistema.maninho.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteJuridicoResponseDTO {

    private Long id;
    private TipoPessoa tipoPessoa;
    private String razaoSocial;
    private String cnpj;
    private String ie;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;

    public static ClienteJuridicoResponseDTO fromEntity(Cliente cliente) {
        ClienteJuridicoResponseDTO dto = new ClienteJuridicoResponseDTO();

        dto.setTipoPessoa(cliente.getTipoPessoa());
        dto.setId(cliente.getId());
        dto.setRazaoSocial(cliente.getRazaoSocial());
        dto.setCnpj(cliente.getCnpj());
        dto.setIe(cliente.getIe());
        dto.setEndereco(cliente.getEndereco());
        dto.setBairro(cliente.getBairro());
        dto.setCidade(cliente.getCidade());
        dto.setUf(cliente.getUf());
        dto.setCep(cliente.getCep());
        dto.setNumero(cliente.getNumero());
        return dto;
    }
}
