package pl.piotrludynia.eventMenager.event;


import org.springframework.stereotype.Service;
import pl.piotrludynia.eventMenager.user.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    List<Event> listOfEvents() {
        return eventRepository.findAll();
    }

    boolean created(String name, String localization, LocalDate date, String access) {
        Event event = new Event(name, localization, date, access);
        Event created = eventRepository.save(event);
        return created.getId() != null;
    }

    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }


    public void edit(long id) {
        eventRepository.getOne(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Object get(Long id) {
        return eventRepository.getOne(id);
    }

    public Event update(Long id, String name, String localization, LocalDate date) {
        Event edited = eventRepository.findById(id).get();
        edited.setName(name);
        edited.setLocalization(localization);
        edited.setDate(date);
        return eventRepository.save(edited);
    }

    public Collection<Event> findEvents() {
        return eventRepository.findAll();
    }

    public Collection<Event> findEveryEvent(String phrase) {
        Collection<Event> collection = eventRepository.findAll();
        if (phrase != null) {
            return collection.stream().
                    filter(event -> event.getName().toLowerCase().contains(phrase.toLowerCase()))
                    .collect(Collectors.toList());
        } else {
            return collection;
        }
    }
}
