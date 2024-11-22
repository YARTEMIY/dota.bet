package bet.dota.betting.service;

import bet.dota.betting.model.Bet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BetService {
    List<Bet> getUserBets();

    Bet saveBet(Bet bet);

    Bet getBetById(Long id);

    Bet updateBet(Bet bet);

    void deleteBet(Long id);

    List<Bet> getUserBets(Long userId);

    Bet placeBet(Bet bet);

    List<Bet> findByMatchId(Long matchId);
}
