package inc.star.attoproject.controller;

import inc.star.attoproject.dto.HistoryDto;
import inc.star.attoproject.dto.TerminalDto;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.service.HistoryService;
import inc.star.attoproject.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terminal")

public class TerminalController {

    private final TerminalService terminalService;
    private final HistoryService historyService;

    @PutMapping("{terminal_id}_pay")
    public ResMessage payToTerminal(@PathVariable Integer terminal_id, @RequestBody HistoryDto historyDto){
        return historyService.paymentToTerminal(terminal_id, historyDto);
    }

    @PostMapping
    public ResMessage saveTerminal(@RequestBody TerminalDto terminalDto){
        return terminalService.save(terminalDto);
    }

    @GetMapping("{terminalId}")
    public ResMessage getTerminalById(@PathVariable Integer terminalId){
        return terminalService.terminalById(terminalId);
    }

    @GetMapping
    public ResMessage getAllTerminal(){
        return terminalService.allTerminal();
    }

}
