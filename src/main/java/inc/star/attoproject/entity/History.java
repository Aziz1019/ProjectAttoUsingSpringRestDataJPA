package inc.star.attoproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History extends BaseEntity{
    private Integer stationId;
    private Integer terminalId;
    private Integer cardId;
    @CreationTimestamp
    private Timestamp transactionDate;
    private double transferredMoney;

    public History(Integer stationId, Integer terminalId, Integer cardId, double transferredMoney) {
        this.stationId = stationId;
        this.terminalId = terminalId;
        this.cardId = cardId;
        this.transferredMoney = transferredMoney;
    }
}
