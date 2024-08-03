import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public void addAdmin(Admin admin) throws SQLException{
       String sql = "INSERT INTO \"Admin\" (\"Username\", \"Position\") VALUES (?, ?)";

       try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement preparedStatement = conn.prepareStatement(sql);

           
           preparedStatement.setString(1, admin.getUsername());
           preparedStatement.setString(2, admin.getPosition());
           preparedStatement.executeUpdate();


           
       }
   }
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
}
