package dmitry.avgustis.prototype.component;

import dmitry.avgustis.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstructBean {
    private final UserRepository userRepository;


    @Autowired
    public PostConstructBean(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
