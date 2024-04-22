
import java.util.Scanner;

public class Customer extends Attendee {
    private String lastContacted;
    private String industry;
    private String workplace;
    private String phoneNumber;

    public Customer(String name, String industry, String workplace, String phoneNumber) {
        super(name);
        lastContacted = "2024-04-25";
        this.industry = industry;
        this.workplace = workplace;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return super.getName();
    }
    
    public void setLastContacted(String lastContacted) {
    	this.lastContacted = lastContacted;
    }
    
    public String getLastContacted() {
        return lastContacted;
    }

    public void updateLastContacted() {
        this.lastContacted = new String();
    }

    public String getIndustry() {
        return industry;
    }

    public String getWorkplace() {
        return workplace;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public static void addCustomer(Organizer organizer, Scanner scanner) {
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer industry:");
        String industry = scanner.nextLine();
        System.out.println("Enter customer workplace:");
        String workplace = scanner.nextLine();
        System.out.println("Enter customer phone number:");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(name, industry, workplace, phoneNumber);
        organizer.addCustomer(customer);
        System.out.println("Customer added successfully!");
    }
    
}