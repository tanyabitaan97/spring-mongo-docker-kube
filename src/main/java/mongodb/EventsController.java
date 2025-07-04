package mongodb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@Profile({"prod","dev"})
public class EventsController {
	
	    @Autowired
	    private EventRepository eventRepository;

	    @GetMapping("/lastevent")
	    public Events getByIdUser() {
	        List<Events> userData = eventRepository.findAll();
	        return userData.get(userData.size()-1);
	    }
	    
	    @GetMapping
	    public List<Events> getAllEvents() {
	    	
	        return eventRepository.findAll();
	    }
	    
	    @PostMapping("/posteventdata")
	    public Events postEventData(@RequestBody Events eventsData) {
	    	
	    	return eventRepository.save(eventsData);
	    }
	    
	    @DeleteMapping("/postdata/{id}")
	    public ResponseEntity<String> deletePostData(@PathVariable String id) {
	    	eventRepository.deleteById(id);
	    	return new ResponseEntity<String>("Data got deleted successfully "+id, HttpStatus.OK);
	    }
	    
	    @PutMapping("/updatedata")
	    public ResponseEntity<List<Events>> updateData(@RequestBody Events eventsData) {
	    	List<Events> events = eventRepository.findByNameOfEvent(eventsData.getNameOfEvent());
	    	Events event = events.get(0);
	    	
	    	if(events.size()==0) {
	    		return new ResponseEntity<List<Events>>(events, HttpStatus.NOT_FOUND);
	    	}
	    	event.setDateOfInteraction(eventsData.getDateOfInteraction());
	    	event.setNameOfEvent(eventsData.getNameOfEvent());
	    	event.setAmount(eventsData.getAmount());
	    	
	    	Events updatedEvent = eventRepository.save(event);
	    	List<Events> savedList = new ArrayList<>();
	    	savedList.add(updatedEvent);
	    	return new ResponseEntity<List<Events>>(savedList, HttpStatus.OK);
	    }
	    
}
