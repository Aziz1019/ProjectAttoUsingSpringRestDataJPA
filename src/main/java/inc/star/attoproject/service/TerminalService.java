package inc.star.attoproject.service;


import inc.star.attoproject.dto.TerminalDto;
import inc.star.attoproject.entity.Terminal;
import inc.star.attoproject.mapper.TerminalMapper;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final TerminalMapper terminalMapper;


    public ResMessage save(TerminalDto terminalDto){

        Terminal terminal = terminalMapper.toEntity(terminalDto);
        Terminal save = terminalRepository.save(terminal);
        return ResMessage.getSuccess(save);
    }

    public ResMessage terminalById(Integer stationId){
        Optional<Terminal> byId = terminalRepository.findById(stationId);
        if (byId.isPresent())
            return ResMessage.getSuccess(byId);
        else
            return ResMessage.getFail("Not Found!");
    }

    public ResMessage allTerminal(){
        List<Terminal> all = terminalRepository.findAll();
        return ResMessage.getSuccess(all);
    }

}
