package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.enums.TipoPessoa;
import com.maninho.Sistema.maninho.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteFisicoRequestDTO {

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

    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setTipoPessoa(TipoPessoa.FISICA);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setRg(this.rg);
        cliente.setEndereco(this.endereco);
        cliente.setBairro(this.bairro);
        cliente.setCidade(this.cidade);
        cliente.setUf(this.uf);
        cliente.setCep(this.cep);
        cliente.setNumero(this.numero);
        return cliente;
    }

}
