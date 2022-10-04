package inc.star.attoproject.controller;

import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")

public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public ResMessage getAllHistory(){
        return historyService.getAllHistory();
    }

    @GetMapping("{historyId}")
    public ResMessage getById(@PathVariable Integer historyId){
        return historyService.getHistoryById(historyId);
    }


// REPORT

    @GetMapping("/station-dates")
    public ResMessage getReport(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate){
        return historyService.getReport(fromDate,toDate);
    }

    @GetMapping("/max-card")
    public ResMessage getMaxSpentCard(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate){
        return historyService.getMaxCard(fromDate, toDate);
    }

    @GetMapping("/min-card")
    public ResMessage getMinSpentCard(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate){
        return historyService.getMinCard(fromDate, toDate);
    }

    @GetMapping("/max-terminal")
    public ResMessage getMaxTerminalUsage(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate){
        return historyService.maxUserTerminal(fromDate, toDate);
    }


    @GetMapping("/min-terminal")
    public ResMessage getMinTerminalUsage(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date fromDate, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date toDate){
        return historyService.minUserTerminal(fromDate, toDate);
    }


    @PutMapping("{cardId}")
    public ResMessage getByCardId(@PathVariable Integer cardId){
        return historyService.getHistoryByCardId(cardId);
    }




}
