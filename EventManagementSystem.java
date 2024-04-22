import java.util.ArrayList;
import java.util.Scanner;

public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Organizer organizer = new Organizer("Event Organizer Inc.");
        
        // Pre-loading data (optional)
        preLoadData(organizer);
        boolean exit = false;
        while (!exit) {
          EventUtils.printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Existing logic
                    boolean exitSubMenu = false;
                    while (!exitSubMenu) {
                        EventUtils.printMenu();
                        int subChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        switch (subChoice) {
                            case 1:
                                Event.createEvent(organizer, scanner);
                                break;
                           
                            case 2:
                                EventUtils.viewEvents(organizer);
                                break;
                            case 3:
                                viewAttendeeDetails(organizer, scanner);
                                break;
                            case 4:
                                exitSubMenu = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                case 2:
                    // Return the list of customers for a given event
                	CRMSystem crmSystem = new CRMSystem(organizer);
                    crmSystem.handleCRMScenario(scanner);
                    // Place your alternative logic here
                    break;
                 
                case 3:
                    exit = true;
                    System.out.println("Exiting Event Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();

    }
    public static void RSVPToEvent(Organizer organizer, Scanner scanner) {
        System.out.println("Enter your name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name you want to RSVP to:");
        String eventName = scanner.nextLine();

        // Create a new Customer object with the provided name
        Customer customer = new Customer(attendeeName, "", "", ""); // You may need additional information here

        // Call the RSVP method on the Organizer instance
        organizer.RSVP(customer, eventName);

        System.out.println("RSVP successful!");
    } 
   

    private static void viewAttendeeDetails(Organizer organizer, Scanner scanner) {
        System.out.println("Enter attendee name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name (or leave blank to view all attended events):");
        String eventName = scanner.nextLine();

        // Implement logic to view attendee details based on the provided information
        Customer customer = organizer.findCustomerByName(attendeeName);

        if (customer != null) {
            // Print the customer's details
            System.out.println("Attendee Details:");
            System.out.println("Name: " + customer.getName());
            System.out.println("Industry: " + customer.getIndustry());
            System.out.println("Workplace: " + customer.getWorkplace());
            System.out.println("Phone Number: " + customer.getPhoneNumber());

            // If the event name is provided, check if the customer attended that event
            if (!eventName.isEmpty()) {
                if (organizer.customerAttendedEvent(customer, eventName)) {
                    System.out.println("This attendee attended the event: " + eventName);
                } else {
                    System.out.println("This attendee did not attend the event: " + eventName);
                }
            }
        } else {
            System.out.println("Attendee not found.");
        }
    }

    private static void preLoadData(Organizer organizer) {
    	//using an array list here because we can have duplicate values for speakers.
        ArrayList<String> speakers1 = new ArrayList<>();
        speakers1.add("Speaker 1");
        speakers1.add("Speaker 2");

        ArrayList<String> speakers2 = new ArrayList<>();
        speakers2.add("Speaker A");
        speakers2.add("Speaker B");

        organizer.createEvent("Conference 1", "2024-05-01", speakers1);
        organizer.createEvent("Conference 2", "2024-05-15", speakers2);
        
        Customer customer1 = new Customer("Customer 1", "Industry 1", "Workplace 1", "Phone 1");
        Customer customer2 = new Customer("Customer 2", "Industry 2", "Workplace 2", "Phone 2");
        Customer customer3 = new Customer("Customer 3", "Industry 3", "Workplace 3", "Phone 3");

        // RSVP the customers to the events
        organizer.RSVP(customer1, "Conference 1");
        organizer.RSVP(customer2, "Conference 1");
        organizer.RSVP(customer3, "Conference 2");
        
    }
}
