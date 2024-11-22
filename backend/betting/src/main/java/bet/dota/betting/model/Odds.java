package bet.dota.betting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Odds {
    @Id
    @GeneratedValue
    private Long matchId;
    private BigDecimal teamAOdds;
    private BigDecimal teamBOdds;
}
