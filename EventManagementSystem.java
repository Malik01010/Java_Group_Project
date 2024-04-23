import java.util.ArrayList;
import java.util.Scanner;

public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Organizer organizer = new Organizer("Event Organizer Inc.");
        
        
        preLoadData(organizer);
        boolean exit = false;
        while (!exit) {
          EventUtils.printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                   
                    boolean exitSubMenu = false;
                    while (!exitSubMenu) {
                        EventUtils.printMenu();
                        int subChoice = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (subChoice) {
                            case 1:
                                Event.createEvent(organizer, scanner);
                                break;
                           
                            case 2:
                                Event.viewEvents(organizer);
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
                	CRMSystem crmSystem = new CRMSystem(organizer);
                    crmSystem.handleCRMScenario(scanner);
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

        Customer customer = new Customer(attendeeName, "", "", ""); 

        organizer.RSVP(customer, eventName);

        System.out.println("RSVP successful!");
    } 
   

    private static void viewAttendeeDetails(Organizer organizer, Scanner scanner) {
        System.out.println("Enter attendee name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name (or leave blank to view all attended events):");
        String eventName = scanner.nextLine();

        
        Customer customer = organizer.findCustomerByName(attendeeName);

        if (customer != null) {
           
            System.out.println("Attendee Details:");
            System.out.println("Name: " + customer.getName());
            System.out.println("Industry: " + customer.getIndustry());
            System.out.println("Workplace: " + customer.getWorkplace());
            System.out.println("Phone Number: " + customer.getPhoneNumber());

           
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
    	
    	String[] speakers1 = new String[2];
        for(int i=0; i > 1; i++){
        speakers1[i]= ("Speaker" + i);
        }
        
        String[] speakers2 = new String[2];
        for(int j=0; j > 1; j++) {
        	speakers2[j] = ("Speaker" + j);
        }
        
        organizer.createEvent("Introduction to Java", "01/09/2024", speakers1);
        organizer.createEvent("Java Final Project", "04/25/2024", speakers2 );
    
        Customer customer1 = new Customer("Customer 1", "Industry 1", "Workplace 1", "Phone 1");
        Customer customer2 = new Customer("Customer 2", "Industry 2", "Workplace 2", "Phone 2");
        Customer customer3 = new Customer("Customer 3", "Industry 3", "Workplace 3", "Phone 3");

        
        organizer.RSVP(customer1, "Conference 1");
        organizer.RSVP(customer2, "Conference 1");
        organizer.RSVP(customer3, "Conference 2");
        
    }
}
