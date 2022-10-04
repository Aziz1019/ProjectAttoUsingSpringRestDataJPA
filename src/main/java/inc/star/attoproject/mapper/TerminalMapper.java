package inc.star.attoproject.mapper;

import inc.star.attoproject.dto.TerminalDto;
import inc.star.attoproject.entity.Terminal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TerminalMapper extends EntityMapper<TerminalDto, Terminal> {
}