package pl.piotrludynia.eventMenager.user;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> listOfUsers(){
        return userRepository.findAll();
    }

    boolean created (String name, String lastName,String login,String password,String email, LocalDate date){
        User user  = new User(name,lastName,login,passwordEncoder.encode(password),email,date);
        User created = userRepository.save(user);
        return  created.getId() != null;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
