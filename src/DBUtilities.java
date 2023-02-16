public class DBUtilities {
    private static final String dbName = "sbarramentoprova";
    private static final String url = "jdbc:mysql://localhost:3306/sbarramentoprova";
    private static final String user = "root";
    private static final String password = "root";

    public static String getDbName() {
        return dbName;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
