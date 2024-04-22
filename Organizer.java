import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Organizer {
   
    private ArrayList<Event> events;
    private HashMap<String, HashSet<String>> attendeeRSVPs;
  

    public Organizer(String name) {
 
        this.events = new ArrayList<>();
        this.attendeeRSVPs = new HashMap<>();
    }

    public void createEvent(String name, String date, String[] speakers) {
      
            events.add(new Event(name, date));
        
    }

    public void RSVP(String attendeeName, String eventName) {
        if (!attendeeRSVPs.containsKey(attendeeName)) {
            attendeeRSVPs.put(attendeeName, new HashSet<>());
        }
        attendeeRSVPs.get(attendeeName).add(eventName);
    }


    public ArrayList<Event> getEvents() {
        return events;
    }

    // Implement additional methods as needed
}
