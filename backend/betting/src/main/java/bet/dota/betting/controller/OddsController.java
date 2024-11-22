package bet.dota.betting.controller;

import bet.dota.betting.model.Odds;
import bet.dota.betting.repository.OddsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OddsController {
    private final OddsRepository oddsRepository;

    @GetMapping("/odds/{matchId}")
    public Odds getOddsForMatch(@PathVariable Long matchId) {
        return oddsRepository.findByMatchId(matchId);
    }
}
