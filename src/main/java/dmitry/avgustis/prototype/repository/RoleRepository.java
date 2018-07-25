package dmitry.avgustis.prototype.repository;

import dmitry.avgustis.prototype.persist.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

