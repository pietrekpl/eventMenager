package pl.piotrludynia.eventMenager.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrludynia.eventMenager.event.Event;

import java.util.List;

public interface EventRepository  extends JpaRepository<Event,Long> {
    List<Event>findAll();
}
