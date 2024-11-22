package bet.dota.betting.repository;

import bet.dota.betting.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryUserDAO {
    private final List<User> USERS = new ArrayList<User>();

    public List<User> getAllUsers() {
        return USERS;
    }

    public User saveUser(User user) {
        USERS.add(user);
        return user;
    }

    public User getUserById(Long id) {
        return USERS.stream().filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User updateUser(User user) {
        var matchId = IntStream.range(0, USERS.size())
                .filter(id -> USERS.get(id).getId().equals(user.getId()))
                .findFirst()
                .orElse(-1);

        if (matchId != -1) {
            USERS.set(matchId, user);
            return user;
        }

        return null;
    }

    public void deleteUser(Long id) {
        var User = getUserById(id);

        if (User != null) {
            USERS.remove(User);
        }
    }
}
