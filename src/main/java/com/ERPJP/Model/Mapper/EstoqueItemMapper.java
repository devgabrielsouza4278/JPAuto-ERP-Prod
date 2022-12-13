package com.ERPJP.Model.Mapper;

import com.ERPJP.Model.DTO.EstoqueItemRequest;
import com.ERPJP.Model.DTO.EstoqueItemResponse;
import com.ERPJP.Model.Entidades.EstoqueItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EstoqueItemMapper {

    @Autowired
    private ModelMapper mapper;

    public EstoqueItem paraEntidade (EstoqueItemRequest request) {
        return  mapper.map(request, EstoqueItem.class);
    }

    public EstoqueItemResponse paraResponse (EstoqueItem entidade) {
        return  mapper.map(entidade, EstoqueItemResponse.class);
    }

    public List<EstoqueItemResponse> paraResponseList (List<EstoqueItem> entidadeLista) {
        return  entidadeLista.stream().map(this::paraResponse).collect(Collectors.toList());
    }
}
