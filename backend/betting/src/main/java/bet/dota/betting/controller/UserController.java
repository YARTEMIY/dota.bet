package bet.dota.betting.controller;

import bet.dota.betting.model.User;
import bet.dota.betting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("save_user")
    public User saveMatch(@RequestBody User bet) {
        return service.saveUser(bet);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("update_user")
    public User updateMatch(@RequestBody User bet) {
        return service.updateUser(bet);
    }

    @DeleteMapping("delete_user/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/update_balance")
    public void updateBalance(@RequestParam Long userId, @RequestParam BigDecimal amount) {
        service.updateBalance(userId, amount);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            service.registerNewUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
