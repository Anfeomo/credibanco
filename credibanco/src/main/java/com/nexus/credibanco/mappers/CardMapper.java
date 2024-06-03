package com.nexus.credibanco.mappers;
import com.nexus.credibanco.DTO.CardDTO;
import com.nexus.credibanco.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDTO cardToCardDTO(Card card);
    Card cardDTOToCard(CardDTO cardDTO);
}
