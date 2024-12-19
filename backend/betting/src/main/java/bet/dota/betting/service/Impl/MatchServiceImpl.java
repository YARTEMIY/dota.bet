package bet.dota.betting.service.Impl;

import bet.dota.betting.model.Match;
import bet.dota.betting.repository.MatchRepository;
import bet.dota.betting.service.MatchService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class MatchServiceImpl implements MatchService {
    private final MatchRepository repository;

    @Override
    public List<Match> getAllMatches() {
        return repository.findAll();
    }

    @Override
    public Match saveMatch(Match match) {
        return repository.save(match);
    }

    @Override
    public Match getMatchById(Long id) {
        return repository.getMatchById(id);
    }

    @Override
    public Match updateMatch(Match match) {
        return repository.save(match);
    }

    @Transactional
    @Override
    public void deleteMatch(Long id) {
        repository.deleteById(id);
    }
}
