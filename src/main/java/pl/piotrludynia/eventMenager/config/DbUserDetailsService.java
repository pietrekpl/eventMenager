package pl.piotrludynia.eventMenager.config;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.piotrludynia.eventMenager.user.User;
import pl.piotrludynia.eventMenager.user.UserRepository;

import java.util.Collections;


@Component
class DbUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DbUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username"));

        ;
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                Collections.emptyList());
    }
}
