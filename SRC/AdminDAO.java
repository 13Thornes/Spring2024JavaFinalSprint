// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


 /**
 * @author Samantha Throne
 * @version 1.00
 */
public class AdminDAO {

    /**
     * Adds an admin to the database
     * @param admin represents the admin added to the database
     * @throws SQLException to show that admin wasn't successfully added
     */
    public void addAdmin(Admin admin) throws SQLException{
       String sql = "INSERT INTO \"Admin\" (\"Username\", \"Position\") VALUES (?, ?)";

       try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement preparedStatement = conn.prepareStatement(sql);

           
           preparedStatement.setString(1, admin.getUsername());
           preparedStatement.setString(2, admin.getPosition());
           preparedStatement.executeUpdate();


           
       }
   }

   /**
    * Allows you to retrieve an admin ID
    * @param username accepts the admin's username
    * @return the admin id
    * @throws SQLException if getting admin ID is unsuccessful
    */
   public int getAdminID(String username) throws SQLException {
       String sql = "SELECT * FROM \"Admin\" WHERE \"Username\" = ?";
       try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement preparedStatement = conn.prepareStatement(sql);

           preparedStatement.setString(1, username);

           try (ResultSet rs = preparedStatement.executeQuery()){
               if (rs.next()) {
                   return rs.getInt("Admin_ID");
               }
           }
       }
       return 0;    
   }

   /**
    * Gets an admin from a user's username
    * @param user represents the user we're getting the username from
    * @return the Admin from the user table
    * @throws SQLException if fetching the admin is unsuccessful
    */
   public Admin getAdmin(User user) throws SQLException {
    String sql = "SELECT * FROM \"Admin\" WHERE \"Username\" = ?";
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, user.getUsername());

        try (ResultSet rs = preparedStatement.executeQuery()){
            if (rs.next()) {
                return new Admin(
                    user.getUsername(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getType(),
                    rs.getInt("Admin_ID"),
                    rs.getString("Position")
                );
            }
        }
    }
    return null;    
}
}
