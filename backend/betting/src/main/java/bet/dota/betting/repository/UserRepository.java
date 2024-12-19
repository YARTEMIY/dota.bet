package bet.dota.betting.repository;

import bet.dota.betting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    void deleteById(Long id);
    User getUserById(Long id);
    boolean existsByEmail(String email);
}
