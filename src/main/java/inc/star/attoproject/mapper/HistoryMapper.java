package inc.star.attoproject.mapper;

import inc.star.attoproject.dto.HistoryDto;
import inc.star.attoproject.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoryMapper extends EntityMapper<HistoryDto, History> {
}