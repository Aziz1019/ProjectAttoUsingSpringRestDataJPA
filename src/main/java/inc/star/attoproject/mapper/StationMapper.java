package inc.star.attoproject.mapper;

import inc.star.attoproject.dto.StationDto;
import inc.star.attoproject.entity.Station;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StationMapper extends EntityMapper<StationDto, Station> {
}