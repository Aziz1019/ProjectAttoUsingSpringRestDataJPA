package inc.star.attoproject.service;

import inc.star.attoproject.dto.StationDto;
import inc.star.attoproject.entity.Station;
import inc.star.attoproject.mapper.StationMapper;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StationService {
    private final StationRepository stationRepository;
    private final StationMapper stationMapper;


    public ResMessage save(StationDto stationDto) {
        Station station = stationMapper.toEntity(stationDto);
        Station save = stationRepository.save(station);
        return ResMessage.getSuccess(save);
    }

    public ResMessage getStationById(Integer stationId) {
        Optional<Station> byId = stationRepository.findById(stationId);
        if (byId.isPresent())
            return ResMessage.getSuccess(byId);
        else
            return ResMessage.getFail("Not Found!");
    }

    public ResMessage getAllStation(){
        List<Station> all = stationRepository.findAll();
        return ResMessage.getSuccess(all);
    }
}

