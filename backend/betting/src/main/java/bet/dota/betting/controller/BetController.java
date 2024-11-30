package bet.dota.betting.controller;

import bet.dota.betting.model.Bet;

import bet.dota.betting.service.BetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bets")
@AllArgsConstructor
public class BetController {
    private BetService service;

    @GetMapping
    public List<Bet> getUserBets() {
        return service.getUserBets();
    }

    @PostMapping("save_bet")
    public Bet saveBet(@RequestBody Bet bet) {
        return service.saveBet(bet);
    }

    @GetMapping("/{id}")
    public Bet getBetById(@PathVariable Long id) {
        return service.getBetById(id);
    }

    @PutMapping("update_bet")
    public Bet updateBet(@RequestBody Bet bet) {
        return service.updateBet(bet);
    }

    @DeleteMapping("delete_bet/{id}")
    public void deleteBet(@PathVariable Long id) {
        service.deleteBet(id);
    }

    @PostMapping("/place")
    public ResponseEntity<Bet> placeBet(@RequestBody Bet bet) {
        Bet placedBet = service.placeBet(bet);
        return ResponseEntity.ok(placedBet);
    }
}
