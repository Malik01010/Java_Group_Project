public class Conference extends Event {
    private int maxAttendees;
    private String[] guestSpeakers;

    public Conference(String name, String date, int max, String[] speakers) {
        super(name, date, "Conference");
        this.maxAttendees = max;
        this.guestSpeakers = speakers;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public String[] getGuestSpeakers() {
        return guestSpeakers;
    }
}
