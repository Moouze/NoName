package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String password;

    private String login;

    public Users converterParaEntidade (){

        Users user = new Users();
        user.setPassword(this.password);
        user.setLogin(this.login);
        return user;
    }
}
