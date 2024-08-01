import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    private int adminID;
    private String position;

    public Admin(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type, int adminID, String position){
        super(username, password, firstName, lastName, email, phoneNumber, type);
        this.adminID = adminID;
        this.position = position;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getPosition() {
        return position;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public void veiwUser(ArrayList <User> users){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String username;
        System.out.println("Enter the username for the account you wish to veiw: " );
        username = scanner.next();

        for (User user: users){
            if (user.getUsername().equals(username)){
                System.out.println(user.toString());
                valid = true;
            }
        }

        if(valid == false){
            System.out.println("User is not in database");
        }

    }

    public void veiwUsers(ArrayList <User> users){
        for (User user: users){

                System.out.println(user.toString());      
        }

    } 
    
    public int deleteUser(ArrayList <User> users, String username){
        boolean valid = false;
        User reUser = new User();
        for (User user: users){
            if (user.getUsername().equals(username)){
                reUser = user;
                valid = true;
            }
        }

        if(valid == false){
            throw new NullPointerException(username + " Is not in the database");
        }
        
            users.remove(reUser);
            System.out.println("User removed");
        
            return adminID;
    }

    //Veiw Products

    @Override
    public String toString() {
        return(super.toString() + "\n Admin{\nAdminID = " + adminID +
        "\nPosition = " + position + "\n}"); 
    }
}
