package bet.dota.betting.repository;

import bet.dota.betting.model.Match;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryMatchDAO {
    private final List<Match> MATCHES = new ArrayList<Match>();

    public List<Match> getAllMatches() {
        return MATCHES;
    }

    public Match saveMatch(Match match) {
        MATCHES.add(match);
        return match;
    }

    public Match getMatchById(Long id) {
        return MATCHES.stream().filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Match updateMatch(Match match) {
        var matchId = IntStream.range(0, MATCHES.size())
                .filter(id -> MATCHES.get(id).getId().equals(match.getId()))
                .findFirst()
                .orElse(-1);

        if (matchId != -1) {
            MATCHES.set(matchId, match);
            return match;
        }

        return null;
    }

    public void deleteMatch(Long id) {
        var match = getMatchById(id);

        if (match != null) {
            MATCHES.remove(match);
        }
    }
}
