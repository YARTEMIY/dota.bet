package bet.dota.betting.repository;

import bet.dota.betting.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {
    void deleteById(Long id);
    Bet getBetById(Long id);
    List<Bet> findByUserId(Long userId);
    List<Bet> findByMatchId(Long userId);
}
