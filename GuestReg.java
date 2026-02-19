import java.util.Scanner;

class Guest {

    protected String guestId;
    protected String guestName;
    protected String knownAs;
    protected String description;
    protected String seatNumber;
    protected String invitationCode;

   
    protected static int seatCounter = 50;
    protected static int inviteCounter = 1000;

   
    public Guest(String guestName, String knownAs, String description) {
        this.guestName = guestName;
        this.knownAs = knownAs;
        this.description = description;

        this.seatNumber = "S" + (seatCounter++);
        this.invitationCode = "INV" + (inviteCounter++);
    }

    
    public void displayGuestDetails() {
        System.out.println("Guest ID       : " + guestId);
        System.out.println("Name           : " + guestName);
        System.out.println("Known As       : " + knownAs);
        System.out.println("Description    : " + description);
        System.out.println("Seat Number    : " + seatNumber);
        System.out.println("Invitation Code: " + invitationCode);
    }
}

class CelebrityGuest extends Guest {

    protected static int celebrityCounter = 100;

    public CelebrityGuest(String guestName, String knownAs, String description) {
        super(guestName, knownAs, description);
        this.guestId = "C" + (celebrityCounter++);
    }
}

class GovernmentGuest extends Guest {

    protected static int governmentCounter = 500;

    public GovernmentGuest(String guestName, String knownAs, String description) {
        super(guestName, knownAs, description);
        this.guestId = "G" + (governmentCounter++);
    }
}

public class GuestReg {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to School Re-Opening Event Registration");
        System.out.print("Enter number of guests to register: ");
        int numberOfGuests = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= numberOfGuests; i++) {

            System.out.println("\nRegistering Guest " + i);
            System.out.println("Select Guest Type:");
            System.out.println("1. Celebrity Guest");
            System.out.println("2. Government Guest");
             int choice;

        while (true) {
            System.out.print("Enter choice (1 or 2 only): ");
            choice = sc.nextInt();
            sc.nextLine();

        if (choice == 1 || choice == 2) {
        break;
        } else {
        System.out.println("Invalid choice! Please select 1 or 2 only.");
         }
         }


            System.out.print("Enter Guest Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Known As (Singer/Collector/etc): ");
            String knownAs = sc.nextLine();

            System.out.print("Enter Short Description: ");
            String description = sc.nextLine();

            Guest guest;

            if (choice == 1) {
                guest = new CelebrityGuest(name, knownAs, description);
            } else {
                guest = new GovernmentGuest(name, knownAs, description);
            }

            System.out.println("\n Guest Registered Successfully ");
            guest.displayGuestDetails();
        }

        sc.close();
    }
}
