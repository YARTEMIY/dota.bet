package bet.dota.betting.repository;

import bet.dota.betting.model.Bet;
import bet.dota.betting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Integer> {
    void deleteById(Long id);

    Bet getBetById(Long id);

    List<Bet> findByUserId(Long userId);

    List<Bet> findByMatchId(Long userId);
}
