import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Organizer {
    private String organizerName;
    private ArrayList<Event> events;
    private HashMap<String, HashSet<String>> attendeeRSVPs;
    private HashMap<String, HashMap<String, String>> eventFeedback;

    public Organizer(String name) {
        this.organizerName = name;
        this.events = new ArrayList<>();
        this.attendeeRSVPs = new HashMap<>();
        this.eventFeedback = new HashMap<>();
    }

    public void createEvent(String name, String date, String type, int max, String[] speakers) {
        if (type.equals("Conference")) {
            events.add(new Conference(name, date, max, speakers));
        } else {
            // Handle other types of events
        }
    }

    public void RSVP(String attendeeName, String eventName) {
        if (!attendeeRSVPs.containsKey(attendeeName)) {
            attendeeRSVPs.put(attendeeName, new HashSet<>());
        }
        attendeeRSVPs.get(attendeeName).add(eventName);
    }

    public void submitFeedback(String eventName, String attendeeName, String feedback) {
        if (!eventFeedback.containsKey(eventName)) {
            eventFeedback.put(eventName, new HashMap<>());
        }
        eventFeedback.get(eventName).put(attendeeName, feedback);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    // Implement additional methods as needed
}
