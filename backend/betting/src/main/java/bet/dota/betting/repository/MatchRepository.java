package bet.dota.betting.repository;

import bet.dota.betting.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    void deleteById(Long id);

    Match getMatchById(Long id);
}
