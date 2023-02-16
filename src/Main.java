import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDao();

        System.out.println(userDao.getUserData("pasquale"));
        userDao.fetchActiveUsers();
        System.out.println(userDao.printMapActiveUsers());
    }
}