import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Organizer {
    private ArrayList<Event> events;
    private HashMap<String, HashSet<String>> attendeeRSVPs;
    private HashMap<String, ArrayList<Customer>> eventCustomers;
    private ArrayList<Customer> allCustomers;

    public Organizer(String name) {
        this.events = new ArrayList<>();
        this.attendeeRSVPs = new HashMap<>();
        this.eventCustomers = new HashMap<>();
        this.allCustomers = new ArrayList<>();
    }

    public void createEvent(String name, String date, String[] speakers) {
        events.add(new Event(name, date));
        
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
    
    public void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }
    public Customer findCustomerByName(String name) {
        for (Customer customer : allCustomers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    public boolean customerAttendedEvent(Customer customer, String eventName) {
        ArrayList<Customer> customers = eventCustomers.get(eventName);
        return customers != null && customers.contains(customer);
    }

}
