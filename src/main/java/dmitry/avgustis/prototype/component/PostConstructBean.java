package dmitry.avgustis.prototype.component;

import dmitry.avgustis.prototype.domain.UserRole;
import dmitry.avgustis.prototype.persist.User;
import dmitry.avgustis.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class PostConstructBean {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PostConstructBean(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("user");
        user1.setPassword(passwordEncoder.encode("1990"));
        user1.setRoles(Collections.singleton(UserRole.ADMIN));
        userRepository.saveAndFlush(user1);
    }
}
