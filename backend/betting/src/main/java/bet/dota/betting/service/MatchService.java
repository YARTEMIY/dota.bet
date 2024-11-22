package bet.dota.betting.service;

import bet.dota.betting.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    List<Match> getAllMatches();

    Match saveMatch(Match match);

    Match getMatchById(Long id);

    Match updateMatch(Match match);

    void deleteMatch(Long id);
}
