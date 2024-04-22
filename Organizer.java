import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Organizer {
    private ArrayList<Event> events;
    private HashMap<String, HashSet<String>> attendeeRSVPs;
    private HashMap<String, ArrayList<Customer>> eventCustomers;

    public Organizer(String name) {
        this.events = new ArrayList<>();
        this.attendeeRSVPs = new HashMap<>();
        this.eventCustomers = new HashMap<>();
    }

    public void createEvent(String name, String date, ArrayList<String> speakers) {
        events.add(new Event(name, date));
    }

    public void RSVP(String attendeeName, String eventName) {
        if (!attendeeRSVPs.containsKey(attendeeName)) {
            attendeeRSVPs.put(attendeeName, new HashSet<>());
        }
        attendeeRSVPs.get(attendeeName).add(eventName);
    }

    public void RSVP(Customer customer, String eventName) {
        if (!eventCustomers.containsKey(eventName)) {
            eventCustomers.put(eventName, new ArrayList<>());
        }
        eventCustomers.get(eventName).add(customer);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<Customer> getCustomersForEvent(String eventName) {
        return eventCustomers.get(eventName);
    }

    // Implement additional methods as needed
}
