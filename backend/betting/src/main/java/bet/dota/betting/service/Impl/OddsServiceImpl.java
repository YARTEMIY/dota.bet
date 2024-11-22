package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Odds;
import bet.dota.betting.repository.OddsRepository;
import bet.dota.betting.service.OddsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class OddsServiceImpl implements OddsService {
    private final OddsRepository oddsRepository;

    @Override
    public List<Odds> getAllOdds() {
        return List.of();
    }

    @Override
    public Odds saveOdds(Odds odds) {
        return null;
    }

    @Override
    public Odds getOddsById(Long id) {
        return null;
    }

    @Override
    public Odds updateOdds(Odds odds) {
        return null;
    }

    @Override
    public void deleteOdds(Long id) {

    }

    @Override
    public Odds getOddsByMatchId(Long matchId) {
        return null;
    }

    @Override
    public void updateOddsForMatch(Long matchId, BigDecimal totalRadiantBets, BigDecimal totalDireBets) {

    }
}
