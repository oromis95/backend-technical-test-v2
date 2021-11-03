package com.tui.proof.mapper;

import com.tui.proof.dto.OrderDTO;
import com.tui.proof.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.ui.Model;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO modelToDTO(Order model);

    Order dtoToModel(OrderDTO orderDTO);
}
