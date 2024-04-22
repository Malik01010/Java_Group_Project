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
                                EventUtils.createEvent(organizer, scanner);
                                break;
                            case 2:
                                RSVPToEvent(organizer, scanner);
                                break;
                            case 3:
                                EventUtils.viewEvents(organizer);
                                break;
                            case 4:
                                viewAttendeeDetails(organizer, scanner);
                                break;
                            case 5:
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

    
   

   

    private static void RSVPToEvent(Organizer organizer, Scanner scanner) {
        System.out.println("Enter your name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name you want to RSVP to:");
        String eventName = scanner.nextLine();

        organizer.RSVP(attendeeName, eventName);
        System.out.println("RSVP successful!");
    }

   

   

    private static void viewAttendeeDetails(Organizer organizer, Scanner scanner) {
        System.out.println("Enter attendee name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name (or leave blank to view all attended events):");
        String eventName = scanner.nextLine();

        // Implement logic to view attendee details based on the provided information
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
    }
