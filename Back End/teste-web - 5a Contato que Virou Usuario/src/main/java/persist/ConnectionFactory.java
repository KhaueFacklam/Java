package persist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String URL = "jdbc:mysql://localhost/backend";
    private String USER = "backend";
    private String PASS = "1234";

    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASS);
        // return Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    }
}

