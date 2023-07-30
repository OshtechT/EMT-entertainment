package Entertainment.EMT.EMTShop;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public Optional<Event> getEvent(String title){
        return eventRepository.getEventByTitle(title);
    }

    public Event getEvent(Event event){
        Optional<Event> e = eventRepository.getEventByTitle(event.getTitle());
        if(e.isPresent()){
            Event ev = eventRepository.getReferenceById(e.get().getID());
            return ev;
        }else{
            throw new IllegalStateException("Event not here");
        }

    }
    public List<Event> getEvents() {

        return eventRepository.findAll();
    }
    public void addEvent(Event event) throws IllegalAccessException {
        Optional<Event> e = eventRepository.getEventByTitle(event.getTitle());
        if(e.isPresent()){
            throw new IllegalAccessException("event already exist");
        }
        eventRepository.save(event);

    }

    public void deleteEvent(Long id) {
        boolean exists = eventRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("event ID "+id+" does not exist");
        }
        eventRepository.deleteById(id);

    }
    public void deleteEventByEvent(Event event) {
        Optional<Event> e = eventRepository.getEventByTitle(event.getTitle());
        if(!e.isPresent()){
            throw new IllegalStateException("event "+e.get().title+" does not exist");
        }else {
            eventRepository.delete(e.get());
        }
    }

    @Transactional
    public void updateEvent(Long id, String title, String location, String street, String postcode, String date) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("event ID "+id+" does not exist"));

        if(title != null && title.length() > 0 && !Objects.equals(event.getTitle(), title)){
            event.setTitle(title);
        }
        if(location != null && location.length() > 0 && !Objects.equals(event.getLocation(), location)){
            event.setLocation(location);
        }
        if(street != null && street.length() > 0 && !Objects.equals(event.getStreet(), street)){
            event.setStreet(street);
        }
        if(postcode != null && postcode.length() > 0 && !Objects.equals(event.getPostcode(), postcode)){
            event.setPostcode(postcode);
        }
        if(date != null && date.length() > 0 && !Objects.equals(event.getDate(), date)){
            event.setDate(date);
        }



    }


}
