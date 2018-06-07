package dmitry.avgustis.prototype.repository;

import dmitry.avgustis.prototype.persist.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
