import java.util.HashSet;

public class Attendee {
    private String attendeeName;
    private HashSet<String> attendedEvents;

    public Attendee(String name) {
        this.attendeeName = name;
        this.attendedEvents = new HashSet<>();
    }

    public void RSVP(String eventName) {
        attendedEvents.add(eventName);
    }

    public void submitFeedback(String eventName, String feedback) {
        // Submit feedback for the event
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public HashSet<String> getAttendedEvents() {
        return attendedEvents;
    }
}


}
