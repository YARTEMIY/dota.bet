package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Bet;
import bet.dota.betting.model.Odds;
import bet.dota.betting.repository.BetRepository;
import bet.dota.betting.repository.OddsRepository;
import bet.dota.betting.service.OddsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class OddsServiceImpl implements OddsService {
    private final OddsRepository oddsRepository;
    private final BetRepository betRepository;

    @Override
    public List<Odds> getAllOdds() {
        return oddsRepository.findAll();
    }

    @Override
    public Odds saveOdds(Odds odds) {
        return oddsRepository.save(odds);
    }

//    @Override
//    public Odds getOddsById(Long id) {
//        return oddsRepository.getOddsById(id);
//    }

    @Override
    public Odds updateOdds(Odds odds) {
        return oddsRepository.save(odds);
    }

    @Override
    public void deleteOdds(Long id) {
        oddsRepository.deleteById(id);
    }

    @Override
    public Odds getOddsByMatchId(Long matchId) {
        return oddsRepository.findByMatchId(matchId);
    }

    @Override
    public void updateOddsForMatch(Long matchId) {
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
