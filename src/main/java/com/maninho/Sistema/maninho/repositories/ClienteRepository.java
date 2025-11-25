package com.maninho.Sistema.maninho.repositories;

import com.maninho.Sistema.maninho.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByCnpj(String cnpj);

    @Query("SELECT c FROM Cliente c WHERE " +
            "LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%')) " +
            "OR LOWER(c.razaoSocial) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> findByNomeContainingIgnoreCase(@Param("nome") String nome);




}
