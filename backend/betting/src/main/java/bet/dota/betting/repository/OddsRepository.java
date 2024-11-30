package bet.dota.betting.repository;

import bet.dota.betting.model.Odds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OddsRepository extends JpaRepository<Odds, Long> {
    //Odds getOddsById(Long id);
    void deleteById(Long id);
    Odds findByMatchId(Long matchId);
}
