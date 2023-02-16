import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    Map<String, User> mapActiveUsers = new HashMap<>();
    public User getUserData(String username) throws SQLException{

        User user1 = null;
        ResultSet rs = null;

        try(Connection connection = DriverManager.getConnection(DBUtilities.getUrl(), DBUtilities.getUser(), DBUtilities.getPassword());
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM sbarramentoprova.user WHERE username = ?")){
            ps.setString(1, username);

            rs = ps.executeQuery();

            if(rs.next()){
                user1 = new User(rs.getString("username"), rs.getString("email"),
                        rs.getString("password"), rs.getDate("registration_date"),
                        rs.getShort("active"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return user1;
    }

    public void fetchActiveUsers() throws SQLException{

        User user2 = null;
        ResultSet rs = null;

        try(Connection connection = DriverManager.getConnection(DBUtilities.getUrl(), DBUtilities.getUser(), DBUtilities.getPassword());
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM sbarramentoprova.user WHERE active != ?")){

            ps.setShort(1, (short) 0);

            rs = ps.executeQuery();

            while(rs.next()){
                user2 = new User(rs.getString("username"), rs.getString("email"),
                        rs.getString("password"), rs.getDate("registration_date"),
                        rs.getShort("active"));
                mapActiveUsers.put(rs.getString("username"), user2);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            rs.close();
        }

    }

    public Map<String, User> printMapActiveUsers(){
        return mapActiveUsers;
    }
}
