package com.ERPJP.Model.Repositorios;

import com.ERPJP.Model.Entidades.EstoqueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueItemRepositorio extends JpaRepository<EstoqueItem, Long> {

    List<EstoqueItem> findByNomeIgnoreCaseContaining(String nome);

    List<EstoqueItem> findByCategoriaIgnoreCaseContaining(String categoria);

}
