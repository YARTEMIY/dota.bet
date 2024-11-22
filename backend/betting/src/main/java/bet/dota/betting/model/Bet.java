package bet.dota.betting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Bet {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long teamId;
    private Long matchId;
    private BigDecimal amount;
    private String status;
}
