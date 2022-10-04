package inc.star.attoproject.dto;

import inc.star.attoproject.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalDto {
    private Station station;
}