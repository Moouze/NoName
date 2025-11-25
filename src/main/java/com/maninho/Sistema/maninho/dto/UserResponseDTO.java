package com.maninho.Sistema.maninho.dto;

import com.maninho.Sistema.maninho.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;

    private String login;


    public static UserResponseDTO ConverterParaDto (Users users){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(users.getId());
        dto.setLogin(users.getLogin());
        return dto;
    }

}
