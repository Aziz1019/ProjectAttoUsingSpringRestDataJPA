package inc.star.attoproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Card extends BaseEntity{
    private double balance;
    private String phone;
    private String cardNumber;

}
