package pl.piotrludynia.eventMenager.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piotrludynia.eventMenager.event.Event;


import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();


    Optional<User> findByLogin(String login);

    @Query(value = "Select count(EVENT_ID) from EVENT_TO_USER where EVENT_ID = ?", nativeQuery = true)
    int numberOfUsersAttendEvent(@Param("id") Long id);








}


