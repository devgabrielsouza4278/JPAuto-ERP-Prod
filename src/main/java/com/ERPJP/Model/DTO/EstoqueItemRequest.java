package com.ERPJP.Model.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueItemRequest {

    @NotNull (message = "O campo nome não pode estar vazio")
    @NotEmpty (message = "O campo nome não pode estar vazio")
    @Length(min = 2, max = 50,message = "Deve conter entre 2 e 50 caracteres")
    private String nome;

    @Length(min = 2, max = 50,message = "Deve conter entre 2 e 50 caracteres")
    private String descricao;

    @NotNull (message = "O campo descricao não pode estar vazio")
    @Range(min = 1,message = "Deve conter entre 1 e 3 caracteres")
    private Integer quantidade;

    @NotNull (message = "O campo categoria não pode estar vazio")
    @NotEmpty (message = "O campo categoria não pode estar vazio")
    @Length(min = 2, max = 50,message = "Deve conter entre 2 e 50 caracteres")
    private String categoria;
}
