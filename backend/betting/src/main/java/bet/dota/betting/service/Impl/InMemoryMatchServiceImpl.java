package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Match;
import bet.dota.betting.repository.InMemoryMatchDAO;
import bet.dota.betting.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryMatchServiceImpl implements MatchService {
    private final InMemoryMatchDAO repository;

    @Override
    public List<Match> getAllMatches() {
        return repository.getAllMatches();
    }

    @Override
    public Match saveMatch(Match match) {
        return repository.saveMatch(match);
    }

    @Override
    public Match getMatchById(Long id) {
        return repository.getMatchById(id);
    }

    @Override
    public Match updateMatch(Match match) {
        return repository.updateMatch(match);
    }

    @Override
    public void deleteMatch(Long id) {
        repository.deleteMatch(id);
    }
}
