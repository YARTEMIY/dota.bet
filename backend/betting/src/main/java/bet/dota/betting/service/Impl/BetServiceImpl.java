package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Bet;
import bet.dota.betting.model.Odds;
import bet.dota.betting.model.User;
import bet.dota.betting.repository.BetRepository;
import bet.dota.betting.repository.OddsRepository;
import bet.dota.betting.repository.UserRepository;
import bet.dota.betting.service.BetService;
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
    private final OddsRepository oddsRepository;

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
        User user = userRepository.findById(Math.toIntExact(bet.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (user.getBalance().compareTo(bet.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance to place bet");
        }

        user.setBalance(user.getBalance().subtract(bet.getAmount()));
        userRepository.save(user);

        Bet savedBet = betRepository.save(bet);

        updateOddsForMatch(bet.getMatchId());

        return savedBet;
    }

    private void updateOddsForMatch(Long matchId) {
        List<Bet> betsOnMatch = betRepository.findByMatchId(matchId);

        BigDecimal totalStakesTeamA = BigDecimal.ZERO;
        BigDecimal totalStakesTeamB = BigDecimal.ZERO;

        for (Bet bet : betsOnMatch) {
            if (bet.getTeamId() == 1) {
                totalStakesTeamA = totalStakesTeamA.add(bet.getAmount());
            } else if (bet.getTeamId() == 2) {
                totalStakesTeamB = totalStakesTeamB.add(bet.getAmount());
            }
        }

        BigDecimal totalStakes = totalStakesTeamA.add(totalStakesTeamB);

        if (totalStakes.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal oddsTeamA = BigDecimal.ONE.add(totalStakesTeamB.divide(totalStakes, 2, RoundingMode.HALF_UP));
            BigDecimal oddsTeamB = BigDecimal.ONE.add(totalStakesTeamA.divide(totalStakes, 2, RoundingMode.HALF_UP));

            Odds odds = oddsRepository.findByMatchId(matchId);
            if (odds == null) {
                odds = new Odds();
                odds.setMatchId(matchId);
            }
            odds.setTeamAOdds(oddsTeamA);
            odds.setTeamBOdds(oddsTeamB);

            oddsRepository.save(odds);
        }
    }
}
