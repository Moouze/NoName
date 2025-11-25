package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.model.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "A senha não pode estar vazia")
    @Size(min = 6, max = 33, message = "a senha deve ter no minimo 6 e no maximo 33")
    private String password;
    @Email(message = "O e-mail informado é inválido")
    private String login;

    public Users converterParaEntidade (){

        Users user = new Users();
        user.setPassword(this.password);
        user.setLogin(this.login);
        return user;
    }
}
