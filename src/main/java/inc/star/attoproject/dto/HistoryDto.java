package inc.star.attoproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistoryDto {
    private Integer stationId;
    private Integer cardId;
    private Timestamp transactionDate;
    private double transferredMoney;
}