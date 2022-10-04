package inc.star.attoproject.mapper;

import inc.star.attoproject.dto.CardDto;
import inc.star.attoproject.dto.RefillDto;
import inc.star.attoproject.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends EntityMapper<CardDto, Card> {
    Card toEntity(RefillDto refillDto);
}