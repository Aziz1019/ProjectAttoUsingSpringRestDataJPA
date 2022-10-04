package inc.star.attoproject.service;

import inc.star.attoproject.dto.HistoryDto;
import inc.star.attoproject.entity.Card;
import inc.star.attoproject.entity.History;
import inc.star.attoproject.entity.Station;
import inc.star.attoproject.mapper.HistoryMapper;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.repository.CardRepository;
import inc.star.attoproject.repository.HistoryRepository;
import inc.star.attoproject.repository.StationRepository;
import inc.star.attoproject.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class HistoryService {

    private final CardRepository cardRepository;
    private final StationRepository stationRepository;
    private final TerminalRepository terminalRepository;
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    @Transactional
    public ResMessage paymentToTerminal(Integer terminalId, HistoryDto historyDto) {
        if(historyDto.getTransferredMoney() == 1400.0){
            Optional<Card> card = cardRepository.findById(historyDto.getCardId());
            if(card.isPresent()){
                if(card.get().getBalance() > 1400){
                    card.get().setBalance(card.get().getBalance() - 1400.0);
                    Card card_save = cardRepository.save(card.get());

                    Optional<Station> station = stationRepository.findById(historyDto.getStationId());
                    station.ifPresent(value -> value.setBalance(value.getBalance() + 1400.0));
                    station.ifPresent(stationRepository::save);

                    History history = historyMapper.toEntity(historyDto);

                    history.setTerminalId(terminalId);

                    History history_save = historyRepository.save(history);

                    return ResMessage.getSuccess(history_save);
                }
            }
            else return ResMessage.getFail("No Such Card Was Found!");
        }
        return ResMessage.getFail("Insufficient Amount!");
    }

    public ResMessage getAllHistory(){
        List<History> all = historyRepository.findAll();
        return ResMessage.getSuccess(all);
    }

    public ResMessage getHistoryById(Integer id){
        Optional<History> byId = historyRepository.findById(id);
        if (byId.isPresent())
            return ResMessage.getSuccess(byId);
        else
            return ResMessage.getFail("Not Found!");
    }

    public ResMessage getReport(Date fromDate, Date toDate) {
        List<Map<String, Object>> report = historyRepository.findByTransactionDates(fromDate, toDate);
        return ResMessage.getSuccess(report);
    }

    public ResMessage maxUserTerminal(Date fromDate, Date toDate){
        Map<String, Object> max = historyRepository.getMaxTerminal(fromDate, toDate);
        return ResMessage.getSuccess(max);
    }

    public ResMessage minUserTerminal(Date fromDate, Date toDate){
        Map<String, Object> min = historyRepository.getMinTerminal(fromDate, toDate);
        return ResMessage.getSuccess(min);
    }

    public ResMessage getHistoryByCardId(Integer cardId){
        List<Map<String, Object>> history = historyRepository.getHistory(cardId);
        return ResMessage.getSuccess(history);
    }

    public ResMessage getMaxCard(Date fromDate, Date toDate) {
        Map<String, Object> maxCard = historyRepository.getMaxCard(fromDate, toDate);
        return ResMessage.getSuccess(maxCard);
    }


    public ResMessage getMinCard(Date fromDate, Date toDate) {
        Map<String, Object> minCard = historyRepository.getMinCard(fromDate, toDate);
        return ResMessage.getSuccess(minCard);
    }
}
