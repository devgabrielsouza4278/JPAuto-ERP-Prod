package com.ERPJP.Model.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EstoqueItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    private Long idItem;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Integer quantidade;

    @Column
    private String categoria;
}
