package bet.dota.betting.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    private BigDecimal amount;
    private String status;
}
