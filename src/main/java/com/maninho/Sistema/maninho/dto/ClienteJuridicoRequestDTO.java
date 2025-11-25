package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.enums.TipoPessoa;
import com.maninho.Sistema.maninho.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteJuridicoRequestDTO {

    private TipoPessoa tipoPessoa;
    private String razaoSocial;
    private String ie;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;

    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setTipoPessoa(TipoPessoa.JURIDICA);
        cliente.setRazaoSocial(this.razaoSocial);
        cliente.setIe(this.ie);
        cliente.setCnpj(this.cnpj);
        cliente.setEndereco(this.endereco);
        cliente.setBairro(this.bairro);
        cliente.setCidade(this.cidade);
        cliente.setUf(this.uf);
        cliente.setCep(this.cep);
        cliente.setNumero(this.numero);
        return cliente;
    }

}
