import java.util.HashSet;

public class Attendee {
    private String attendeeName;
    private HashSet<String> attendedEvents;

    public Attendee(String name) {
        this.attendeeName = name;
        this.attendedEvents = new HashSet<>();
    }
    
    public String getName() {
        return attendeeName;
    }
    
    public void RSVP(String eventName) {
        attendedEvents.add(eventName);
    }


    public String getAttendeeName() {
        return attendeeName;
    }

    public HashSet<String> getAttendedEvents() {
        return attendedEvents;
    }
}
