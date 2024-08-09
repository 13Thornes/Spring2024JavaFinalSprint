import java.util.Scanner;

public class AdminMenu {
    public static void main(String[] args) {

        // This is not done yet

        System.out.println("Welcome to the Admin Menu");

        System.out.println("1. View Users");
        System.out.println("2. Add User");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Please select option 1-4");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                validInput = true;

                switch (choice) {
                    case 1:
                        // view users
                        System.out.println("Displaying all users...");
                        // Code to view users would go here
                        break;

                    case 2:
                        // add user
                        int userID;
                        String username;
                        String password;
                        String firstName;
                        String lastName;
                        String email;
                        String phoneNumber;

                        System.out.println("Please enter the user ID:");
                        userID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.println("Enter the username:");
                        username = scanner.nextLine();

                        System.out.println("Enter the password:");
                        password = scanner.nextLine();

                        System.out.println("Enter the first name:");
                        firstName = scanner.nextLine();

                        System.out.println("Enter the last name:");
                        lastName = scanner.nextLine();

                        System.out.println("Enter the email:");
                        email = scanner.nextLine();

                        System.out.println("Enter the phone number:");
                        phoneNumber = scanner.nextLine();

                        // User newUser = new User(userID, username, password, firstName, lastName, email, phoneNumber);
                        // Code to add user would go here

                        break;

                    case 3:
                        // update user
                        System.out.println("Updating user information...");
                        // Code to update user would go here
                        break;

                    case 4:
                        // delete user
                        System.out.println("Deleting user...");
                        // Code to delete user would go here
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }

            } else {
                System.out.println("Invalid Input");
            }
        }

        validInput = false;
        scanner.close();
    }
}
