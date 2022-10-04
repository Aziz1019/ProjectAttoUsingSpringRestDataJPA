package inc.star.attoproject.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Station extends BaseEntity {
    private double balance;

    public Station(String name, double balance) {
        name = this.getName();
        balance = this.balance;
    }
}

