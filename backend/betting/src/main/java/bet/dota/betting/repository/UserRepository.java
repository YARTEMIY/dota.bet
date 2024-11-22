package bet.dota.betting.repository;

import bet.dota.betting.model.Bet;
import bet.dota.betting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    void deleteById(Long id);

    User getUserById(Long id);

    List<Bet> findByMatchId(Long matchId);

    boolean existsByEmail(String email);
}
