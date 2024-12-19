package bet.dota.betting.service.Impl;

import bet.dota.betting.model.User;
import bet.dota.betting.repository.UserRepository;
import bet.dota.betting.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateBalance(Long userId, BigDecimal amount) {
        User user = repository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setBalance(user.getBalance().add(amount));

        repository.save(user);
    }

    @Override
    public void registerNewUser(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        user.setBalance(BigDecimal.ZERO);

        repository.save(user);
    }
}
