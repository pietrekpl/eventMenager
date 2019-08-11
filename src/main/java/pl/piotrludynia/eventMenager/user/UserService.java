package pl.piotrludynia.eventMenager.user;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piotrludynia.eventMenager.event.Event;
import pl.piotrludynia.eventMenager.event.EventRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {

    private UserRepository userRepository;
    private EventRepository eventRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    List<User> listOfUsers() {
        return userRepository.findAll();
    }

    boolean created(String name, String lastName, String login, String password, String email, LocalDate date) {
        User user = new User(name, lastName, login, passwordEncoder.encode(password), email, date);
        User created = userRepository.save(user);
        return created.getId() != null;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    private User findByName(String name) {
        return userRepository.findByLogin(name)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public Event addUserToEvent(Long id, String name) {
        User user1 = findByName(name);
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        event.getUsers().add(user1);

        return eventRepository.save(event);
    }

    public int countUsers(long id) {
        return userRepository.numberOfUsersAttendEvent(id);
    }
}
