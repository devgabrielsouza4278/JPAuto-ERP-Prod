package com.ERPJP.Model.Servicos;

import com.ERPJP.Model.DTO.EstoqueItemRequest;
import com.ERPJP.Model.DTO.EstoqueItemResponse;
import com.ERPJP.Model.Entidades.EstoqueItem;
import com.ERPJP.Model.Enum.MensagemRetorno;
import com.ERPJP.Model.Excecoes.NotFoundException;
import com.ERPJP.Model.Mapper.EstoqueItemMapper;
import com.ERPJP.Model.Repositorios.EstoqueItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueItemServico{
    @Autowired
    private EstoqueItemMapper mapper;
    @Autowired
    private EstoqueItemRepositorio repositorio;

    public EstoqueItemResponse salvarEstoqueItem (EstoqueItemRequest request) {
        EstoqueItem entidadeSalvar = mapper.paraEntidade(request);
        repositorio.save(entidadeSalvar);

        return mapper.paraResponse(entidadeSalvar);
}

    public EstoqueItemResponse consultarEstoqueItem (Long id) throws NotFoundException {
        validarEstoqueItem(id);
        Optional<EstoqueItem> obtemEstoqueItem = repositorio.findById(id);

        return mapper.paraResponse(obtemEstoqueItem.get());
    }

    public List<EstoqueItemResponse> consultarEstoqueItemLista () throws NotFoundException {
        validarEstoqueItemLista();
        List<EstoqueItem> obtemEstoqueItemLista = repositorio.findAll();

        return mapper.paraResponseList(obtemEstoqueItemLista);
    }

    public List<EstoqueItemResponse> consultarEstoqueItemListaCategoria (String categoria) throws NotFoundException {
        validarEstoqueItemLista();
        List<EstoqueItem> obtemEstoqueItemLista = repositorio.findByCategoriaIgnoreCaseContaining(categoria);

        if (obtemEstoqueItemLista.isEmpty()) {
            throw new NotFoundException(MensagemRetorno.ITEM_CATEGORIA_NAO_ENCONTRADO.getMensagem());
        } else {
            return mapper.paraResponseList(obtemEstoqueItemLista);

        }
    }

    public List<EstoqueItemResponse> consultarEstoqueItemListaNome (String nome) throws NotFoundException {
        validarEstoqueItemLista();
        List<EstoqueItem> obtemEstoqueItemLista = repositorio.findByNomeIgnoreCaseContaining(nome);

        if (obtemEstoqueItemLista.isEmpty()) {
            throw new NotFoundException(MensagemRetorno.ITEM_NOME_NAO_ENCONTRADO.getMensagem());
        } else {
            return mapper.paraResponseList(obtemEstoqueItemLista);

        }
    }

    public EstoqueItemResponse alterarEstoqueItem (EstoqueItemRequest request, Long id) throws NotFoundException {
        validarEstoqueItem(id);

        EstoqueItem estoqueItemAtualizado = mapper.paraEntidade(request);
        estoqueItemAtualizado.setIdItem(id);

        repositorio.save(estoqueItemAtualizado);

        return mapper.paraResponse(estoqueItemAtualizado);
    }

    public void apagarEstoqueItem (Long id) throws NotFoundException {
        validarEstoqueItem(id);
        repositorio.deleteById(id);
    }
    public void validarEstoqueItem (Long id) throws NotFoundException {
        Optional<EstoqueItem> obtemEstoqueItem = repositorio.findById(id);
        if (obtemEstoqueItem.isEmpty()) {
            throw new NotFoundException(MensagemRetorno.ITEM_NAO_ENCONTRADO.getMensagem());
        }
    }

    public void validarEstoqueItemLista () throws NotFoundException {
        List<EstoqueItem> obtemEstoqueItem = repositorio.findAll();
        if (obtemEstoqueItem.isEmpty()) {
            throw new NotFoundException(MensagemRetorno.ITEM_LISTA_NAO_ENCONTRADO.getMensagem());
        }
    }

}
