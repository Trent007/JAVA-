import java.util.Scanner;
import java.util.Date;

interface FoodOrder {
  public void placeOrder(); // Method
  public void setAppointment(); // Method
}
class Cafe implements FoodOrder {
  private String[] menuOptions = {"Veggie Burger", "Grilled cheese", "lettuce with fries", "crayons", "soup stock"}; // Items on the menu
  private String foodChoice; //order placed
  private Date appointmentDate; // Time for the appointment

  public Cafe() {}
  // Overriding the placeOrder method from the order interface
  @Override
  public void placeOrder() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Welcome to the Cafe!");
    System.out.println("Please select the item number you would like to order:");
    // Menu items displayed onto screen
    for (int i = 0; i < menuOptions.length; i++) {
      System.out.println((i + 1) + ". " + menuOptions[i]);
    }
    // User input 
    int menuSelection = userInput.nextInt();
    // Select the item based on the menu number 
    switch (menuSelection) {
    case 1:
      foodChoice = "Veggie Burger";
      break;
    case 2:
      foodChoice = "Grilled cheese";
      break;
    case 3:
      foodChoice = "lettuce with fries";
      break;
    case 4:
      foodChoice = "crayons";
      break;
    case 5:
      foodChoice = "soup stock";
      break;
    default:
      System.out.println("Invalid item number. Please try again.");
    }
    System.out.println("You have ordered a " + foodChoice + ".");
  }
  // Overriding the method from the interface
  @Override
  public void setAppointment() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the date and time for your appointment (MM/dd/yyyy HH:mm):");
    String appointmentInput = userInput.nextLine();
    appointmentDate = new Date(appointmentInput);
    System.out.println("Your appointment is set for " + appointmentDate + ".");
  }
  // method to access private order variable 
  public String getFoodChoice() {
    return foodChoice;
  }
// Method to access the private appointment variable 
  public Date getAppointmentDate() {
    return appointmentDate;
  }
}
class Delivery extends Cafe {
  private String deliveryLocation;
  public Delivery() {}
  public void setDeliveryLocation() {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter your delivery address:");
    deliveryLocation = userInput.nextLine();
    System.out.println("Delivery address set to " + deliveryLocation + ".");
  }
  //method to access private delivery variable 
  public String getDeliveryLocation() {
    return deliveryLocation;
  }
}
public class CafeApp {
  public static void main(String[] args) {
    Delivery delivery = new Delivery(); //Create an instance of class
    delivery.placeOrder(); 
    delivery.setAppointment();
    delivery.setDeliveryLocation(); // Call method from class1
    System.out.println("Order Summary:"); // print header of order summary
    System.out.println("Item ordered: " + delivery.getFoodChoice());
    System.out.println("Appointment: " + delivery.getAppointmentDate());
    System.out.println("Delivery Address: " + delivery.getDeliveryLocation());
  }
}