package dmitry.avgustis.prototype.service.impl;

import dmitry.avgustis.prototype.domain.UserRole;
import dmitry.avgustis.prototype.persist.User;
import dmitry.avgustis.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        String[] roles = new String[user.getRoles().size()];
        int i = 0;
        for (UserRole role : user.getRoles()) {
            roles[i] = role.toString();
            i++;
        }

        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword())
                .roles(roles)
                .build();
//        return new MyUserPrincipal(user);
    }
}
