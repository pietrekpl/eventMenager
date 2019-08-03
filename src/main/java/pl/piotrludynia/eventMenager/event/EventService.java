package pl.piotrludynia.eventMenager.event;


import org.springframework.stereotype.Service;
import pl.piotrludynia.eventMenager.event.Event;
import pl.piotrludynia.eventMenager.event.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    List<Event> listOfEvents(){
        return eventRepository.findAll();
    }
    boolean created(String name, String localization, LocalDate date, String access){
        Event event = new Event(name,localization,date,access);
        Event created = eventRepository.save(event);
        return created.getId()!= null;
    }

    public void deleteEvent(long id) {
      eventRepository.deleteById(id);
    }
}
