package com.ERPJP.Model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagemRetorno {
    CLIENTE_ID_NAO_ENCONTRADO("Nenhum cliente localizado com o id informado"),
    CLIENTE_CPF_NAO_ENCONTRADO("Nenhum cliente localizado com o CPF informado"),
    CLIENTE_NOME_NAO_ENCONTRADO("Nenhum cliente localizado com o nome informado"),
    CLIENTE_LISTA_NAO_ENCONTRADO("Nenhum cliente localizado"),
    CPF_JA_REGISTRADO("O CPF informado já está registrado"),
    CPF_INVALIDO ("O CPF informado é inválido"),
    ITEM_NOME_NAO_ENCONTRADO ("Nenhum item localizado com o nome informado"),
    ITEM_CATEGORIA_NAO_ENCONTRADO ("Nenhum item localizado com a categoria informada"),
    ITEM_NAO_ENCONTRADO ("Nenhum item localizado com o id informado"),
    ITEM_LISTA_NAO_ENCONTRADO ("Nenhum item foi localizado");


    private final String mensagem;
}
