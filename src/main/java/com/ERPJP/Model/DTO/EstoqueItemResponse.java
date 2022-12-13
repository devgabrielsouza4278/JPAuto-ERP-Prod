package com.ERPJP.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueItemResponse {

    private  Long id;

    private String nome;

    private String descricao;

    private Integer quantidade;

    private String categoria;
}
