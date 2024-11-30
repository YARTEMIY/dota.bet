package bet.dota.betting.controller;

import bet.dota.betting.model.Match;
import bet.dota.betting.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@AllArgsConstructor
public class MatchController {
    private MatchService service;

    @GetMapping
    public List<Match> getAllMatches() {
        return service.getAllMatches();
    }

    @PostMapping("save_match")
    public Match saveMatch(@RequestBody Match match) {
        return service.saveMatch(match);
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        return service.getMatchById(id);
    }

    @PutMapping("update_match")
    public Match updateMatch(@RequestBody Match match) {
        return service.updateMatch(match);
    }

    @DeleteMapping("delete_match/{id}")
    public void deleteMatch(@PathVariable Long id) {
        service.deleteMatch(id);
    }
}
