package bet.dota.betting.service;

import bet.dota.betting.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

    void updateBalance(Long userId, BigDecimal amount);

    void registerNewUser(User user);
}
