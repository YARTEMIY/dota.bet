package bet.dota.betting.service.Impl;

import bet.dota.betting.model.User;
import bet.dota.betting.repository.InMemoryUserDAO;
import bet.dota.betting.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryUserServiceImpl implements UserService {
    private final InMemoryUserDAO repository;

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public User saveUser(User user) {
        return repository.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return repository.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }

    @Override
    public void updateBalance(Long userId, BigDecimal amount) {
        User user = repository.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        user.setBalance(user.getBalance().add(amount));
        repository.saveUser(user);
    }

    @Override
    public void registerNewUser(User user) {
        return;
    }
}
