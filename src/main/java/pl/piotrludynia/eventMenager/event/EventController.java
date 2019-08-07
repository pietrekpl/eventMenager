package pl.piotrludynia.eventMenager.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String confirmEvent(@Valid @ModelAttribute("event") Event event, BindingResult result,Model model) {
        try {
            boolean score = eventService.created(event.getName(),event.getLocalization(),
                    event.getDate(),event.getAccess());
            model.addAttribute("eventCreated",score);

        }catch (Exception e){
            e.getMessage();
        }
        if (result.hasErrors()) {
            return "createEvent";
        } else {
            return "confirmEvent";
        }
    }
    @RequestMapping(value = "/showEventList", method = RequestMethod.GET)
    public String showEventList(Model model){
        List<Event> listOfEvents = eventService.listOfEvents();
        model.addAttribute("eventList",listOfEvents);
        return "eventList";
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public String deleteEvent(@PathVariable long id,Model model){
        eventService.deleteEvent(id);
        List<Event> listOfEvents = eventService.listOfEvents();
        model.addAttribute("eventList",listOfEvents);
        return "eventList";
    }
   @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editEvent(@PathVariable Long id, Model model){
        model.addAttribute("event",eventService.get(id) );
        model.addAttribute("eventList",eventService.listOfEvents());
        return "createEvent";
   }
    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("event")Event event,@PathVariable Long id){
        eventService.update(event.getId(),event.getName(),event.getLocalization(),event.getDate(),event.getAccess());
        return "edit";
    }
    @RequestMapping( value = "/searchEvents", method = RequestMethod.GET)
    public String findEvents(@RequestParam(required = false)String phrase, Model model){
    model.addAttribute("events",eventService.findEveryEvent(phrase));
    return "eventList";
    }









}
