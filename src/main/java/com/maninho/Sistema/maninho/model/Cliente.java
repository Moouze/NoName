package com.maninho.Sistema.maninho.model;
import com.maninho.Sistema.maninho.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_clientes")
@Entity
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    //anotação pro banco salvar como string e não como o ou 1!!!
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String razaoSocial;
    private String cnpj;
    private String ie;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;


    public String getNomeExibicao() {
        if (tipoPessoa == TipoPessoa.FISICA) {
            return this.nome;
        } else if (tipoPessoa == TipoPessoa.JURIDICA) {
            return this.razaoSocial;
        }
        return "Cliente desconhecido";
    }


}
