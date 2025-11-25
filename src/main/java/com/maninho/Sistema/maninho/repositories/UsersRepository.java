package com.maninho.Sistema.maninho.repositories;

import com.maninho.Sistema.maninho.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
