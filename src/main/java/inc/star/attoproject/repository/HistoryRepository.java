package inc.star.attoproject.repository;

import inc.star.attoproject.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer>, JpaSpecificationExecutor<History> {

    // Get History by Card ID
    @Query(value = "select s.name, h.card_id, h.transaction_date, h.transferred_money from history h left join station s on s.id = h.station_id", nativeQuery = true)
    List<Map<String, Object>> getHistory(Integer cardId);
    // Report
    @Query(value = "select s.id,s.name,s.balance from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id where h.transaction_date between ? and ? group by s.name, s.balance, s.id order by s.balance desc limit 1",nativeQuery = true)
    List<Map<String,Object>> findByTransactionDates(Date fromDate, Date toDate);

    // Max Card Usage
   @Query(value = "select h.card_id, c.card_number from history h left join card c on c.id = h.card_id where  h.transaction_date <= ? AND h.transaction_date >= ? group by h.id order by count(c.id) desc limit 1", nativeQuery = true)
    Map<String, Object> getMaxCard(Date fromDate, Date toDate);

    // Min Card Usage
    @Query(value = "select h.card_id, c.card_number from history h left join card c on c.id = h.card_id where  h.transaction_date <= ? AND h.transaction_date >= ? group by h.id order by count(c.id) limit 1", nativeQuery = true)
    Map<String, Object> getMinCard(Date fromDate, Date toDate);

    // Max Used Terminal
    @Query(value = "select s.name as station, terminal_id, t.name as terminal, count(t.id) from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id WHERE  h.transaction_date <= ? AND h.transaction_date >= ? group by terminal_id, t.name, s.name order by count(t.id) desc limit 1", nativeQuery = true)
    Map<String, Object> getMaxTerminal(Date fromDate, Date toDate);


    // Min Used Terminal
    @Query(value = "select s.name as station, terminal_id, t.name as terminal, count(t.id) from history h left join terminal t on t.id = h.terminal_id left join station s on s.id = t.station_id WHERE  h.transaction_date <= ? AND h.transaction_date >= ? group by terminal_id, t.name, s.name order by count(t.id) limit 1", nativeQuery = true)
    Map<String, Object> getMinTerminal(Date fromDate, Date toDate);



}