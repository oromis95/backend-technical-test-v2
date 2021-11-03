package com.tui.proof.mapper;

import com.tui.proof.dto.ClientDTO;
import com.tui.proof.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO modelToDTO(Client client);

    Client dtoToModel(ClientDTO clientDTO);
}
