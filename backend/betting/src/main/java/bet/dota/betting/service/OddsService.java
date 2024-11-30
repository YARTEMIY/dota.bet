package bet.dota.betting.service;

import bet.dota.betting.model.Odds;

import java.util.List;

public interface OddsService {
    List<Odds> getAllOdds();

    Odds saveOdds(Odds odds);

    //Odds getOddsById(Long id);

    Odds updateOdds(Odds odds);

    void deleteOdds(Long id);

    Odds getOddsByMatchId(Long matchId);

    void updateOddsForMatch(Long matchId);
}
