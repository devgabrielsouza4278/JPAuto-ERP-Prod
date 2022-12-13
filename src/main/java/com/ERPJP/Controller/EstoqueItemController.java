package com.ERPJP.Controller;

import com.ERPJP.Model.DTO.EstoqueItemRequest;
import com.ERPJP.Model.DTO.EstoqueItemResponse;
import com.ERPJP.Model.Excecoes.NotFoundException;
import com.ERPJP.Model.Servicos.EstoqueItemServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/estoqueItem")
public class EstoqueItemController {

   private final EstoqueItemServico estoqueItemServico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueItemResponse salvarEstoqueItem (@Valid @RequestBody EstoqueItemRequest request) {
        return estoqueItemServico.salvarEstoqueItem(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstoqueItemResponse consultarEstoqueItem (@Valid @PathVariable  Long id) throws NotFoundException {
        return estoqueItemServico.consultarEstoqueItem(id);
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<EstoqueItemResponse> consultarEstoqueItemNome (@PathVariable String nome) throws NotFoundException {
        return estoqueItemServico.consultarEstoqueItemListaNome(nome);
    }

    @GetMapping("/categoria/{categoria}")
    @ResponseStatus(HttpStatus.OK)
    public List<EstoqueItemResponse> consultarEstoqueItemCategoria (@PathVariable String categoria) throws NotFoundException {
        return estoqueItemServico.consultarEstoqueItemListaCategoria(categoria);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstoqueItemResponse> consultarEstoqueItemLista () throws NotFoundException {
        return estoqueItemServico.consultarEstoqueItemLista();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstoqueItemResponse alterarEstoqueItem (@Valid @PathVariable Long id, @RequestBody EstoqueItemRequest request) throws NotFoundException {
        return estoqueItemServico.alterarEstoqueItem(request, id);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void apagarEstoqueItem (@Valid @PathVariable  Long id) throws NotFoundException {
        estoqueItemServico.apagarEstoqueItem(id);
    }
}
