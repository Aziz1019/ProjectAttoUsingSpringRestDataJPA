package inc.star.attoproject.controller;

import inc.star.attoproject.dto.CardDto;
import inc.star.attoproject.dto.RefillDto;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")

public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResMessage saveCard(@RequestBody CardDto cardDto){
        return cardService.save(cardDto);
    }

    @GetMapping
    public ResMessage getAll(){
        return cardService.cardGetAll();
    }

    @GetMapping("{cardId}")
    public ResMessage getById(@PathVariable Integer cardId){
        return cardService.cardGetById(cardId);
    }

    @PutMapping
    public ResMessage refillBalance(@RequestBody RefillDto refillDto){
        return cardService.refillBalance(refillDto);
    }
}
