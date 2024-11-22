package bet.dota.betting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String username;
    private String password;
    private BigDecimal balance;
}
