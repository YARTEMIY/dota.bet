package bet.dota.betting.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Odds {
    @Id
    private Long matchId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "match_id")
    private Match match;

    private BigDecimal teamAOdds;
    private BigDecimal teamBOdds;
}
