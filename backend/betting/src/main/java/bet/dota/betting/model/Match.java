package bet.dota.betting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue
    private Long id;
    private String teamA;
    private String teamB;
    private String date;
    private String status;
}
