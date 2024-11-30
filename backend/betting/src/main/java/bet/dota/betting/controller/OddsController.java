package bet.dota.betting.controller;


import bet.dota.betting.model.Odds;
import bet.dota.betting.service.OddsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/odds")
@AllArgsConstructor
public class OddsController {
    private OddsService oddsService;

    @GetMapping
    public List<Odds> getAllOdds() {
        return oddsService.getAllOdds();
    }

    @PostMapping("save_odds")
    public Odds saveOdds(@RequestBody Odds odds) {
        return oddsService.saveOdds(odds);
    }

//    @GetMapping("/{id}")
//    public Odds getOddsById(@PathVariable Long id) {
//        return oddsService.getOddsById(id);
//    }

    @PutMapping("update_odds")
    public Odds updateOdds(@RequestBody Odds bet) {
        return oddsService.updateOdds(bet);
    }

    @DeleteMapping("delete_odds/{id}")
    public void deleteOdds(@PathVariable Long id) {
        oddsService.deleteOdds(id);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Odds> getOddsForMatch(@PathVariable Long matchId) {
        try {
            Odds odds = oddsService.getOddsByMatchId(matchId);
            return ResponseEntity.ok(odds);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/update/{matchId}")
    public ResponseEntity<String> updateOddsForMatch(@PathVariable Long matchId) {
        try {
            oddsService.updateOddsForMatch(matchId);
            return ResponseEntity.ok("Odds updated successfully for match ID: " + matchId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
