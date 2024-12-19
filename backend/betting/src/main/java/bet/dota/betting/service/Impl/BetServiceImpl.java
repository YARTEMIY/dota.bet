package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Bet;
import bet.dota.betting.model.Odds;
import bet.dota.betting.model.User;
import bet.dota.betting.repository.BetRepository;
import bet.dota.betting.repository.OddsRepository;
import bet.dota.betting.repository.UserRepository;
import bet.dota.betting.service.BetService;
import bet.dota.betting.service.OddsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class BetServiceImpl implements BetService {
    private final BetRepository betRepository;
    private final UserRepository userRepository;
    private final OddsService oddsService;

    @Override
    public List<Bet> getUserBets() {
        return betRepository.findAll();
    }

    @Override
    public Bet saveBet(Bet bet) {
        return betRepository.save(bet);
    }

    @Override
    public Bet getBetById(Long id) {
        return betRepository.getBetById(id);
    }

    @Override
    public Bet updateBet(Bet bet) {
        return betRepository.save(bet);
    }

    @Transactional
    @Override
    public void deleteBet(Long id) {
        betRepository.deleteById(id);
    }

    @Override
    public List<Bet> getUserBets(Long userId) {
        return betRepository.findByUserId(userId);
    }

    @Override
    public List<Bet> findByMatchId(Long matchId) {
        return betRepository.findByMatchId(matchId);
    }

    @Override
    public Bet placeBet(Bet bet) {
        User user = userRepository.findById(Math.toIntExact(bet.getUser().getId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (user.getBalance().compareTo(bet.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance to place bet");
        }

        user.setBalance(user.getBalance().subtract(bet.getAmount()));
        userRepository.save(user);

        Bet savedBet = betRepository.save(bet);

        oddsService.updateOddsForMatch(bet.getMatch().getId());

        return savedBet;
    }
}
