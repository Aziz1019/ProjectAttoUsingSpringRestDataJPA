package inc.star.attoproject.service;

import inc.star.attoproject.dto.CardDto;
import inc.star.attoproject.dto.RefillDto;
import inc.star.attoproject.entity.Card;
import inc.star.attoproject.mapper.CardMapper;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public ResMessage save(CardDto cardDto){
        Card card = cardMapper.toEntity(cardDto);
        cardRepository.save(card);
        return ResMessage.getSuccess("Ok");
    }
    public ResMessage cardGetById(Integer cardId){
        Optional<Card> byId = cardRepository.findById(cardId);
        if(byId.isPresent())
            return ResMessage.getSuccess(byId);
        else
            return ResMessage.getFail("Not Found!");
    }
    public ResMessage cardGetAll(){
        List<Card> all = cardRepository.findAll();
        return ResMessage.getSuccess(all);
    }
    @Transactional
    public ResMessage refillBalance(RefillDto refillDto) {
        Integer cardId = refillDto.getCardId();
        double balance = refillDto.getBalance();
        Optional<Card> card = cardRepository.findById(cardId);
        if(card.isPresent()){
            card.get().setBalance(balance);
            Card save = cardRepository.save(card.get());
            return ResMessage.getSuccess(save);
        }
        else
            return ResMessage.getFail("Not Found!");
    }
}

