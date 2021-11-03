package com.tui.proof.mapper;

import com.tui.proof.dto.AddressDTO;
import com.tui.proof.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO modelToDTO(Address address);

    Address dtoToModel(AddressDTO addressDTO);
}
