package pl.piotrludynia.eventMenager.event;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrludynia.eventMenager.user.User;

import javax.validation.Valid;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;


@Controller
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/createEvent", method = RequestMethod.GET)
    public String createEvent(@ModelAttribute("event") Event event) {
        return "createEvent";
    }

    @RequestMapping(value = "/createEvent/confirm", method = RequestMethod.POST)
    public String confirmEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
        try {
            boolean score = eventService.created(event.getName(), event.getLocalization(),
                    event.getDate(), event.getAccess());
            model.addAttribute("eventCreated", score);

        } catch (Exception e) {
            e.getMessage();
        }
        if (result.hasErrors()) {
            return "createEvent";
        } else {
            return "confirmEvent";
        }
    }

    @RequestMapping(value = "/showEventList", method = RequestMethod.GET)
    public String showEventList(Model model) {
        List<Event> listOfEvents = eventService.listOfEvents();
        model.addAttribute("eventList", listOfEvents);
        return "eventList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEvent(@PathVariable long id, Model model) {
        eventService.deleteEvent(id);
        List<Event> listOfEvents = eventService.listOfEvents();
        model.addAttribute("eventList", listOfEvents);
        return "eventList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editEvent(@PathVariable long id, Model model) {
        model.addAttribute("event", eventService.get(id));
        model.addAttribute("eventList", eventService.listOfEvents());

        return "edit";
    }

    @RequestMapping(value = "/edit/{id}/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveEvent(Model model, @PathVariable Long id, @RequestParam String name, @RequestParam String localization,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        eventService.update(id, name, localization, date);
        model.addAttribute("event", eventService.listOfEvents());

        return "editSuccess";
    }

    @RequestMapping(value = "/searchEvents", method = RequestMethod.GET)
    public String findEvents(@RequestParam(required = false) String phrase, Model model) {
        model.addAttribute("eventList", eventService.findEveryEvent(phrase));
        return "eventList";
    }


}
