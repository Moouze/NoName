package com.maninho.Sistema.maninho.repositories;

import com.maninho.Sistema.maninho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
