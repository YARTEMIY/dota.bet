package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Bet;

import bet.dota.betting.repository.InMemoryBetDAO;
import bet.dota.betting.service.BetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryBetServiceImpl implements BetService {
    private final InMemoryBetDAO repository;

    @Override
    public List<Bet> getUserBets() {
        return repository.getUserBets();
    }

    @Override
    public Bet saveBet(Bet bet) {
        return repository.saveBet(bet);
    }

    @Override
    public Bet getBetById(Long id) {
        return repository.getBetById(id);
    }

    @Override
    public Bet updateBet(Bet bet) {
        return repository.updateBet(bet);
    }

    @Override
    public void deleteBet(Long id) {
        repository.deleteBet(id);
    }

    @Override
    public List<Bet> getUserBets(Long userId) {
        return List.of();
    }

    @Override
    public Bet placeBet(Bet bet) {
        return null;
    }

    @Override
    public List<Bet> findByMatchId(Long matchId) {
        return List.of();
    }
}
