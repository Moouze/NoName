package com.maninho.Sistema.maninho.repositories;

import com.maninho.Sistema.maninho.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    //função para validar no banco se já existe um usuário com o e-mail cadastrado
    boolean existsByLogin (String login);

}
