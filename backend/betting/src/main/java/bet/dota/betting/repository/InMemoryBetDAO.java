package bet.dota.betting.repository;

import bet.dota.betting.model.Bet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryBetDAO {
    private final List<Bet> BETS = new ArrayList<Bet>();

    public List<Bet> getUserBets() {
        return BETS;
    }

    public Bet saveBet(Bet bet) {
        BETS.add(bet);
        return bet;
    }

    public Bet getBetById(Long id) {
        return BETS.stream().filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Bet updateBet(Bet bet) {
        var matchId = IntStream.range(0, BETS.size())
                .filter(id -> BETS.get(id).getId().equals(bet.getId()))
                .findFirst()
                .orElse(-1);

        if (matchId != -1) {
            BETS.set(matchId, bet);
            return bet;
        }

        return null;
    }

    public void deleteBet(Long id) {
        var bet = getBetById(id);

        if (bet != null) {
            BETS.remove(bet);
        }
    }
}
